/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Book;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Book. This utility wraps
 * <code>com.hehehe.servicebuilder.service.impl.BookLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalService
 * @generated
 */
public class BookLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.BookLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addAuthers(List<String> autherIds, String bookId) {
		getService().addAuthers(autherIds, bookId);
	}

	public static void addAuthers(
		List<String> autherIds, String bookId, java.util.Date date) {

		getService().addAuthers(autherIds, bookId, date);
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
	public static Book addBook(Book book) {
		return getService().addBook(book);
	}

	public static Book addBook(
		List<String> authorIds, String title, String description,
		String thumbnail, String subtitleId, String categoryId, Integer price,
		Integer stock, Integer pages, Integer publicYear) {

		return getService().addBook(
			authorIds, title, description, thumbnail, subtitleId, categoryId,
			price, stock, pages, publicYear);
	}

	public static void changeAuthors(List<String> authorIds, String bookId) {
		getService().changeAuthors(authorIds, bookId);
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public static Book createBook(String bookId) {
		return getService().createBook(bookId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Book deleteBook(Book book) {
		return getService().deleteBook(book);
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
	public static Book deleteBook(String bookId) throws PortalException {
		return getService().deleteBook(bookId);
	}

	public static List<Book> deleteBooksByCategoryId(String categoryId)
		throws PortalException {

		return getService().deleteBooksByCategoryId(categoryId);
	}

	public static List<Book> deleteBooksBySubtitleId(String subtitleId)
		throws PortalException {

		return getService().deleteBooksBySubtitleId(subtitleId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Book fetchBook(String bookId) {
		return getService().fetchBook(bookId);
	}

	/**
	 * Returns the book with the primary key.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws PortalException if a book with the primary key could not be found
	 */
	public static Book getBook(String bookId) throws PortalException {
		return getService().getBook(bookId);
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
	public static List<Book> getBooks(int start, int end) {
		return getService().getBooks(start, end);
	}

	public static List<Book> getBooks(
		int start, int end, OrderByComparator<Book> obc) {

		return getService().getBooks(start, end, obc);
	}

	public static List<Book> getBooksByAuthorId(String authorId)
		throws PortalException {

		return getService().getBooksByAuthorId(authorId);
	}

	public static List<Book> getBooksByCategoryId(String categoryId) {
		return getService().getBooksByCategoryId(categoryId);
	}

	public static List<Book> getBooksByCategoryId(
		String categoryId, int start, int end) {

		return getService().getBooksByCategoryId(categoryId, start, end);
	}

	public static List<Book> getBooksByCategoryId(
		String categoryId, int start, int end, OrderByComparator<Book> obc) {

		return getService().getBooksByCategoryId(categoryId, start, end, obc);
	}

	public static List<Book> getBooksBySubtitleId(String subtitleId) {
		return getService().getBooksBySubtitleId(subtitleId);
	}

	public static List<Book> getBooksBySubtitleId(
		String subtitleId, int start, int end) {

		return getService().getBooksBySubtitleId(subtitleId, start, end);
	}

	public static List<Book> getBooksBySubtitleId(
		String subtitleId, int start, int end, OrderByComparator<Book> obc) {

		return getService().getBooksBySubtitleId(subtitleId, start, end, obc);
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	public static int getBooksCount() {
		return getService().getBooksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static Book updateBook(Book book) {
		return getService().updateBook(book);
	}

	public static BookLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BookLocalService> _serviceSnapshot =
		new Snapshot<>(BookLocalServiceUtil.class, BookLocalService.class);

}