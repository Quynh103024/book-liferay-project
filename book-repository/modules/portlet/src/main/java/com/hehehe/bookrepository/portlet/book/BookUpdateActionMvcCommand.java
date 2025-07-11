package com.hehehe.bookrepository.portlet.book;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.BookService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + BookPortletKeys.BOOKPORTLET,
				"mvc.command.name=book/update/save" }, 
		service = MVCActionCommand.class)
public class BookUpdateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private BookService bookService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String bookId = ParamUtil.getString(actionRequest, "bookId");
		String title = ParamUtil.getString(actionRequest, "title", null);
		String description = ParamUtil.getString(actionRequest, "description", null);
		String thumbnail = ParamUtil.getString(actionRequest, "thumbnail", null); 
		String subtitleId = ParamUtil.getString(actionRequest, "subtitleId", null);
		String categoryId = ParamUtil.getString(actionRequest, "categoryId", null);
		String[] authorIdsArray = ParamUtil.getParameterValues(actionRequest, "authorIds");
		List<String> authorIds = Arrays.asList(authorIdsArray);
		Integer price = ParamUtil.getInteger(actionRequest, "price");
		Integer stock = ParamUtil.getInteger(actionRequest, "stock");
		Integer pages = ParamUtil.getInteger(actionRequest, "pages");
		Integer publicYear = ParamUtil.getInteger(actionRequest, "publicYear");
		try {
			Book book = this.bookService.getBook(bookId);
			book.setTitle(title);
			book.setDescription(description);
			book.setThumbnail(thumbnail);
			book.setSubtitleId(subtitleId);
			book.setCategoryId(categoryId);
			book.setPrice(price);
			book.setNum_pages(pages);
			book.setStock(stock);
			book.setPublished_year(publicYear);
			this.bookService.addAuthers(authorIds, bookId);
			this.bookService.updateBook(book);
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-update-book");
		}
	}
}
