package com.hehehe.bookrepository.portlet.book;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.BookService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

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
		
		if (Validator.isNull(title) || Validator.isNull(description)) {
			SessionErrors.add(actionRequest, "required-fields-missing");
			System.out.println("title hoặc description bị thiếu");
			return;
		}

		if (Validator.isNull(thumbnail) || Validator.isNull(subtitleId) || Validator.isNull(categoryId)) {
			SessionErrors.add(actionRequest, "required-fields-missing");
			System.out.println("thumbnail, subtitleId hoặc categoryId bị thiếu");
			return;
		}

		if (authorIds == null || authorIds.isEmpty()) {
			SessionErrors.add(actionRequest, "author-required");
			System.out.println("Không có tác giả nào được chọn");
			return;
		}

		for (String authorId : authorIds) {
			if (Validator.isNull(authorId) || !authorId.matches("^[0-9a-zA-Z_-]+$")) {
				SessionErrors.add(actionRequest, "invalid-author-id");
				System.out.println("Author ID không hợp lệ: " + authorId);
				return;
			}
		}

		if (price == null || price <= 0 || stock == null || stock < 0 || pages == null || pages <= 0 || publicYear == null || publicYear < 105) {
			SessionErrors.add(actionRequest, "invalid-number-fields");
			System.out.println("Một trong các trường số không hợp lệ");
			return;
		}
		// Kiểm tra trùng dữ liệu
//		if (bookService.isExist(categoryId, subtitleId, title, authorIds)) {
//	    	SessionErrors.add(actionRequest, "book-already-exists");
//	        System.out.println("Sách đã tồn tại");
//	        return;
//	    }
		try {
			Book book = this.bookService.getBookById(bookId);
			book.setTitle(title);
			book.setDescription(description);
			book.setThumbnail(thumbnail);
			book.setSubtitleId(subtitleId);
			book.setCategoryId(categoryId);
			book.setPrice(price);
			book.setNum_pages(pages);
			book.setStock(stock);
			book.setPublished_year(publicYear);
			this.bookService.changeAuthors(authorIds, bookId);
			this.bookService.updateBook(book);
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-update-book");
		}
	}
}
