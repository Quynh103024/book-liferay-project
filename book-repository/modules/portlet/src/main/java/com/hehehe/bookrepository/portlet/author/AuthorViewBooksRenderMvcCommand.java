package com.hehehe.bookrepository.portlet.author;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.BookService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
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
	        "mvc.command.name=author/books/view"
	    },
	    service = MVCRenderCommand.class
	)
	public class AuthorViewBooksRenderMvcCommand implements MVCRenderCommand {
	    @Reference
	    private BookService bookService;
	    
	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	        String authorId = ParamUtil.getString(renderRequest, "authorId").trim();
	        List<Book> books = new ArrayList<>();
	        
			try {
				books = bookService.getBooksByAuthorId(authorId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        renderRequest.setAttribute("books", books);
	        
	        return "/author/view_books.jsp";
	    }
	}

