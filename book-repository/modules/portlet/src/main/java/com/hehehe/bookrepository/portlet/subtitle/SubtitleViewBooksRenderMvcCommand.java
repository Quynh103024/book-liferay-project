package com.hehehe.bookrepository.portlet.subtitle;

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
        "javax.portlet.name=" + BookPortletKeys.SUBTITLEPORTLET,
        "mvc.command.name=subtitle/books/view"
    },
    service = MVCRenderCommand.class
)
public class SubtitleViewBooksRenderMvcCommand implements MVCRenderCommand {

    @Reference
    private BookService bookService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String subtitleId = ParamUtil.getString(renderRequest, "subtitleId").trim();
        List<Book> books = new ArrayList<>();

        books = bookService.getBooksBySubtitleId(subtitleId);

        renderRequest.setAttribute("books", books);

        return "/subtitle/view_books.jsp";
    }
}
