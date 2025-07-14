package com.hehehe.bookrepository.portlet.author;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.servicebuilder.service.BookService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BookPortletKeys.AUTHORPORTLET,
	        "mvc.command.name=author/detail/view"
	    },
	    service = MVCRenderCommand.class
	)
	public class AuthorDetailRenderMvcCommand implements MVCRenderCommand {

	    @Reference
	    private AuthorService authorService;

	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	        String authorId = ParamUtil.getString(renderRequest, "authorId");
        	List<Author> authorsCollab = new ArrayList<>();
	        try {
	        	Author author = authorService.getAuthorById(authorId);
	        	authorsCollab = authorService.getAuthorsCollaborate(authorId);
	            renderRequest.setAttribute("author", author);
	            renderRequest.setAttribute("authors", authorsCollab);
	        } catch (Exception e) {
	            SessionErrors.add(renderRequest, "author-not-found");
	        }
	        return "/author/details.jsp";
	    }
	}

