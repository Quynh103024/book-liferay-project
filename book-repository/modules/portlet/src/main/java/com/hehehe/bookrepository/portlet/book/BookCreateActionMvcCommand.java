package com.hehehe.bookrepository.portlet.book;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.BookService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;

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
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("Book create");
		String title = ParamUtil.getString(actionRequest, "title", null);
		String description = ParamUtil.getString(actionRequest, "description", null);
		String thumbnail = ParamUtil.getString(actionRequest, "thumbnail", null); 
		String subtitleId = ParamUtil.getString(actionRequest, "subtitleId", null);
		String categoryId = ParamUtil.getString(actionRequest, "categoryId", null);
		Integer price = ParamUtil.getInteger(actionRequest, "price");
		Integer stock = ParamUtil.getInteger(actionRequest, "stock");
		Integer pages = ParamUtil.getInteger(actionRequest, "pages");
		Integer publicYear = ParamUtil.getInteger(actionRequest, "publicYear");
	    // Kiểm tra dữ liệu
	    if (Validator.isNull(title) || Validator.isNull(description)) {
	        SessionErrors.add(actionRequest, "required-fields-missing");
	        System.out.println(" falled");
	        return;
	    }

	    if (price <= 0 || stock < 0 || pages <= 0 || publicYear < 105 || publicYear > LocalDate.now().getYear()) {
	        SessionErrors.add(actionRequest, "invalid-number-fields");
	        System.out.println(" falled");
	        return;
	    }
	    System.out.println(" success");
		this.bookService.addBook(title, description, thumbnail, subtitleId, categoryId, price, stock, pages, publicYear);
	}
}

