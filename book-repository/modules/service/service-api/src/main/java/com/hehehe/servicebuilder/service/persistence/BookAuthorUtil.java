/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.model.BookAuthor;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the book author service. This utility wraps <code>com.hehehe.servicebuilder.service.persistence.impl.BookAuthorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthorPersistence
 * @generated
 */
public class BookAuthorUtil {

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
	public static void clearCache(BookAuthor bookAuthor) {
		getPersistence().clearCache(bookAuthor);
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
	public static Map<Serializable, BookAuthor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BookAuthor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookAuthor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookAuthor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BookAuthor update(BookAuthor bookAuthor) {
		return getPersistence().update(bookAuthor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BookAuthor update(
		BookAuthor bookAuthor, ServiceContext serviceContext) {

		return getPersistence().update(bookAuthor, serviceContext);
	}

	/**
	 * Returns all the book authors where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the matching book authors
	 */
	public static List<BookAuthor> findByBookId(String bookId) {
		return getPersistence().findByBookId(bookId);
	}

	/**
	 * Returns a range of all the book authors where bookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param bookId the book ID
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @return the range of matching book authors
	 */
	public static List<BookAuthor> findByBookId(
		String bookId, int start, int end) {

		return getPersistence().findByBookId(bookId, start, end);
	}

	/**
	 * Returns an ordered range of all the book authors where bookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param bookId the book ID
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book authors
	 */
	public static List<BookAuthor> findByBookId(
		String bookId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().findByBookId(
			bookId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book authors where bookId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param bookId the book ID
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book authors
	 */
	public static List<BookAuthor> findByBookId(
		String bookId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBookId(
			bookId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public static BookAuthor findByBookId_First(
			String bookId, OrderByComparator<BookAuthor> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByBookId_First(bookId, orderByComparator);
	}

	/**
	 * Returns the first book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public static BookAuthor fetchByBookId_First(
		String bookId, OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().fetchByBookId_First(bookId, orderByComparator);
	}

	/**
	 * Returns the last book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public static BookAuthor findByBookId_Last(
			String bookId, OrderByComparator<BookAuthor> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByBookId_Last(bookId, orderByComparator);
	}

	/**
	 * Returns the last book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public static BookAuthor fetchByBookId_Last(
		String bookId, OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().fetchByBookId_Last(bookId, orderByComparator);
	}

	/**
	 * Returns the book authors before and after the current book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookAuthorPK the primary key of the current book author
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public static BookAuthor[] findByBookId_PrevAndNext(
			BookAuthorPK bookAuthorPK, String bookId,
			OrderByComparator<BookAuthor> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByBookId_PrevAndNext(
			bookAuthorPK, bookId, orderByComparator);
	}

	/**
	 * Removes all the book authors where bookId = &#63; from the database.
	 *
	 * @param bookId the book ID
	 */
	public static void removeByBookId(String bookId) {
		getPersistence().removeByBookId(bookId);
	}

	/**
	 * Returns the number of book authors where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the number of matching book authors
	 */
	public static int countByBookId(String bookId) {
		return getPersistence().countByBookId(bookId);
	}

	/**
	 * Returns all the book authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching book authors
	 */
	public static List<BookAuthor> findByAuthorId(String authorId) {
		return getPersistence().findByAuthorId(authorId);
	}

	/**
	 * Returns a range of all the book authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @return the range of matching book authors
	 */
	public static List<BookAuthor> findByAuthorId(
		String authorId, int start, int end) {

		return getPersistence().findByAuthorId(authorId, start, end);
	}

	/**
	 * Returns an ordered range of all the book authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book authors
	 */
	public static List<BookAuthor> findByAuthorId(
		String authorId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().findByAuthorId(
			authorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book authors
	 */
	public static List<BookAuthor> findByAuthorId(
		String authorId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAuthorId(
			authorId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public static BookAuthor findByAuthorId_First(
			String authorId, OrderByComparator<BookAuthor> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByAuthorId_First(
			authorId, orderByComparator);
	}

	/**
	 * Returns the first book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public static BookAuthor fetchByAuthorId_First(
		String authorId, OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().fetchByAuthorId_First(
			authorId, orderByComparator);
	}

	/**
	 * Returns the last book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public static BookAuthor findByAuthorId_Last(
			String authorId, OrderByComparator<BookAuthor> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByAuthorId_Last(
			authorId, orderByComparator);
	}

	/**
	 * Returns the last book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public static BookAuthor fetchByAuthorId_Last(
		String authorId, OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().fetchByAuthorId_Last(
			authorId, orderByComparator);
	}

	/**
	 * Returns the book authors before and after the current book author in the ordered set where authorId = &#63;.
	 *
	 * @param bookAuthorPK the primary key of the current book author
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public static BookAuthor[] findByAuthorId_PrevAndNext(
			BookAuthorPK bookAuthorPK, String authorId,
			OrderByComparator<BookAuthor> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByAuthorId_PrevAndNext(
			bookAuthorPK, authorId, orderByComparator);
	}

	/**
	 * Removes all the book authors where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 */
	public static void removeByAuthorId(String authorId) {
		getPersistence().removeByAuthorId(authorId);
	}

	/**
	 * Returns the number of book authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching book authors
	 */
	public static int countByAuthorId(String authorId) {
		return getPersistence().countByAuthorId(authorId);
	}

	/**
	 * Caches the book author in the entity cache if it is enabled.
	 *
	 * @param bookAuthor the book author
	 */
	public static void cacheResult(BookAuthor bookAuthor) {
		getPersistence().cacheResult(bookAuthor);
	}

	/**
	 * Caches the book authors in the entity cache if it is enabled.
	 *
	 * @param bookAuthors the book authors
	 */
	public static void cacheResult(List<BookAuthor> bookAuthors) {
		getPersistence().cacheResult(bookAuthors);
	}

	/**
	 * Creates a new book author with the primary key. Does not add the book author to the database.
	 *
	 * @param bookAuthorPK the primary key for the new book author
	 * @return the new book author
	 */
	public static BookAuthor create(BookAuthorPK bookAuthorPK) {
		return getPersistence().create(bookAuthorPK);
	}

	/**
	 * Removes the book author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author that was removed
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public static BookAuthor remove(BookAuthorPK bookAuthorPK)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().remove(bookAuthorPK);
	}

	public static BookAuthor updateImpl(BookAuthor bookAuthor) {
		return getPersistence().updateImpl(bookAuthor);
	}

	/**
	 * Returns the book author with the primary key or throws a <code>NoSuchBookAuthorException</code> if it could not be found.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public static BookAuthor findByPrimaryKey(BookAuthorPK bookAuthorPK)
		throws com.hehehe.servicebuilder.exception.NoSuchBookAuthorException {

		return getPersistence().findByPrimaryKey(bookAuthorPK);
	}

	/**
	 * Returns the book author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author, or <code>null</code> if a book author with the primary key could not be found
	 */
	public static BookAuthor fetchByPrimaryKey(BookAuthorPK bookAuthorPK) {
		return getPersistence().fetchByPrimaryKey(bookAuthorPK);
	}

	/**
	 * Returns all the book authors.
	 *
	 * @return the book authors
	 */
	public static List<BookAuthor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the book authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @return the range of book authors
	 */
	public static List<BookAuthor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the book authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of book authors
	 */
	public static List<BookAuthor> findAll(
		int start, int end, OrderByComparator<BookAuthor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookAuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book authors
	 * @param end the upper bound of the range of book authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of book authors
	 */
	public static List<BookAuthor> findAll(
		int start, int end, OrderByComparator<BookAuthor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the book authors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of book authors.
	 *
	 * @return the number of book authors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static BookAuthorPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BookAuthorPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BookAuthorPersistence _persistence;

}