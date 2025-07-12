/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.model.Category;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the category service. This utility wraps <code>com.hehehe.servicebuilder.service.persistence.impl.CategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryPersistence
 * @generated
 */
public class CategoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Category category) {
		getPersistence().clearCache(category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Category update(Category category) {
		return getPersistence().update(category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Category update(
		Category category, ServiceContext serviceContext) {

		return getPersistence().update(category, serviceContext);
	}

	/**
	 * Returns the category where name = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByName(String name)
		throws com.hehehe.servicebuilder.exception.NoSuchCategoryException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByName(String name, boolean useFinderCache) {
		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the category that was removed
	 */
	public static Category removeByName(String name)
		throws com.hehehe.servicebuilder.exception.NoSuchCategoryException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching categories
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	public static void cacheResult(Category category) {
		getPersistence().cacheResult(category);
	}

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	public static void cacheResult(List<Category> categories) {
		getPersistence().cacheResult(categories);
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	public static Category create(String categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category remove(String categoryId)
		throws com.hehehe.servicebuilder.exception.NoSuchCategoryException {

		return getPersistence().remove(categoryId);
	}

	public static Category updateImpl(Category category) {
		return getPersistence().updateImpl(category);
	}

	/**
	 * Returns the category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category findByPrimaryKey(String categoryId)
		throws com.hehehe.servicebuilder.exception.NoSuchCategoryException {

		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	public static Category fetchByPrimaryKey(String categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	public static List<Category> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	public static List<Category> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	public static List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categories
	 */
	public static List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CategoryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CategoryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CategoryPersistence _persistence;

}