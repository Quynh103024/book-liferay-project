package com.hehehe.bookrepository.portlet.book;
import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.BookService;
import com.hehehe.util.comparator.BookTitleComparator;
import com.hehehe.util.comparator.BookNumPagesComparator;
import com.hehehe.util.comparator.BookPublishedYearComparator;
import com.hehehe.util.comparator.BookPriceComparator;
import com.hehehe.util.comparator.BookStockComparator;
import javax.portlet.Portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BookModule", 
		"javax.portlet.init-param.template-path=/book/",
		"javax.portlet.init-param.view-template=/book/view.jsp",
		"javax.portlet.name=" + BookPortletKeys.BOOKPORTLET, 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"}, 
		service = Portlet.class)
public class BookModulePortlet extends MVCPortlet {
	@Reference
	private BookService bookService;
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		int from = delta * (cur - 1);
		int to = delta == 0 ? 9 : delta * cur;
		String orderByType = ParamUtil.getString(renderRequest,"orderByType","asc");
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
		boolean ascending = orderByType.equals("asc");
		OrderByComparator comparator = new BookTitleComparator();
		if(ascending) {
			switch (orderByCol) {
	        case "price":
	            comparator = new BookTitleComparator();
	            break;
	        case "stock":
	            comparator = new BookStockComparator();
	            break;
	        case "num_pages":
	            comparator = new BookNumPagesComparator();
	            break;
	        case "published_year":
	            comparator = new BookPublishedYearComparator();
	            break;
	        case "title":
	        default:
	            comparator = new BookPriceComparator();
	            break;
	    }
		}
		renderRequest.setAttribute("totalBook", bookService.getBooksCount());
		renderRequest.setAttribute("entries", bookService.getBooks(from, to, comparator));
				
		super.doView(renderRequest, renderResponse);
	}
}