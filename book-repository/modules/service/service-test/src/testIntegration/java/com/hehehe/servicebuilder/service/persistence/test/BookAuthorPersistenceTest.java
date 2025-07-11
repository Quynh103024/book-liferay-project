/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.test;

import com.hehehe.servicebuilder.exception.NoSuchBookAuthorException;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPK;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPersistence;
import com.hehehe.servicebuilder.service.persistence.BookAuthorUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
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
public class BookAuthorPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.hehehe.servicebuilder.service"));

	@Before
	public void setUp() {
		_persistence = BookAuthorUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BookAuthor> iterator = _bookAuthors.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		BookAuthorPK pk = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		BookAuthor bookAuthor = _persistence.create(pk);

		Assert.assertNotNull(bookAuthor);

		Assert.assertEquals(bookAuthor.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BookAuthor newBookAuthor = addBookAuthor();

		_persistence.remove(newBookAuthor);

		BookAuthor existingBookAuthor = _persistence.fetchByPrimaryKey(
			newBookAuthor.getPrimaryKey());

		Assert.assertNull(existingBookAuthor);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBookAuthor();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		BookAuthorPK pk = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		BookAuthor newBookAuthor = _persistence.create(pk);

		newBookAuthor.setCreateDate(RandomTestUtil.nextDate());

		newBookAuthor.setModifiedDate(RandomTestUtil.nextDate());

		_bookAuthors.add(_persistence.update(newBookAuthor));

		BookAuthor existingBookAuthor = _persistence.findByPrimaryKey(
			newBookAuthor.getPrimaryKey());

		Assert.assertEquals(
			existingBookAuthor.getBookId(), newBookAuthor.getBookId());
		Assert.assertEquals(
			existingBookAuthor.getAuthorId(), newBookAuthor.getAuthorId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookAuthor.getCreateDate()),
			Time.getShortTimestamp(newBookAuthor.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookAuthor.getModifiedDate()),
			Time.getShortTimestamp(newBookAuthor.getModifiedDate()));
	}

	@Test
	public void testCountByBookId() throws Exception {
		_persistence.countByBookId("");

		_persistence.countByBookId("null");

		_persistence.countByBookId((String)null);
	}

	@Test
	public void testCountByAuthorId() throws Exception {
		_persistence.countByAuthorId("");

		_persistence.countByAuthorId("null");

		_persistence.countByAuthorId((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BookAuthor newBookAuthor = addBookAuthor();

		BookAuthor existingBookAuthor = _persistence.findByPrimaryKey(
			newBookAuthor.getPrimaryKey());

		Assert.assertEquals(existingBookAuthor, newBookAuthor);
	}

	@Test(expected = NoSuchBookAuthorException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		BookAuthorPK pk = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BookAuthor newBookAuthor = addBookAuthor();

		BookAuthor existingBookAuthor = _persistence.fetchByPrimaryKey(
			newBookAuthor.getPrimaryKey());

		Assert.assertEquals(existingBookAuthor, newBookAuthor);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		BookAuthorPK pk = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		BookAuthor missingBookAuthor = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBookAuthor);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BookAuthor newBookAuthor1 = addBookAuthor();
		BookAuthor newBookAuthor2 = addBookAuthor();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookAuthor1.getPrimaryKey());
		primaryKeys.add(newBookAuthor2.getPrimaryKey());

		Map<Serializable, BookAuthor> bookAuthors =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bookAuthors.size());
		Assert.assertEquals(
			newBookAuthor1, bookAuthors.get(newBookAuthor1.getPrimaryKey()));
		Assert.assertEquals(
			newBookAuthor2, bookAuthors.get(newBookAuthor2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		BookAuthorPK pk1 = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		BookAuthorPK pk2 = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BookAuthor> bookAuthors =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bookAuthors.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BookAuthor newBookAuthor = addBookAuthor();

		BookAuthorPK pk = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookAuthor.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BookAuthor> bookAuthors =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bookAuthors.size());
		Assert.assertEquals(
			newBookAuthor, bookAuthors.get(newBookAuthor.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BookAuthor> bookAuthors =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bookAuthors.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BookAuthor newBookAuthor = addBookAuthor();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookAuthor.getPrimaryKey());

		Map<Serializable, BookAuthor> bookAuthors =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bookAuthors.size());
		Assert.assertEquals(
			newBookAuthor, bookAuthors.get(newBookAuthor.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BookAuthor newBookAuthor = addBookAuthor();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookAuthor.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.bookId", newBookAuthor.getBookId()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.authorId", newBookAuthor.getAuthorId()));

		List<BookAuthor> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BookAuthor existingBookAuthor = result.get(0);

		Assert.assertEquals(existingBookAuthor, newBookAuthor);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookAuthor.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.bookId", RandomTestUtil.randomString()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.authorId", RandomTestUtil.randomString()));

		List<BookAuthor> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BookAuthor newBookAuthor = addBookAuthor();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookAuthor.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.bookId"));

		Object newBookId = newBookAuthor.getBookId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id.bookId", new Object[] {newBookId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBookId = result.get(0);

		Assert.assertEquals(existingBookId, newBookId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookAuthor.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.bookId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.bookId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected BookAuthor addBookAuthor() throws Exception {
		BookAuthorPK pk = new BookAuthorPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		BookAuthor bookAuthor = _persistence.create(pk);

		bookAuthor.setCreateDate(RandomTestUtil.nextDate());

		bookAuthor.setModifiedDate(RandomTestUtil.nextDate());

		_bookAuthors.add(_persistence.update(bookAuthor));

		return bookAuthor;
	}

	private List<BookAuthor> _bookAuthors = new ArrayList<BookAuthor>();
	private BookAuthorPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}