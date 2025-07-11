package com.hehehe.bookrepository.portlet.author;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.AuthorService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + BookPortletKeys.AUTHORPORTLET,
				"mvc.command.name=author/update/view"
		},
		service = MVCRenderCommand.class)
public class AuthorUpdateRenderMvcCommand implements MVCRenderCommand {
	@Reference
	private AuthorService authorService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		String authorId = ParamUtil.getString(renderRequest, "authorId");
		try {
			renderRequest.setAttribute("author", authorService.getAuthorById(authorId));
		} catch (PortalException e) {
			SessionErrors.add(renderRequest, "invalid-author");
		}
		return "/author/update.jsp";
	}
}