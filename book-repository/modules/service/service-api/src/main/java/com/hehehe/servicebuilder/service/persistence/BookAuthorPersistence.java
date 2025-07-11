/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.exception.NoSuchBookAuthorException;
import com.hehehe.servicebuilder.model.BookAuthor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the book author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthorUtil
 * @generated
 */
@ProviderType
public interface BookAuthorPersistence extends BasePersistence<BookAuthor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookAuthorUtil} to access the book author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the book authors where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the matching book authors
	 */
	public java.util.List<BookAuthor> findByBookId(String bookId);

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
	public java.util.List<BookAuthor> findByBookId(
		String bookId, int start, int end);

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
	public java.util.List<BookAuthor> findByBookId(
		String bookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

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
	public java.util.List<BookAuthor> findByBookId(
		String bookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public BookAuthor findByBookId_First(
			String bookId,
			com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
				orderByComparator)
		throws NoSuchBookAuthorException;

	/**
	 * Returns the first book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public BookAuthor fetchByBookId_First(
		String bookId,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

	/**
	 * Returns the last book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public BookAuthor findByBookId_Last(
			String bookId,
			com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
				orderByComparator)
		throws NoSuchBookAuthorException;

	/**
	 * Returns the last book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public BookAuthor fetchByBookId_Last(
		String bookId,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

	/**
	 * Returns the book authors before and after the current book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookAuthorPK the primary key of the current book author
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public BookAuthor[] findByBookId_PrevAndNext(
			BookAuthorPK bookAuthorPK, String bookId,
			com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
				orderByComparator)
		throws NoSuchBookAuthorException;

	/**
	 * Removes all the book authors where bookId = &#63; from the database.
	 *
	 * @param bookId the book ID
	 */
	public void removeByBookId(String bookId);

	/**
	 * Returns the number of book authors where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the number of matching book authors
	 */
	public int countByBookId(String bookId);

	/**
	 * Returns all the book authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching book authors
	 */
	public java.util.List<BookAuthor> findByAuthorId(String authorId);

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
	public java.util.List<BookAuthor> findByAuthorId(
		String authorId, int start, int end);

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
	public java.util.List<BookAuthor> findByAuthorId(
		String authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

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
	public java.util.List<BookAuthor> findByAuthorId(
		String authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public BookAuthor findByAuthorId_First(
			String authorId,
			com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
				orderByComparator)
		throws NoSuchBookAuthorException;

	/**
	 * Returns the first book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public BookAuthor fetchByAuthorId_First(
		String authorId,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

	/**
	 * Returns the last book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	public BookAuthor findByAuthorId_Last(
			String authorId,
			com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
				orderByComparator)
		throws NoSuchBookAuthorException;

	/**
	 * Returns the last book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author, or <code>null</code> if a matching book author could not be found
	 */
	public BookAuthor fetchByAuthorId_Last(
		String authorId,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

	/**
	 * Returns the book authors before and after the current book author in the ordered set where authorId = &#63;.
	 *
	 * @param bookAuthorPK the primary key of the current book author
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public BookAuthor[] findByAuthorId_PrevAndNext(
			BookAuthorPK bookAuthorPK, String authorId,
			com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
				orderByComparator)
		throws NoSuchBookAuthorException;

	/**
	 * Removes all the book authors where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 */
	public void removeByAuthorId(String authorId);

	/**
	 * Returns the number of book authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching book authors
	 */
	public int countByAuthorId(String authorId);

	/**
	 * Caches the book author in the entity cache if it is enabled.
	 *
	 * @param bookAuthor the book author
	 */
	public void cacheResult(BookAuthor bookAuthor);

	/**
	 * Caches the book authors in the entity cache if it is enabled.
	 *
	 * @param bookAuthors the book authors
	 */
	public void cacheResult(java.util.List<BookAuthor> bookAuthors);

	/**
	 * Creates a new book author with the primary key. Does not add the book author to the database.
	 *
	 * @param bookAuthorPK the primary key for the new book author
	 * @return the new book author
	 */
	public BookAuthor create(BookAuthorPK bookAuthorPK);

	/**
	 * Removes the book author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author that was removed
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public BookAuthor remove(BookAuthorPK bookAuthorPK)
		throws NoSuchBookAuthorException;

	public BookAuthor updateImpl(BookAuthor bookAuthor);

	/**
	 * Returns the book author with the primary key or throws a <code>NoSuchBookAuthorException</code> if it could not be found.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	public BookAuthor findByPrimaryKey(BookAuthorPK bookAuthorPK)
		throws NoSuchBookAuthorException;

	/**
	 * Returns the book author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author, or <code>null</code> if a book author with the primary key could not be found
	 */
	public BookAuthor fetchByPrimaryKey(BookAuthorPK bookAuthorPK);

	/**
	 * Returns all the book authors.
	 *
	 * @return the book authors
	 */
	public java.util.List<BookAuthor> findAll();

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
	public java.util.List<BookAuthor> findAll(int start, int end);

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
	public java.util.List<BookAuthor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator);

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
	public java.util.List<BookAuthor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookAuthor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the book authors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of book authors.
	 *
	 * @return the number of book authors
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}