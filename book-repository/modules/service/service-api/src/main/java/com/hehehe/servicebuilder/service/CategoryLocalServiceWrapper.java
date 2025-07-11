/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryLocalService
 * @generated
 */
public class CategoryLocalServiceWrapper
	implements CategoryLocalService, ServiceWrapper<CategoryLocalService> {

	public CategoryLocalServiceWrapper() {
		this(null);
	}

	public CategoryLocalServiceWrapper(
		CategoryLocalService categoryLocalService) {

		_categoryLocalService = categoryLocalService;
	}

	/**
	 * Adds the category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param category the category
	 * @return the category that was added
	 */
	@Override
	public com.hehehe.servicebuilder.model.Category addCategory(
		com.hehehe.servicebuilder.model.Category category) {

		return _categoryLocalService.addCategory(category);
	}

	@Override
	public com.hehehe.servicebuilder.model.Category addCategory(String name) {
		return _categoryLocalService.addCategory(name);
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public com.hehehe.servicebuilder.model.Category createCategory(
		String categoryId) {

		return _categoryLocalService.createCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param category the category
	 * @return the category that was removed
	 */
	@Override
	public com.hehehe.servicebuilder.model.Category deleteCategory(
		com.hehehe.servicebuilder.model.Category category) {

		return _categoryLocalService.deleteCategory(category);
	}

	/**
	 * Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws PortalException if a category with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.Category deleteCategory(
			String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.deleteCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _categoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _categoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _categoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _categoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _categoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _categoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _categoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.hehehe.servicebuilder.model.Category fetchCategory(
		String categoryId) {

		return _categoryLocalService.fetchCategory(categoryId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Book> obc,
		String categoryId) {

		return _categoryLocalService.getBooks(start, end, obc, categoryId);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Category>
		getCategories(int start, int end) {

		return _categoryLocalService.getCategories(start, end);
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	@Override
	public int getCategoriesCount() {
		return _categoryLocalService.getCategoriesCount();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Category>
		getCategoriesSorted(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Category> obc) {

		return _categoryLocalService.getCategoriesSorted(start, end, obc);
	}

	/**
	 * Returns the category with the primary key.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws PortalException if a category with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.Category getCategory(
			String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.getCategory(categoryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param category the category
	 * @return the category that was updated
	 */
	@Override
	public com.hehehe.servicebuilder.model.Category updateCategory(
		com.hehehe.servicebuilder.model.Category category) {

		return _categoryLocalService.updateCategory(category);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _categoryLocalService.getBasePersistence();
	}

	@Override
	public CategoryLocalService getWrappedService() {
		return _categoryLocalService;
	}

	@Override
	public void setWrappedService(CategoryLocalService categoryLocalService) {
		_categoryLocalService = categoryLocalService;
	}

	private CategoryLocalService _categoryLocalService;

}