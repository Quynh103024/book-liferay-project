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
				"mvc.command.name=subtitle/create/save" }, 
		service = MVCActionCommand.class)
public class SubtitleCreateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private SubtitleService subtitleService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Subtitle create");
		String name = ParamUtil.get(actionRequest, "name", "");
		
		if (Validator.isNull(name)) {
	        SessionErrors.add(actionRequest, "required-fields-missing");
	        System.out.println(" falled");
	        return;
	    }
		this.subtitleService.addSubtitle(name);
	}
}