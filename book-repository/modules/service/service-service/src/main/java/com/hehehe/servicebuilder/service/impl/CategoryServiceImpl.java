/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.service.base.CategoryServiceBaseImpl;
import com.hehehe.util.comparator.CategoryNameComparator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=bookservicebuilder",
		"json.web.service.context.path=Category" }, service = AopService.class)
public class CategoryServiceImpl extends CategoryServiceBaseImpl {
	public Category addCategory(String name) {
		return categoryLocalService.addCategory(name);
	}
	public Category getCategoryById(String categoryId) throws PortalException {
		return categoryLocalService.getCategory(categoryId);
	}
	public Category updateCategory(Category category) {
		return categoryLocalService.updateCategory(category);
	}
	public Category deleteCategory(String categoryId) throws PortalException{
		return categoryLocalService.deleteCategory(categoryId);
	}
	public List<Category> getCategories(int start, int end, OrderByComparator<Category> obc){
		return categoryLocalService.getCategoriesSorted(start,end, obc);
	}
	public List<Category> getAllCategory(){
		return categoryLocalService.getCategoriesSorted(0, getCategoriesCount(), new CategoryNameComparator());
	}
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc, String categoryId){
		return categoryLocalService.getBooks(start,end,obc,categoryId);
	}
	public int getCategoriesCount() {
		return categoryLocalService.getCategoriesCount();
	}
}