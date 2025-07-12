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
	
//	REFERENCE
	
	@Reference
	private BookLocalService bookLocalService;
	
//	CREATE
	
	public Category addCategory(String name) {
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		Category category = new CategoryImpl();
		category.setCategoryId(id);
		category.setName(name);
		category.setCreateDate(now);
		category.setModifiedDate(now);
		return super.addCategory(category);
	}
	
//	READ
	
	public List<Category> getCategories(int start, int end, OrderByComparator<Category> obc){
		return categoryPersistence.findAll(start, end, obc);
	}
	
	public Category getCategoryByBookId(String bookId) throws PortalException {
		Book book = bookLocalService.getBook(bookId);
		return super.getCategory(book.getCategoryId());
	}
	
//	UPDATE
	
	@Override
	public Category updateCategory(Category category) {
		Date now = new Date();
		category.setModifiedDate(now);
		return super.updateCategory(category);
	}
	
//	DELETE
	
	@Override
	public Category deleteCategory(String categoryId) throws PortalException {
		bookLocalService.deleteBooksByCategoryId(categoryId);
		return super.deleteCategory(categoryId);
	}
	
//	LOGIC METHOD
	
	public boolean isExist(String name) {
		return categoryPersistence.fetchByName(name) != null;
	}
}