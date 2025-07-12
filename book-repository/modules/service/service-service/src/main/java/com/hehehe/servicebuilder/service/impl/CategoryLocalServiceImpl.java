/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.model.impl.CategoryImpl;
import com.hehehe.servicebuilder.service.BookLocalService;
import com.hehehe.servicebuilder.service.base.CategoryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hehehe.servicebuilder.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	@Reference
	private BookLocalService bookLocalService;
	
	public Category addCategory(String name) {
		Category category = new CategoryImpl();
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		category.setCategoryId(id);
		category.setName(name);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		return categoryLocalService.addCategory(category);
	}
	public List<Category> getCategoriesSorted(int start, int end, OrderByComparator<Category> obc){
		return categoryPersistence.findAll(start, end, obc);
	}
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc, String categoryId){
		return bookPersistence.findByCategoryId(categoryId, start, end, obc);
	}
	public List<Book> getAllBooks(String categoryId){
		return bookPersistence.findByCategoryId(categoryId);
	}
	@Override
	public Category deleteCategory(String categoryId) throws PortalException {
		bookLocalService.deleteBooksByCategoryId(categoryId);
		return categoryLocalService.deleteCategory(categoryId);
	}
	@Override
	public Category updateCategory(Category category) {
		Date now = new Date();
		category.setModifiedDate(now);
		return categoryPersistence.update(category);
	}
}