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
				"mvc.command.name=subtitle/update/save" }, 
		service = MVCActionCommand.class)
public class SubtitleUpdateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
    private SubtitleService subtitleService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String subtitleId = ParamUtil.getString(actionRequest, "subtitleId");
		String name = ParamUtil.getString(actionRequest, "name");
		try {
			Subtitle subtitle = this.subtitleService.getSubtitleById(subtitleId);
			subtitle.setName(name);
			this.subtitleService.updateSubtitle(subtitle);
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-update-subtitle");
		}
	}
}
