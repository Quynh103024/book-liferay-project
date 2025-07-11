package com.hehehe.bookrepository.portlet.category;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.CategoryService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + BookPortletKeys.CATEGORYPORTLET,
				"mvc.command.name=category/delete/save" }, 
		service = MVCActionCommand.class)
public class CategoryDeleteActionMvcCommand extends BaseMVCActionCommand{
	@Reference
	private CategoryService categoryService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String categoryId = ParamUtil.getString(actionRequest,"categoryId");
		try {
			this.categoryService.deleteCategory(categoryId);
		} catch(PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-delete-category");
		}
	}
}
