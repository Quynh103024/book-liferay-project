package com.hehehe.bookrepository.portlet.subtitle;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
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
				"mvc.command.name=subtitle/delete/save" }, 
		service = MVCActionCommand.class)
public class SubtitleDeleteActionMvcCommand extends BaseMVCActionCommand {
	@Reference
    private SubtitleService subtitleService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String subtitleId = ParamUtil.getString(actionRequest,"subtitleId");
		try {
			this.subtitleService.deleteSubtitle(subtitleId);
		} catch(PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-delete-subtitle");
		}
	}
}
