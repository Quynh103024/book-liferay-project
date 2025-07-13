package com.hehehe.bookrepository.portlet.subtitle;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET,
        "mvc.command.name=subtitle/create/save"
    },
    service = MVCActionCommand.class
)
public class SubtitleCreateActionMvcCommand extends BaseMVCActionCommand {

    @Reference
    private SubtitleService subtitleService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        System.out.println("Subtitle create");

        String name = ParamUtil.get(actionRequest, "name", "").trim();

        // Check null
        if (Validator.isNull(name)) {
            SessionErrors.add(actionRequest, "required-fields-missing");
            return;
        }

        // Check special characters
        if (!name.matches("^[\\p{L} .'-]+$")) {
            SessionErrors.add(actionRequest, "invalid-subtitle-name");
            return;
        }

        // Check length
        if (name.length() < 3 || name.length() > 100) {
            SessionErrors.add(actionRequest, "subtitle-name-length-invalid");
            return;
        }

        // Check duplicate
        if (subtitleService.isExist(name)) {
            SessionErrors.add(actionRequest, "subtitle-name-exists");
            return;
        }

        // Add new subtitle
        this.subtitleService.addSubtitle(name);
    }
}
