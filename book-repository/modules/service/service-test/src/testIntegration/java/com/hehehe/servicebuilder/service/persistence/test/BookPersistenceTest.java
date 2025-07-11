/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.test;

import com.hehehe.servicebuilder.exception.NoSuchBookException;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.persistence.BookPersistence;
import com.hehehe.servicebuilder.service.persistence.BookUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class BookPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.hehehe.servicebuilder.service"));

	@Before
	public void setUp() {
		_persistence = BookUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Book> iterator = _books.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Book book = _persistence.create(pk);

		Assert.assertNotNull(book);

		Assert.assertEquals(book.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Book newBook = addBook();

		_persistence.remove(newBook);

		Book existingBook = _persistence.fetchByPrimaryKey(
			newBook.getPrimaryKey());

		Assert.assertNull(existingBook);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBook();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Book newBook = _persistence.create(pk);

		newBook.setTitle(RandomTestUtil.randomString());

		newBook.setCreateDate(RandomTestUtil.nextDate());

		newBook.setModifiedDate(RandomTestUtil.nextDate());

		newBook.setDescription(RandomTestUtil.randomString());

		newBook.setThumbnail(RandomTestUtil.randomString());

		newBook.setPublished_year();

		newBook.setNum_pages();

		newBook.setPrice();

		newBook.setStock();

		newBook.setSubtitleId(RandomTestUtil.randomString());

		newBook.setCategoryId(RandomTestUtil.randomString());

		_books.add(_persistence.update(newBook));

		Book existingBook = _persistence.findByPrimaryKey(
			newBook.getPrimaryKey());

		Assert.assertEquals(existingBook.getBookId(), newBook.getBookId());
		Assert.assertEquals(existingBook.getTitle(), newBook.getTitle());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBook.getCreateDate()),
			Time.getShortTimestamp(newBook.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBook.getModifiedDate()),
			Time.getShortTimestamp(newBook.getModifiedDate()));
		Assert.assertEquals(
			existingBook.getDescription(), newBook.getDescription());
		Assert.assertEquals(
			existingBook.getThumbnail(), newBook.getThumbnail());
		Assert.assertEquals(
			existingBook.getPublished_year(), newBook.getPublished_year());
		Assert.assertEquals(
			existingBook.getNum_pages(), newBook.getNum_pages());
		Assert.assertEquals(existingBook.getPrice(), newBook.getPrice());
		Assert.assertEquals(existingBook.getStock(), newBook.getStock());
		Assert.assertEquals(
			existingBook.getSubtitleId(), newBook.getSubtitleId());
		Assert.assertEquals(
			existingBook.getCategoryId(), newBook.getCategoryId());
	}

	@Test
	public void testCountBySubtitleId() throws Exception {
		_persistence.countBySubtitleId("");

		_persistence.countBySubtitleId("null");

		_persistence.countBySubtitleId((String)null);
	}

	@Test
	public void testCountByCategoryId() throws Exception {
		_persistence.countByCategoryId("");

		_persistence.countByCategoryId("null");

		_persistence.countByCategoryId((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Book newBook = addBook();

		Book existingBook = _persistence.findByPrimaryKey(
			newBook.getPrimaryKey());

		Assert.assertEquals(existingBook, newBook);
	}

	@Test(expected = NoSuchBookException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Book> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BookServiceBuilder_Book", "bookId", true, "title", true,
			"createDate", true, "modifiedDate", true, "description", true,
			"thumbnail", true, "published_year", true, "num_pages", true,
			"price", true, "stock", true, "subtitleId", true, "categoryId",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Book newBook = addBook();

		Book existingBook = _persistence.fetchByPrimaryKey(
			newBook.getPrimaryKey());

		Assert.assertEquals(existingBook, newBook);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Book missingBook = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBook);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Book newBook1 = addBook();
		Book newBook2 = addBook();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBook1.getPrimaryKey());
		primaryKeys.add(newBook2.getPrimaryKey());

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, books.size());
		Assert.assertEquals(newBook1, books.get(newBook1.getPrimaryKey()));
		Assert.assertEquals(newBook2, books.get(newBook2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(books.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Book newBook = addBook();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBook.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, books.size());
		Assert.assertEquals(newBook, books.get(newBook.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(books.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Book newBook = addBook();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBook.getPrimaryKey());

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, books.size());
		Assert.assertEquals(newBook, books.get(newBook.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Book newBook = addBook();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Book.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bookId", newBook.getBookId()));

		List<Book> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Book existingBook = result.get(0);

		Assert.assertEquals(existingBook, newBook);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Book.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"bookId", RandomTestUtil.randomString()));

		List<Book> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Book newBook = addBook();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Book.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bookId"));

		Object newBookId = newBook.getBookId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("bookId", new Object[] {newBookId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBookId = result.get(0);

		Assert.assertEquals(existingBookId, newBookId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Book.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bookId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"bookId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Book addBook() throws Exception {
		String pk = RandomTestUtil.randomString();

		Book book = _persistence.create(pk);

		book.setTitle(RandomTestUtil.randomString());

		book.setCreateDate(RandomTestUtil.nextDate());

		book.setModifiedDate(RandomTestUtil.nextDate());

		book.setDescription(RandomTestUtil.randomString());

		book.setThumbnail(RandomTestUtil.randomString());

		book.setPublished_year();

		book.setNum_pages();

		book.setPrice();

		book.setStock();

		book.setSubtitleId(RandomTestUtil.randomString());

		book.setCategoryId(RandomTestUtil.randomString());

		_books.add(_persistence.update(book));

		return book;
	}

	private List<Book> _books = new ArrayList<Book>();
	private BookPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}