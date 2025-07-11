/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.model.Book;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the book service. This utility wraps <code>com.hehehe.servicebuilder.service.persistence.impl.BookPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @generated
 */
public class BookUtil {

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
	public static void clearCache(Book book) {
		getPersistence().clearCache(book);
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
	public static Map<Serializable, Book> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Book> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Book> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Book update(Book book) {
		return getPersistence().update(book);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Book update(Book book, ServiceContext serviceContext) {
		return getPersistence().update(book, serviceContext);
	}

	/**
	 * Returns all the books where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @return the matching books
	 */
	public static List<Book> findBySubtitleId(String subtitleId) {
		return getPersistence().findBySubtitleId(subtitleId);
	}

	/**
	 * Returns a range of all the books where subtitleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param subtitleId the subtitle ID
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 */
	public static List<Book> findBySubtitleId(
		String subtitleId, int start, int end) {

		return getPersistence().findBySubtitleId(subtitleId, start, end);
	}

	/**
	 * Returns an ordered range of all the books where subtitleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param subtitleId the subtitle ID
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 */
	public static List<Book> findBySubtitleId(
		String subtitleId, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findBySubtitleId(
			subtitleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the books where subtitleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param subtitleId the subtitle ID
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching books
	 */
	public static List<Book> findBySubtitleId(
		String subtitleId, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySubtitleId(
			subtitleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findBySubtitleId_First(
			String subtitleId, OrderByComparator<Book> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findBySubtitleId_First(
			subtitleId, orderByComparator);
	}

	/**
	 * Returns the first book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchBySubtitleId_First(
		String subtitleId, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchBySubtitleId_First(
			subtitleId, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findBySubtitleId_Last(
			String subtitleId, OrderByComparator<Book> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findBySubtitleId_Last(
			subtitleId, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchBySubtitleId_Last(
		String subtitleId, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchBySubtitleId_Last(
			subtitleId, orderByComparator);
	}

	/**
	 * Returns the books before and after the current book in the ordered set where subtitleId = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public static Book[] findBySubtitleId_PrevAndNext(
			String bookId, String subtitleId,
			OrderByComparator<Book> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findBySubtitleId_PrevAndNext(
			bookId, subtitleId, orderByComparator);
	}

	/**
	 * Removes all the books where subtitleId = &#63; from the database.
	 *
	 * @param subtitleId the subtitle ID
	 */
	public static void removeBySubtitleId(String subtitleId) {
		getPersistence().removeBySubtitleId(subtitleId);
	}

	/**
	 * Returns the number of books where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @return the number of matching books
	 */
	public static int countBySubtitleId(String subtitleId) {
		return getPersistence().countBySubtitleId(subtitleId);
	}

	/**
	 * Returns all the books where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching books
	 */
	public static List<Book> findByCategoryId(String categoryId) {
		return getPersistence().findByCategoryId(categoryId);
	}

	/**
	 * Returns a range of all the books where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 */
	public static List<Book> findByCategoryId(
		String categoryId, int start, int end) {

		return getPersistence().findByCategoryId(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the books where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 */
	public static List<Book> findByCategoryId(
		String categoryId, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findByCategoryId(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the books where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching books
	 */
	public static List<Book> findByCategoryId(
		String categoryId, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCategoryId(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByCategoryId_First(
			String categoryId, OrderByComparator<Book> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findByCategoryId_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByCategoryId_First(
		String categoryId, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByCategoryId_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByCategoryId_Last(
			String categoryId, OrderByComparator<Book> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findByCategoryId_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByCategoryId_Last(
		String categoryId, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByCategoryId_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the books before and after the current book in the ordered set where categoryId = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public static Book[] findByCategoryId_PrevAndNext(
			String bookId, String categoryId,
			OrderByComparator<Book> orderByComparator)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findByCategoryId_PrevAndNext(
			bookId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the books where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategoryId(String categoryId) {
		getPersistence().removeByCategoryId(categoryId);
	}

	/**
	 * Returns the number of books where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching books
	 */
	public static int countByCategoryId(String categoryId) {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	public static void cacheResult(Book book) {
		getPersistence().cacheResult(book);
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public static void cacheResult(List<Book> books) {
		getPersistence().cacheResult(books);
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public static Book create(String bookId) {
		return getPersistence().create(bookId);
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public static Book remove(String bookId)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().remove(bookId);
	}

	public static Book updateImpl(Book book) {
		return getPersistence().updateImpl(book);
	}

	/**
	 * Returns the book with the primary key or throws a <code>NoSuchBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public static Book findByPrimaryKey(String bookId)
		throws com.hehehe.servicebuilder.exception.NoSuchBookException {

		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	public static Book fetchByPrimaryKey(String bookId) {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 */
	public static List<Book> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of books
	 */
	public static List<Book> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of books
	 */
	public static List<Book> findAll(
		int start, int end, OrderByComparator<Book> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of books
	 */
	public static List<Book> findAll(
		int start, int end, OrderByComparator<Book> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the books from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BookPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BookPersistence _persistence;

}