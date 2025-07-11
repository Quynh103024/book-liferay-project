package com.hehehe.bookrepository.portlet.category;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.CategoryService;
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
				"javax.portlet.name=" + BookPortletKeys.CATEGORYPORTLET,
				"mvc.command.name=category/update/view"
		},
		service = MVCRenderCommand.class)
public class CategoryUpdateRenderMvcCommand implements MVCRenderCommand {
	@Reference
    private CategoryService categoryService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		String categoryId = ParamUtil.getString(renderRequest, "categoryId");
		try {
			renderRequest.setAttribute("category", categoryService.getCategoryById(categoryId));
		} catch (PortalException e) {
			SessionErrors.add(renderRequest, "invalid-category");
		}
		return "/category/update.jsp";
	}
}
