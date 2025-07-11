/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.impl;

import com.hehehe.servicebuilder.exception.NoSuchBookAuthorException;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.model.BookAuthorTable;
import com.hehehe.servicebuilder.model.impl.BookAuthorImpl;
import com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPK;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPersistence;
import com.hehehe.servicebuilder.service.persistence.BookAuthorUtil;
import com.hehehe.servicebuilder.service.persistence.impl.constants.BookServiceBuilderPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the book author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookAuthorPersistence.class)
public class BookAuthorPersistenceImpl
	extends BasePersistenceImpl<BookAuthor> implements BookAuthorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookAuthorUtil</code> to access the book author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookAuthorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByBookId;
	private FinderPath _finderPathWithoutPaginationFindByBookId;
	private FinderPath _finderPathCountByBookId;

	/**
	 * Returns all the book authors where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the matching book authors
	 */
	@Override
	public List<BookAuthor> findByBookId(String bookId) {
		return findByBookId(bookId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BookAuthor> findByBookId(String bookId, int start, int end) {
		return findByBookId(bookId, start, end, null);
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
	@Override
	public List<BookAuthor> findByBookId(
		String bookId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator) {

		return findByBookId(bookId, start, end, orderByComparator, true);
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
	@Override
	public List<BookAuthor> findByBookId(
		String bookId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator,
		boolean useFinderCache) {

		bookId = Objects.toString(bookId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBookId;
				finderArgs = new Object[] {bookId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBookId;
			finderArgs = new Object[] {bookId, start, end, orderByComparator};
		}

		List<BookAuthor> list = null;

		if (useFinderCache) {
			list = (List<BookAuthor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookAuthor bookAuthor : list) {
					if (!bookId.equals(bookAuthor.getBookId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BOOKAUTHOR_WHERE);

			boolean bindBookId = false;

			if (bookId.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOOKID_BOOKID_3);
			}
			else {
				bindBookId = true;

				sb.append(_FINDER_COLUMN_BOOKID_BOOKID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookAuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookId) {
					queryPos.add(bookId);
				}

				list = (List<BookAuthor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	@Override
	public BookAuthor findByBookId_First(
			String bookId, OrderByComparator<BookAuthor> orderByComparator)
		throws NoSuchBookAuthorException {

		BookAuthor bookAuthor = fetchByBookId_First(bookId, orderByComparator);

		if (bookAuthor != null) {
			return bookAuthor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookId=");
		sb.append(bookId);

		sb.append("}");

		throw new NoSuchBookAuthorException(sb.toString());
	}

	/**
	 * Returns the first book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author, or <code>null</code> if a matching book author could not be found
	 */
	@Override
	public BookAuthor fetchByBookId_First(
		String bookId, OrderByComparator<BookAuthor> orderByComparator) {

		List<BookAuthor> list = findByBookId(bookId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	@Override
	public BookAuthor findByBookId_Last(
			String bookId, OrderByComparator<BookAuthor> orderByComparator)
		throws NoSuchBookAuthorException {

		BookAuthor bookAuthor = fetchByBookId_Last(bookId, orderByComparator);

		if (bookAuthor != null) {
			return bookAuthor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookId=");
		sb.append(bookId);

		sb.append("}");

		throw new NoSuchBookAuthorException(sb.toString());
	}

	/**
	 * Returns the last book author in the ordered set where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author, or <code>null</code> if a matching book author could not be found
	 */
	@Override
	public BookAuthor fetchByBookId_Last(
		String bookId, OrderByComparator<BookAuthor> orderByComparator) {

		int count = countByBookId(bookId);

		if (count == 0) {
			return null;
		}

		List<BookAuthor> list = findByBookId(
			bookId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BookAuthor[] findByBookId_PrevAndNext(
			BookAuthorPK bookAuthorPK, String bookId,
			OrderByComparator<BookAuthor> orderByComparator)
		throws NoSuchBookAuthorException {

		bookId = Objects.toString(bookId, "");

		BookAuthor bookAuthor = findByPrimaryKey(bookAuthorPK);

		Session session = null;

		try {
			session = openSession();

			BookAuthor[] array = new BookAuthorImpl[3];

			array[0] = getByBookId_PrevAndNext(
				session, bookAuthor, bookId, orderByComparator, true);

			array[1] = bookAuthor;

			array[2] = getByBookId_PrevAndNext(
				session, bookAuthor, bookId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookAuthor getByBookId_PrevAndNext(
		Session session, BookAuthor bookAuthor, String bookId,
		OrderByComparator<BookAuthor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKAUTHOR_WHERE);

		boolean bindBookId = false;

		if (bookId.isEmpty()) {
			sb.append(_FINDER_COLUMN_BOOKID_BOOKID_3);
		}
		else {
			bindBookId = true;

			sb.append(_FINDER_COLUMN_BOOKID_BOOKID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BookAuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBookId) {
			queryPos.add(bookId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bookAuthor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookAuthor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book authors where bookId = &#63; from the database.
	 *
	 * @param bookId the book ID
	 */
	@Override
	public void removeByBookId(String bookId) {
		for (BookAuthor bookAuthor :
				findByBookId(
					bookId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookAuthor);
		}
	}

	/**
	 * Returns the number of book authors where bookId = &#63;.
	 *
	 * @param bookId the book ID
	 * @return the number of matching book authors
	 */
	@Override
	public int countByBookId(String bookId) {
		bookId = Objects.toString(bookId, "");

		FinderPath finderPath = _finderPathCountByBookId;

		Object[] finderArgs = new Object[] {bookId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKAUTHOR_WHERE);

			boolean bindBookId = false;

			if (bookId.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOOKID_BOOKID_3);
			}
			else {
				bindBookId = true;

				sb.append(_FINDER_COLUMN_BOOKID_BOOKID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookId) {
					queryPos.add(bookId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKID_BOOKID_2 =
		"bookAuthor.id.bookId = ?";

	private static final String _FINDER_COLUMN_BOOKID_BOOKID_3 =
		"(bookAuthor.id.bookId IS NULL OR bookAuthor.id.bookId = '')";

	private FinderPath _finderPathWithPaginationFindByAuthorId;
	private FinderPath _finderPathWithoutPaginationFindByAuthorId;
	private FinderPath _finderPathCountByAuthorId;

	/**
	 * Returns all the book authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching book authors
	 */
	@Override
	public List<BookAuthor> findByAuthorId(String authorId) {
		return findByAuthorId(
			authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BookAuthor> findByAuthorId(
		String authorId, int start, int end) {

		return findByAuthorId(authorId, start, end, null);
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
	@Override
	public List<BookAuthor> findByAuthorId(
		String authorId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator) {

		return findByAuthorId(authorId, start, end, orderByComparator, true);
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
	@Override
	public List<BookAuthor> findByAuthorId(
		String authorId, int start, int end,
		OrderByComparator<BookAuthor> orderByComparator,
		boolean useFinderCache) {

		authorId = Objects.toString(authorId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAuthorId;
				finderArgs = new Object[] {authorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAuthorId;
			finderArgs = new Object[] {authorId, start, end, orderByComparator};
		}

		List<BookAuthor> list = null;

		if (useFinderCache) {
			list = (List<BookAuthor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookAuthor bookAuthor : list) {
					if (!authorId.equals(bookAuthor.getAuthorId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BOOKAUTHOR_WHERE);

			boolean bindAuthorId = false;

			if (authorId.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_3);
			}
			else {
				bindAuthorId = true;

				sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookAuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAuthorId) {
					queryPos.add(authorId);
				}

				list = (List<BookAuthor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	@Override
	public BookAuthor findByAuthorId_First(
			String authorId, OrderByComparator<BookAuthor> orderByComparator)
		throws NoSuchBookAuthorException {

		BookAuthor bookAuthor = fetchByAuthorId_First(
			authorId, orderByComparator);

		if (bookAuthor != null) {
			return bookAuthor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authorId=");
		sb.append(authorId);

		sb.append("}");

		throw new NoSuchBookAuthorException(sb.toString());
	}

	/**
	 * Returns the first book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book author, or <code>null</code> if a matching book author could not be found
	 */
	@Override
	public BookAuthor fetchByAuthorId_First(
		String authorId, OrderByComparator<BookAuthor> orderByComparator) {

		List<BookAuthor> list = findByAuthorId(
			authorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author
	 * @throws NoSuchBookAuthorException if a matching book author could not be found
	 */
	@Override
	public BookAuthor findByAuthorId_Last(
			String authorId, OrderByComparator<BookAuthor> orderByComparator)
		throws NoSuchBookAuthorException {

		BookAuthor bookAuthor = fetchByAuthorId_Last(
			authorId, orderByComparator);

		if (bookAuthor != null) {
			return bookAuthor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authorId=");
		sb.append(authorId);

		sb.append("}");

		throw new NoSuchBookAuthorException(sb.toString());
	}

	/**
	 * Returns the last book author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book author, or <code>null</code> if a matching book author could not be found
	 */
	@Override
	public BookAuthor fetchByAuthorId_Last(
		String authorId, OrderByComparator<BookAuthor> orderByComparator) {

		int count = countByAuthorId(authorId);

		if (count == 0) {
			return null;
		}

		List<BookAuthor> list = findByAuthorId(
			authorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BookAuthor[] findByAuthorId_PrevAndNext(
			BookAuthorPK bookAuthorPK, String authorId,
			OrderByComparator<BookAuthor> orderByComparator)
		throws NoSuchBookAuthorException {

		authorId = Objects.toString(authorId, "");

		BookAuthor bookAuthor = findByPrimaryKey(bookAuthorPK);

		Session session = null;

		try {
			session = openSession();

			BookAuthor[] array = new BookAuthorImpl[3];

			array[0] = getByAuthorId_PrevAndNext(
				session, bookAuthor, authorId, orderByComparator, true);

			array[1] = bookAuthor;

			array[2] = getByAuthorId_PrevAndNext(
				session, bookAuthor, authorId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookAuthor getByAuthorId_PrevAndNext(
		Session session, BookAuthor bookAuthor, String authorId,
		OrderByComparator<BookAuthor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKAUTHOR_WHERE);

		boolean bindAuthorId = false;

		if (authorId.isEmpty()) {
			sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_3);
		}
		else {
			bindAuthorId = true;

			sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BookAuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAuthorId) {
			queryPos.add(authorId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bookAuthor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookAuthor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book authors where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 */
	@Override
	public void removeByAuthorId(String authorId) {
		for (BookAuthor bookAuthor :
				findByAuthorId(
					authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookAuthor);
		}
	}

	/**
	 * Returns the number of book authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching book authors
	 */
	@Override
	public int countByAuthorId(String authorId) {
		authorId = Objects.toString(authorId, "");

		FinderPath finderPath = _finderPathCountByAuthorId;

		Object[] finderArgs = new Object[] {authorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKAUTHOR_WHERE);

			boolean bindAuthorId = false;

			if (authorId.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_3);
			}
			else {
				bindAuthorId = true;

				sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAuthorId) {
					queryPos.add(authorId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_2 =
		"bookAuthor.id.authorId = ?";

	private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_3 =
		"(bookAuthor.id.authorId IS NULL OR bookAuthor.id.authorId = '')";

	public BookAuthorPersistenceImpl() {
		setModelClass(BookAuthor.class);

		setModelImplClass(BookAuthorImpl.class);
		setModelPKClass(BookAuthorPK.class);

		setTable(BookAuthorTable.INSTANCE);
	}

	/**
	 * Caches the book author in the entity cache if it is enabled.
	 *
	 * @param bookAuthor the book author
	 */
	@Override
	public void cacheResult(BookAuthor bookAuthor) {
		entityCache.putResult(
			BookAuthorImpl.class, bookAuthor.getPrimaryKey(), bookAuthor);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the book authors in the entity cache if it is enabled.
	 *
	 * @param bookAuthors the book authors
	 */
	@Override
	public void cacheResult(List<BookAuthor> bookAuthors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bookAuthors.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BookAuthor bookAuthor : bookAuthors) {
			if (entityCache.getResult(
					BookAuthorImpl.class, bookAuthor.getPrimaryKey()) == null) {

				cacheResult(bookAuthor);
			}
		}
	}

	/**
	 * Clears the cache for all book authors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookAuthorImpl.class);

		finderCache.clearCache(BookAuthorImpl.class);
	}

	/**
	 * Clears the cache for the book author.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookAuthor bookAuthor) {
		entityCache.removeResult(BookAuthorImpl.class, bookAuthor);
	}

	@Override
	public void clearCache(List<BookAuthor> bookAuthors) {
		for (BookAuthor bookAuthor : bookAuthors) {
			entityCache.removeResult(BookAuthorImpl.class, bookAuthor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BookAuthorImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookAuthorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new book author with the primary key. Does not add the book author to the database.
	 *
	 * @param bookAuthorPK the primary key for the new book author
	 * @return the new book author
	 */
	@Override
	public BookAuthor create(BookAuthorPK bookAuthorPK) {
		BookAuthor bookAuthor = new BookAuthorImpl();

		bookAuthor.setNew(true);
		bookAuthor.setPrimaryKey(bookAuthorPK);

		return bookAuthor;
	}

	/**
	 * Removes the book author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author that was removed
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	@Override
	public BookAuthor remove(BookAuthorPK bookAuthorPK)
		throws NoSuchBookAuthorException {

		return remove((Serializable)bookAuthorPK);
	}

	/**
	 * Removes the book author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book author
	 * @return the book author that was removed
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	@Override
	public BookAuthor remove(Serializable primaryKey)
		throws NoSuchBookAuthorException {

		Session session = null;

		try {
			session = openSession();

			BookAuthor bookAuthor = (BookAuthor)session.get(
				BookAuthorImpl.class, primaryKey);

			if (bookAuthor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookAuthorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bookAuthor);
		}
		catch (NoSuchBookAuthorException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BookAuthor removeImpl(BookAuthor bookAuthor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookAuthor)) {
				bookAuthor = (BookAuthor)session.get(
					BookAuthorImpl.class, bookAuthor.getPrimaryKeyObj());
			}

			if (bookAuthor != null) {
				session.delete(bookAuthor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bookAuthor != null) {
			clearCache(bookAuthor);
		}

		return bookAuthor;
	}

	@Override
	public BookAuthor updateImpl(BookAuthor bookAuthor) {
		boolean isNew = bookAuthor.isNew();

		if (!(bookAuthor instanceof BookAuthorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bookAuthor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bookAuthor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bookAuthor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BookAuthor implementation " +
					bookAuthor.getClass());
		}

		BookAuthorModelImpl bookAuthorModelImpl =
			(BookAuthorModelImpl)bookAuthor;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (bookAuthor.getCreateDate() == null)) {
			if (serviceContext == null) {
				bookAuthor.setCreateDate(date);
			}
			else {
				bookAuthor.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bookAuthorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bookAuthor.setModifiedDate(date);
			}
			else {
				bookAuthor.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bookAuthor);
			}
			else {
				bookAuthor = (BookAuthor)session.merge(bookAuthor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BookAuthorImpl.class, bookAuthorModelImpl, false, true);

		if (isNew) {
			bookAuthor.setNew(false);
		}

		bookAuthor.resetOriginalValues();

		return bookAuthor;
	}

	/**
	 * Returns the book author with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book author
	 * @return the book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	@Override
	public BookAuthor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookAuthorException {

		BookAuthor bookAuthor = fetchByPrimaryKey(primaryKey);

		if (bookAuthor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookAuthorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bookAuthor;
	}

	/**
	 * Returns the book author with the primary key or throws a <code>NoSuchBookAuthorException</code> if it could not be found.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author
	 * @throws NoSuchBookAuthorException if a book author with the primary key could not be found
	 */
	@Override
	public BookAuthor findByPrimaryKey(BookAuthorPK bookAuthorPK)
		throws NoSuchBookAuthorException {

		return findByPrimaryKey((Serializable)bookAuthorPK);
	}

	/**
	 * Returns the book author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookAuthorPK the primary key of the book author
	 * @return the book author, or <code>null</code> if a book author with the primary key could not be found
	 */
	@Override
	public BookAuthor fetchByPrimaryKey(BookAuthorPK bookAuthorPK) {
		return fetchByPrimaryKey((Serializable)bookAuthorPK);
	}

	/**
	 * Returns all the book authors.
	 *
	 * @return the book authors
	 */
	@Override
	public List<BookAuthor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BookAuthor> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<BookAuthor> findAll(
		int start, int end, OrderByComparator<BookAuthor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<BookAuthor> findAll(
		int start, int end, OrderByComparator<BookAuthor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<BookAuthor> list = null;

		if (useFinderCache) {
			list = (List<BookAuthor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOKAUTHOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKAUTHOR;

				sql = sql.concat(BookAuthorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BookAuthor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the book authors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BookAuthor bookAuthor : findAll()) {
			remove(bookAuthor);
		}
	}

	/**
	 * Returns the number of book authors.
	 *
	 * @return the number of book authors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOKAUTHOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "bookAuthorPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOKAUTHOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookAuthorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the book author persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByBookId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bookId"}, true);

		_finderPathWithoutPaginationFindByBookId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookId",
			new String[] {String.class.getName()}, new String[] {"bookId"},
			true);

		_finderPathCountByBookId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookId",
			new String[] {String.class.getName()}, new String[] {"bookId"},
			false);

		_finderPathWithPaginationFindByAuthorId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"authorId"}, true);

		_finderPathWithoutPaginationFindByAuthorId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthorId",
			new String[] {String.class.getName()}, new String[] {"authorId"},
			true);

		_finderPathCountByAuthorId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthorId",
			new String[] {String.class.getName()}, new String[] {"authorId"},
			false);

		BookAuthorUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BookAuthorUtil.setPersistence(null);

		entityCache.removeCache(BookAuthorImpl.class.getName());
	}

	@Override
	@Reference(
		target = BookServiceBuilderPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BookServiceBuilderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BookServiceBuilderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOOKAUTHOR =
		"SELECT bookAuthor FROM BookAuthor bookAuthor";

	private static final String _SQL_SELECT_BOOKAUTHOR_WHERE =
		"SELECT bookAuthor FROM BookAuthor bookAuthor WHERE ";

	private static final String _SQL_COUNT_BOOKAUTHOR =
		"SELECT COUNT(bookAuthor) FROM BookAuthor bookAuthor";

	private static final String _SQL_COUNT_BOOKAUTHOR_WHERE =
		"SELECT COUNT(bookAuthor) FROM BookAuthor bookAuthor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bookAuthor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BookAuthor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BookAuthor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BookAuthorPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"bookId", "authorId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}