package com.hehehe.bookrepository.portlet.category;

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
        "javax.portlet.name=" + BookPortletKeys.CATEGORYPORTLET,
        "mvc.command.name=category/books/view"
    },
    service = MVCRenderCommand.class
)
public class CategoryViewBooksRenderMvcCommand implements MVCRenderCommand {

    @Reference
    private BookService bookService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String categoryId = ParamUtil.getString(renderRequest, "categoryId").trim();
        List<Book> books = new ArrayList<>();

        books = bookService.getBooksByCategoryId(categoryId);

        renderRequest.setAttribute("books", books);

        return "/category/view_books.jsp";
    }
}
