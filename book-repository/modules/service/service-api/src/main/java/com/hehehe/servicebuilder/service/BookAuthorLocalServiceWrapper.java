/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BookAuthorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthorLocalService
 * @generated
 */
public class BookAuthorLocalServiceWrapper
	implements BookAuthorLocalService, ServiceWrapper<BookAuthorLocalService> {

	public BookAuthorLocalServiceWrapper() {
		this(null);
	}

	public BookAuthorLocalServiceWrapper(
		BookAuthorLocalService bookAuthorLocalService) {

		_bookAuthorLocalService = bookAuthorLocalService;
	}

	/**
	 * Adds the book author to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookAuthorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @return the book author that was added
	 */
	@Override
	public com.hehehe.servicebuilder.model.BookAuthor addBookAuthor(
		com.hehehe.servicebuilder.model.BookAuthor bookAuthor) {

		return _bookAuthorLocalService.addBookAuthor(bookAuthor);
	}

	/**
	 * Creates a new book author with the primary key. Does not add the book author to the database.
	 *
	 * @param bookAuthorPK the primary key for the new book author
	 * @return the new book author
	 */
	@Override
	public com.hehehe.servicebuilder.model.BookAuthor createBookAuthor(
		com.hehehe.servicebuilder.service.persistence.BookAuthorPK
			bookAuthorPK) {

		return _bookAuthorLocalService.createBookAuthor(bookAuthorPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookAuthorLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the book author from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookAuthorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @return the book author that was removed
	 */
	@Override
	public com.hehehe.servicebuilder.model.BookAuthor deleteBookAuthor(
		com.hehehe.servicebuilder.model.BookAuthor bookAuthor) {

		return _bookAuthorLocalService.deleteBookAuthor(bookAuthor);
	}

	/**
	 * Deletes the book author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookAuthorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author that was removed
	 * @throws PortalException if a book author with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.BookAuthor deleteBookAuthor(
			com.hehehe.servicebuilder.service.persistence.BookAuthorPK
				bookAuthorPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookAuthorLocalService.deleteBookAuthor(bookAuthorPK);
	}

	@Override
	public void deleteBookAuthorByAuthorId(String authorId) {
		_bookAuthorLocalService.deleteBookAuthorByAuthorId(authorId);
	}

	@Override
	public void deleteBookAuthorByBookId(String bookId) {
		_bookAuthorLocalService.deleteBookAuthorByBookId(bookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookAuthorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bookAuthorLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bookAuthorLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookAuthorLocalService.dynamicQuery();
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

		return _bookAuthorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl</code>.
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

		return _bookAuthorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl</code>.
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

		return _bookAuthorLocalService.dynamicQuery(
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

		return _bookAuthorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bookAuthorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.hehehe.servicebuilder.model.BookAuthor fetchBookAuthor(
		com.hehehe.servicebuilder.service.persistence.BookAuthorPK
			bookAuthorPK) {

		return _bookAuthorLocalService.fetchBookAuthor(bookAuthorPK);
	}

	/**
	 * Returns the book author with the primary key.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author
	 * @throws PortalException if a book author with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.BookAuthor getBookAuthor(
			com.hehehe.servicebuilder.service.persistence.BookAuthorPK
				bookAuthorPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookAuthorLocalService.getBookAuthor(bookAuthorPK);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.BookAuthor>
		getBookAuthorByAuthorId(String authorId) {

		return _bookAuthorLocalService.getBookAuthorByAuthorId(authorId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.BookAuthor>
		getBookAuthorByBookId(String bookId) {

		return _bookAuthorLocalService.getBookAuthorByBookId(bookId);
	}

	/**
	 * Returns a range of all the book authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @return the range of book authors
	 */
	@Override
	public java.util.List<com.hehehe.servicebuilder.model.BookAuthor>
		getBookAuthors(int start, int end) {

		return _bookAuthorLocalService.getBookAuthors(start, end);
	}

	/**
	 * Returns the number of book authors.
	 *
	 * @return the number of book authors
	 */
	@Override
	public int getBookAuthorsCount() {
		return _bookAuthorLocalService.getBookAuthorsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookAuthorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookAuthorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the book author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookAuthorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @return the book author that was updated
	 */
	@Override
	public com.hehehe.servicebuilder.model.BookAuthor updateBookAuthor(
		com.hehehe.servicebuilder.model.BookAuthor bookAuthor) {

		return _bookAuthorLocalService.updateBookAuthor(bookAuthor);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bookAuthorLocalService.getBasePersistence();
	}

	@Override
	public BookAuthorLocalService getWrappedService() {
		return _bookAuthorLocalService;
	}

	@Override
	public void setWrappedService(
		BookAuthorLocalService bookAuthorLocalService) {

		_bookAuthorLocalService = bookAuthorLocalService;
	}

	private BookAuthorLocalService _bookAuthorLocalService;

}