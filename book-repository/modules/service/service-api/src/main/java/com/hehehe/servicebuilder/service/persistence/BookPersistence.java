/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.exception.NoSuchBookException;
import com.hehehe.servicebuilder.model.Book;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookUtil
 * @generated
 */
@ProviderType
public interface BookPersistence extends BasePersistence<Book> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the books where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching books
	 */
	public java.util.List<Book> findByTitle(String title);

	/**
	 * Returns a range of all the books where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 */
	public java.util.List<Book> findByTitle(String title, int start, int end);

	/**
	 * Returns an ordered range of all the books where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 */
	public java.util.List<Book> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns an ordered range of all the books where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching books
	 */
	public java.util.List<Book> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the first book in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the last book in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the last book in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the books before and after the current book in the ordered set where title = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book[] findByTitle_PrevAndNext(
			String bookId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Removes all the books where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of books where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching books
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the books where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @return the matching books
	 */
	public java.util.List<Book> findBySubtitleId(String subtitleId);

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
	public java.util.List<Book> findBySubtitleId(
		String subtitleId, int start, int end);

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
	public java.util.List<Book> findBySubtitleId(
		String subtitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findBySubtitleId(
		String subtitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findBySubtitleId_First(
			String subtitleId,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the first book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchBySubtitleId_First(
		String subtitleId,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the last book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findBySubtitleId_Last(
			String subtitleId,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the last book in the ordered set where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchBySubtitleId_Last(
		String subtitleId,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the books before and after the current book in the ordered set where subtitleId = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param subtitleId the subtitle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book[] findBySubtitleId_PrevAndNext(
			String bookId, String subtitleId,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Removes all the books where subtitleId = &#63; from the database.
	 *
	 * @param subtitleId the subtitle ID
	 */
	public void removeBySubtitleId(String subtitleId);

	/**
	 * Returns the number of books where subtitleId = &#63;.
	 *
	 * @param subtitleId the subtitle ID
	 * @return the number of matching books
	 */
	public int countBySubtitleId(String subtitleId);

	/**
	 * Returns all the books where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching books
	 */
	public java.util.List<Book> findByCategoryId(String categoryId);

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
	public java.util.List<Book> findByCategoryId(
		String categoryId, int start, int end);

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
	public java.util.List<Book> findByCategoryId(
		String categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findByCategoryId(
		String categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByCategoryId_First(
			String categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the first book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByCategoryId_First(
		String categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the last book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByCategoryId_Last(
			String categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the last book in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByCategoryId_Last(
		String categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the books before and after the current book in the ordered set where categoryId = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book[] findByCategoryId_PrevAndNext(
			String bookId, String categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Removes all the books where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByCategoryId(String categoryId);

	/**
	 * Returns the number of books where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching books
	 */
	public int countByCategoryId(String categoryId);

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	public void cacheResult(Book book);

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public void cacheResult(java.util.List<Book> books);

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public Book create(String bookId);

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book remove(String bookId) throws NoSuchBookException;

	public Book updateImpl(Book book);

	/**
	 * Returns the book with the primary key or throws a <code>NoSuchBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book findByPrimaryKey(String bookId) throws NoSuchBookException;

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	public Book fetchByPrimaryKey(String bookId);

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 */
	public java.util.List<Book> findAll();

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
	public java.util.List<Book> findAll(int start, int end);

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
	public java.util.List<Book> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the books from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	public int countAll();

}