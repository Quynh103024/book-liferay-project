package com.hehehe.bookrepository.portlet.book;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.servicebuilder.service.BookService;
import com.hehehe.servicebuilder.service.CategoryService;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.liferay.marketplace.exception.NoSuchModuleException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BookPortletKeys.BOOKPORTLET,
		"mvc.command.name=book/view/detail" }, service = MVCRenderCommand.class)

public class BookDetailRenderCommand implements MVCRenderCommand {
	@Reference
	private BookService bookService;
	@Reference
	private CategoryService categoryService;
	@Reference
	private SubtitleService subtitleService;
	@Reference
	private AuthorService authorService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		String bookId = ParamUtil.getString(renderRequest, "bookId");
		if (Validator.isNull(bookId)) {
			SessionErrors.add(renderRequest, "book-id-missing");
			return "/book/error.jsp";
		}

		try {
			Book book = bookService.getBook(bookId);

			// Lấy Subtitle và Category
			Subtitle subtitle = subtitleService.getSubtitleById(book.getSubtitleId());
			Category category = categoryService.getCategoryById(book.getCategoryId());
			List<Author> authors = bookService.getAuthors(bookId);
			System.out.println("Book ID: " + bookId);
			System.out.println("Authors size: " + (authors == null ? "null" : authors.size()));
			for (Author a : authors) {
			    System.out.println("Author name: " + a.getName());
			}

			renderRequest.setAttribute("book", book);
			renderRequest.setAttribute("category", category);
			renderRequest.setAttribute("subtitle", subtitle);
			renderRequest.setAttribute("authors", authors);

			return "/book/detail.jsp";

		} catch (PrincipalException e) {
			SessionErrors.add(renderRequest, "permission-denied");
			return "/book/error.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(renderRequest, "unexpected-error");
			return "/book/error.jsp";
		} 
	}

}
