package com.hehehe.bookrepository.portlet.author;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.service.AuthorService;
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
				"javax.portlet.name=" + BookPortletKeys.AUTHORPORTLET,
				"mvc.command.name=author/update/save" }, 
		service = MVCActionCommand.class)
public class AuthorUpdateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private AuthorService authorService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String authorId = ParamUtil.getString(actionRequest, "authorId");
		String name = ParamUtil.getString(actionRequest, "name");
		try {
			Author author = this.authorService.getAuthorById(authorId);
			author.setName(name);
			this.authorService.updateAuthor(author);
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-update-author");
		}
	}
}
