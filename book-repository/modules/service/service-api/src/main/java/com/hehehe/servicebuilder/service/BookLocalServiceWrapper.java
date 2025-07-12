/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BookLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalService
 * @generated
 */
public class BookLocalServiceWrapper
	implements BookLocalService, ServiceWrapper<BookLocalService> {

	public BookLocalServiceWrapper() {
		this(null);
	}

	public BookLocalServiceWrapper(BookLocalService bookLocalService) {
		_bookLocalService = bookLocalService;
	}

	@Override
	public void addAuthers(java.util.List<String> autherIds, String bookId) {
		_bookLocalService.addAuthers(autherIds, bookId);
	}

	@Override
	public void addAuthers(
		java.util.List<String> autherIds, String bookId, java.util.Date date) {

		_bookLocalService.addAuthers(autherIds, bookId, date);
	}

	/**
	 * Adds the book to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param book the book
	 * @return the book that was added
	 */
	@Override
	public com.hehehe.servicebuilder.model.Book addBook(
		com.hehehe.servicebuilder.model.Book book) {

		return _bookLocalService.addBook(book);
	}

	@Override
	public com.hehehe.servicebuilder.model.Book addBook(
		java.util.List<String> authorIds, String title, String description,
		String thumbnail, String subtitleId, String categoryId, Integer price,
		Integer stock, Integer pages, Integer publicYear) {

		return _bookLocalService.addBook(
			authorIds, title, description, thumbnail, subtitleId, categoryId,
			price, stock, pages, publicYear);
	}

	@Override
	public void changeAuthors(java.util.List<String> authorIds, String bookId) {
		_bookLocalService.changeAuthors(authorIds, bookId);
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	@Override
	public com.hehehe.servicebuilder.model.Book createBook(String bookId) {
		return _bookLocalService.createBook(bookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the book from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param book the book
	 * @return the book that was removed
	 */
	@Override
	public com.hehehe.servicebuilder.model.Book deleteBook(
		com.hehehe.servicebuilder.model.Book book) {

		return _bookLocalService.deleteBook(book);
	}

	/**
	 * Deletes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws PortalException if a book with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.Book deleteBook(String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.deleteBook(bookId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
			deleteBooksByCategoryId(String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.deleteBooksByCategoryId(categoryId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
			deleteBooksBySubtitleId(String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.deleteBooksBySubtitleId(subtitleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bookLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bookLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookLocalService.dynamicQuery();
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

		return _bookLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookModelImpl</code>.
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

		return _bookLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookModelImpl</code>.
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

		return _bookLocalService.dynamicQuery(
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

		return _bookLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bookLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.hehehe.servicebuilder.model.Book fetchBook(String bookId) {
		return _bookLocalService.fetchBook(bookId);
	}

	/**
	 * Returns the book with the primary key.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws PortalException if a book with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.Book getBook(String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.getBook(bookId);
	}

	/**
	 * Returns a range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of books
	 */
	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		int start, int end) {

		return _bookLocalService.getBooks(start, end);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Book> obc) {

		return _bookLocalService.getBooks(start, end, obc);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
			getBooksByAuthorId(String authorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.getBooksByAuthorId(authorId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
		getBooksByCategoryId(String categoryId) {

		return _bookLocalService.getBooksByCategoryId(categoryId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
		getBooksByCategoryId(String categoryId, int start, int end) {

		return _bookLocalService.getBooksByCategoryId(categoryId, start, end);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
		getBooksByCategoryId(
			String categoryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Book> obc) {

		return _bookLocalService.getBooksByCategoryId(
			categoryId, start, end, obc);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
		getBooksBySubtitleId(String subtitleId) {

		return _bookLocalService.getBooksBySubtitleId(subtitleId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
		getBooksBySubtitleId(String subtitleId, int start, int end) {

		return _bookLocalService.getBooksBySubtitleId(subtitleId, start, end);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book>
		getBooksBySubtitleId(
			String subtitleId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Book> obc) {

		return _bookLocalService.getBooksBySubtitleId(
			subtitleId, start, end, obc);
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	@Override
	public int getBooksCount() {
		return _bookLocalService.getBooksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param book the book
	 * @return the book that was updated
	 */
	@Override
	public com.hehehe.servicebuilder.model.Book updateBook(
		com.hehehe.servicebuilder.model.Book book) {

		return _bookLocalService.updateBook(book);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bookLocalService.getBasePersistence();
	}

	@Override
	public BookLocalService getWrappedService() {
		return _bookLocalService;
	}

	@Override
	public void setWrappedService(BookLocalService bookLocalService) {
		_bookLocalService = bookLocalService;
	}

	private BookLocalService _bookLocalService;

}