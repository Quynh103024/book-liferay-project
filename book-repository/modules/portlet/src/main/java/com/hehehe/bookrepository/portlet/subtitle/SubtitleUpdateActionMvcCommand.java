package com.hehehe.bookrepository.portlet.subtitle;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET,
        "mvc.command.name=subtitle/update/save"
    },
    service = MVCActionCommand.class
)
public class SubtitleUpdateActionMvcCommand extends BaseMVCActionCommand {

    @Reference
    private SubtitleService subtitleService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String subtitleId = ParamUtil.getString(actionRequest, "subtitleId");
        String name = ParamUtil.getString(actionRequest, "name").trim();

        // Kiểm tra rỗng
        if (name == null || name.isEmpty()) {
            SessionErrors.add(actionRequest, "name-required");
            return;
        }

        try {
            Subtitle subtitle = subtitleService.getSubtitleById(subtitleId);
            String oldName = subtitle.getName();

            // Nếu không thay đổi tên
            if (oldName.equalsIgnoreCase(name)) {
                return;
            }

            // Kiểm tra trùng lặp
            if (subtitleService.isExist(name) && !oldName.equalsIgnoreCase(name)) {
                SessionErrors.add(actionRequest, "name-already-exists");
                return;
            }

            // Cập nhật tên mới
            subtitle.setName(name);
            subtitleService.updateSubtitle(subtitle);
        } catch (PortalException e) {
            SessionErrors.add(actionRequest, "failed-to-update-subtitle");
        }
    }
}
