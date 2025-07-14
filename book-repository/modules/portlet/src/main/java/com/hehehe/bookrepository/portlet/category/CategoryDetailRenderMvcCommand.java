package com.hehehe.bookrepository.portlet.category;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.service.AuthorService;
import com.hehehe.servicebuilder.service.BookService;
import com.hehehe.servicebuilder.service.CategoryService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
	        "mvc.command.name=category/detail/view"
	    },
	    service = MVCRenderCommand.class
	)
	public class CategoryDetailRenderMvcCommand implements MVCRenderCommand {

	    @Reference
	    private CategoryService categoryService;

	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	        String categoryId = ParamUtil.getString(renderRequest, "categoryId");
	        try {
	        	Category category = categoryService.getCategoryById(categoryId);
	            renderRequest.setAttribute("category", category);
	        } catch (Exception e) {
	            SessionErrors.add(renderRequest, "category-not-found");
	        }
	        return "/category/details.jsp";
	    }
	}
