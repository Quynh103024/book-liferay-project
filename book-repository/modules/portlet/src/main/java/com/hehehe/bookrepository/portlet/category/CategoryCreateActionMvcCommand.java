package com.hehehe.bookrepository.portlet.category;

import com.hehehe.bookrepository.portlet.constants.BookPortletKeys;
import com.hehehe.servicebuilder.service.CategoryService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BookPortletKeys.CATEGORYPORTLET,
		"mvc.command.name=category/create/save" }, service = MVCActionCommand.class)
public class CategoryCreateActionMvcCommand extends BaseMVCActionCommand {
	@Reference
	private CategoryService categoryService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Category create");
		String name = ParamUtil.get(actionRequest, "name", "").trim();

		// Check null
		if (Validator.isNull(name)) {
			SessionErrors.add(actionRequest, "required-fields-missing");
			System.out.println(" falled");
			return;
		}

		// Check special characters
		if (!name.matches("^[\\p{L} .'-]+$")) {
			SessionErrors.add(actionRequest, "invalid-category-name");
			return;
		}

		// Check length
		if (name.length() < 3 || name.length() > 100) {
			SessionErrors.add(actionRequest, "category-name-length-invalid");
			return;
		}

		// Check duplicate
		if (categoryService.isExist(name)) {
			SessionErrors.add(actionRequest, "category-name-exists");
			return;
		}

		// Add one
		this.categoryService.addCategory(name);
	}
}
