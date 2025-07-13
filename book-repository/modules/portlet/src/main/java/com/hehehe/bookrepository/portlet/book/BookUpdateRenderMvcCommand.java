package com.hehehe.bookrepository.portlet.book;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.servicebuilder.service.BookService;
import com.hehehe.servicebuilder.service.CategoryService;
import com.hehehe.servicebuilder.service.SubtitleService;
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
				"javax.portlet.name=" + BookPortletKeys.BOOKPORTLET,
				"mvc.command.name=book/update/view"
		},
		service = MVCRenderCommand.class)
public class BookUpdateRenderMvcCommand implements MVCRenderCommand {
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
		try {
			renderRequest.setAttribute("book", this.bookService.getBook(bookId));
			renderRequest.setAttribute("allAuthor", this.authorService.getAllAuthor());
			renderRequest.setAttribute("allCategory", this.categoryService.getAllCategory());
			renderRequest.setAttribute("allSubtitle", this.subtitleService.getAllSubtitle());
		} catch (PortalException e) {
			SessionErrors.add(renderRequest, "invalid-book");
		}
		return "/book/update.jsp";
	}
}
