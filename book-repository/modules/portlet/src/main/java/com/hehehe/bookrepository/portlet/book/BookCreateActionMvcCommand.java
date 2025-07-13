package com.hehehe.bookrepository.portlet.book;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.servicebuilder.service.BookService;
import com.hehehe.servicebuilder.service.CategoryService;
import com.hehehe.servicebuilder.service.SubtitleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
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
				"mvc.command.name=book/create/save" }, 
		service = MVCActionCommand.class)
public class BookCreateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private BookService bookService;
	@Reference
    private AuthorService authorService;
	@Reference
	private CategoryService categoryService;
	@Reference
	private SubtitleService subtitleService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("Book create");
		String title = ParamUtil.getString(actionRequest, "title", null);
		String description = ParamUtil.getString(actionRequest, "description", null);
		String thumbnail = ParamUtil.getString(actionRequest, "thumbnail", null); 
		String subtitleId = ParamUtil.getString(actionRequest, "subtitleId", null);
		String categoryId = ParamUtil.getString(actionRequest, "categoryId", null);
		String[] authorIdsArray = ParamUtil.getParameterValues(actionRequest, "authorIds");
		Integer price = ParamUtil.getInteger(actionRequest, "price");
		Integer stock = ParamUtil.getInteger(actionRequest, "stock");
		Integer pages = ParamUtil.getInteger(actionRequest, "pages");
		Integer publicYear = ParamUtil.getInteger(actionRequest, "publicYear");
		
		List<String> authorList = Arrays.asList(authorIdsArray);

	    // Kiểm tra dữ liệu
	    if (Validator.isNull(title) || Validator.isNull(description)) {
	        SessionErrors.add(actionRequest, "required-fields-missing");
	        System.out.println(" failed");
	        return;
	    }
	    if (Validator.isNull(thumbnail) || Validator.isNull(subtitleId) || Validator.isNull(categoryId)) {
	    	SessionErrors.add(actionRequest, "required-fields-missing");
	    	System.out.println(" failed");
	    	return;
	    }
	    // Kiểm tra có tác giả 
	    if (authorIdsArray == null || authorIdsArray.length == 0) {
	        SessionErrors.add(actionRequest, "author-required");
	        System.out.println("Không có tác giả nào được chọn");
	        return;
	    }

	    // Kiểm tra từng tác giả
	    for (String authorId : authorIdsArray) {
	        if (Validator.isNull(authorId) || !authorId.matches("^[0-9a-zA-Z_-]+$")) {
	            SessionErrors.add(actionRequest, "invalid-author-id");
	            System.out.println("AuthorId không hợp lệ: " + authorId);
	            return;
	        }
	    }
	    if (price <= 0 || stock < 0 || pages <= 0 || publicYear < 105 || publicYear > LocalDate.now().getYear()) {
	        SessionErrors.add(actionRequest, "invalid-number-fields");
	        System.out.println(" failed");
	        return;
	    }
	    // Kiểm tra xem có trùng dữ liệu
//	    if (bookService.isExist( categoryId, subtitleId, title, authorList)) {
//	    	SessionErrors.add(actionRequest, "book-already-exists");
//	        System.out.println("Sách đã tồn tại");
//	        return;
//	    }
	    else {
	    System.out.println(" success");
		Book book = this.bookService.addBook(new ArrayList<>(),title, description, thumbnail, subtitleId, categoryId, price, stock, pages, publicYear);
		this.bookService.addAuthers(authorList, book.getBookId());
	    }
	}
}

