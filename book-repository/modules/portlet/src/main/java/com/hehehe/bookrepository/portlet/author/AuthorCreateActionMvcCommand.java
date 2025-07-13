package com.hehehe.bookrepository.portlet.author;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.AuthorService;
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
				"javax.portlet.name=" + BookPortletKeys.AUTHORPORTLET,
				"mvc.command.name=author/create/save" }, 
		service = MVCActionCommand.class)
public class AuthorCreateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private AuthorService authorService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Author create");
		String name = ParamUtil.get(actionRequest, "name", "").trim();
		
		// Check null
		if (Validator.isNull(name)) {
	        SessionErrors.add(actionRequest, "required-fields-missing");
	        System.out.println(" falled");
	        return;
	    }
		
		// Check special characters
		if (!name.matches("^[\\p{L} .'-]+$")) {
		    SessionErrors.add(actionRequest, "invalid-author-name");
		    return;
		}

		// Check length
		if (name.length() < 3 || name.length() > 100) {
		    SessionErrors.add(actionRequest, "author-name-length-invalid");
		    return;
		}

		// Check duplicate
		if (authorService.isExist(name)) {
		    SessionErrors.add(actionRequest, "author-name-exists");
		    return;
		}
		
		// Add one
		this.authorService.addAuthor(name);
	}
}