/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.BookAuthor;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BookAuthor. This utility wraps
 * <code>com.hehehe.servicebuilder.service.impl.BookAuthorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthorLocalService
 * @generated
 */
public class BookAuthorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.BookAuthorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static BookAuthor addBookAuthor(BookAuthor bookAuthor) {
		return getService().addBookAuthor(bookAuthor);
	}

	/**
	 * Creates a new book author with the primary key. Does not add the book author to the database.
	 *
	 * @param bookAuthorPK the primary key for the new book author
	 * @return the new book author
	 */
	public static BookAuthor createBookAuthor(
		com.hehehe.servicebuilder.service.persistence.BookAuthorPK
			bookAuthorPK) {

		return getService().createBookAuthor(bookAuthorPK);
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
	 * Deletes the book author from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookAuthorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @return the book author that was removed
	 */
	public static BookAuthor deleteBookAuthor(BookAuthor bookAuthor) {
		return getService().deleteBookAuthor(bookAuthor);
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
	public static BookAuthor deleteBookAuthor(
			com.hehehe.servicebuilder.service.persistence.BookAuthorPK
				bookAuthorPK)
		throws PortalException {

		return getService().deleteBookAuthor(bookAuthorPK);
	}

	public static void deleteBookAuthorByAuthorId(String authorId) {
		getService().deleteBookAuthorByAuthorId(authorId);
	}

	public static void deleteBookAuthorByBookId(String bookId) {
		getService().deleteBookAuthorByBookId(bookId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl</code>.
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

	public static BookAuthor fetchBookAuthor(
		com.hehehe.servicebuilder.service.persistence.BookAuthorPK
			bookAuthorPK) {

		return getService().fetchBookAuthor(bookAuthorPK);
	}

	/**
	 * Returns the book author with the primary key.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author
	 * @throws PortalException if a book author with the primary key could not be found
	 */
	public static BookAuthor getBookAuthor(
			com.hehehe.servicebuilder.service.persistence.BookAuthorPK
				bookAuthorPK)
		throws PortalException {

		return getService().getBookAuthor(bookAuthorPK);
	}

	public static List<BookAuthor> getBookAuthorByAuthorId(String authorId) {
		return getService().getBookAuthorByAuthorId(authorId);
	}

	public static List<BookAuthor> getBookAuthorByBookId(String bookId) {
		return getService().getBookAuthorByBookId(bookId);
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
	public static List<BookAuthor> getBookAuthors(int start, int end) {
		return getService().getBookAuthors(start, end);
	}

	/**
	 * Returns the number of book authors.
	 *
	 * @return the number of book authors
	 */
	public static int getBookAuthorsCount() {
		return getService().getBookAuthorsCount();
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
	 * Updates the book author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookAuthorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @return the book author that was updated
	 */
	public static BookAuthor updateBookAuthor(BookAuthor bookAuthor) {
		return getService().updateBookAuthor(bookAuthor);
	}

	public static BookAuthorLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BookAuthorLocalService> _serviceSnapshot =
		new Snapshot<>(
			BookAuthorLocalServiceUtil.class, BookAuthorLocalService.class);

}