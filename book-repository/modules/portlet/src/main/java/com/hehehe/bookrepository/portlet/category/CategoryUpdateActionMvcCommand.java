package com.hehehe.bookrepository.portlet.category;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Category;
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

@Component(immediate = true, property = { "javax.portlet.name=" + BookPortletKeys.CATEGORYPORTLET,
		"mvc.command.name=category/update/save" }, service = MVCActionCommand.class)
public class CategoryUpdateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private CategoryService categoryService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String categoryId = ParamUtil.getString(actionRequest, "categoryId");
		String name = ParamUtil.getString(actionRequest, "name").trim();

		// Check null
		if (name == null || name.trim().isEmpty()) {
			SessionErrors.add(actionRequest, "name-required");
			return;
		}

		try {
			Category category = this.categoryService.getCategoryById(categoryId);
			String oldName = category.getName();

			// Nếu tên không đổi thì không làm gì cả
			if (oldName.equalsIgnoreCase(name.trim())) {
				return;
			}

			// Kiểm tra nếu tên mới đã được dùng bởi tác giả khác
			if (categoryService.isExist(name) && !oldName.equalsIgnoreCase(name.trim())) {
				SessionErrors.add(actionRequest, "name-already-exists");
				return;
			}

			// Nếu hợp lệ thì cập nhật
			category.setName(name.trim());
			this.categoryService.updateCategory(category);
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "wrong-to-update-category");
		}
	}
}
