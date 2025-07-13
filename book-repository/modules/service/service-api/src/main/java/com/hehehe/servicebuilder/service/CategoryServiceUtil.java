/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Category;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Category. This utility wraps
 * <code>com.hehehe.servicebuilder.service.impl.CategoryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryService
 * @generated
 */
public class CategoryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.CategoryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Category addCategory(String name) {
		return getService().addCategory(name);
	}

	public static Category deleteCategory(String categoryId)
		throws PortalException {

		return getService().deleteCategory(categoryId);
	}

	public static List<Category> getCategories() {
		return getService().getCategories();
	}

	public static List<Category> getCategories(
		int start, int end, OrderByComparator<Category> obc) {

		return getService().getCategories(start, end, obc);
	}

	public static int getCategoriesCount() {
		return getService().getCategoriesCount();
	}

	public static Category getCategoryByBookId(String bookId)
		throws PortalException {

		return getService().getCategoryByBookId(bookId);
	}

	public static Category getCategoryById(String categoryId)
		throws PortalException {

		return getService().getCategoryById(categoryId);
	}

	public static String getCategoryIdByName(String name) {
		return getService().getCategoryIdByName(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean isExist(String name) {
		return getService().isExist(name);
	}

	public static Category updateCategory(Category category) {
		return getService().updateCategory(category);
	}

	public static CategoryService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CategoryService> _serviceSnapshot =
		new Snapshot<>(CategoryServiceUtil.class, CategoryService.class);

}