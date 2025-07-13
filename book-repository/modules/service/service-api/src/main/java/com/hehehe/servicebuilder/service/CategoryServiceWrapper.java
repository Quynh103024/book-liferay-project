/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryService
 * @generated
 */
public class CategoryServiceWrapper
	implements CategoryService, ServiceWrapper<CategoryService> {

	public CategoryServiceWrapper() {
		this(null);
	}

	public CategoryServiceWrapper(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	@Override
	public com.hehehe.servicebuilder.model.Category addCategory(String name) {
		return _categoryService.addCategory(name);
	}

	@Override
	public com.hehehe.servicebuilder.model.Category deleteCategory(
			String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryService.deleteCategory(categoryId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Category>
		getCategories() {

		return _categoryService.getCategories();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Category>
		getCategories(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Category> obc) {

		return _categoryService.getCategories(start, end, obc);
	}

	@Override
	public int getCategoriesCount() {
		return _categoryService.getCategoriesCount();
	}

	@Override
	public com.hehehe.servicebuilder.model.Category getCategoryByBookId(
			String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryService.getCategoryByBookId(bookId);
	}

	@Override
	public com.hehehe.servicebuilder.model.Category getCategoryById(
			String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryService.getCategoryById(categoryId);
	}

	@Override
	public String getCategoryIdByName(String name) {
		return _categoryService.getCategoryIdByName(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoryService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean isExist(String name) {
		return _categoryService.isExist(name);
	}

	@Override
	public com.hehehe.servicebuilder.model.Category updateCategory(
		com.hehehe.servicebuilder.model.Category category) {

		return _categoryService.updateCategory(category);
	}

	@Override
	public CategoryService getWrappedService() {
		return _categoryService;
	}

	@Override
	public void setWrappedService(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	private CategoryService _categoryService;

}