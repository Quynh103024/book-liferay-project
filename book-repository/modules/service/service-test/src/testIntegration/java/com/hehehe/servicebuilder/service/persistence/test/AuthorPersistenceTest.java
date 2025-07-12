/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.test;

import com.hehehe.servicebuilder.exception.NoSuchAuthorException;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.service.persistence.AuthorPersistence;
import com.hehehe.servicebuilder.service.persistence.AuthorUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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
public class AuthorPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.hehehe.servicebuilder.service"));

	@Before
	public void setUp() {
		_persistence = AuthorUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Author> iterator = _authors.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Author author = _persistence.create(pk);

		Assert.assertNotNull(author);

		Assert.assertEquals(author.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Author newAuthor = addAuthor();

		_persistence.remove(newAuthor);

		Author existingAuthor = _persistence.fetchByPrimaryKey(
			newAuthor.getPrimaryKey());

		Assert.assertNull(existingAuthor);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAuthor();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Author newAuthor = _persistence.create(pk);

		newAuthor.setName(RandomTestUtil.randomString());

		newAuthor.setCreateDate(RandomTestUtil.nextDate());

		newAuthor.setModifiedDate(RandomTestUtil.nextDate());

		_authors.add(_persistence.update(newAuthor));

		Author existingAuthor = _persistence.findByPrimaryKey(
			newAuthor.getPrimaryKey());

		Assert.assertEquals(
			existingAuthor.getAuthorId(), newAuthor.getAuthorId());
		Assert.assertEquals(existingAuthor.getName(), newAuthor.getName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAuthor.getCreateDate()),
			Time.getShortTimestamp(newAuthor.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAuthor.getModifiedDate()),
			Time.getShortTimestamp(newAuthor.getModifiedDate()));
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Author newAuthor = addAuthor();

		Author existingAuthor = _persistence.findByPrimaryKey(
			newAuthor.getPrimaryKey());

		Assert.assertEquals(existingAuthor, newAuthor);
	}

	@Test(expected = NoSuchAuthorException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Author> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BookServiceBuilder_Author", "authorId", true, "name", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Author newAuthor = addAuthor();

		Author existingAuthor = _persistence.fetchByPrimaryKey(
			newAuthor.getPrimaryKey());

		Assert.assertEquals(existingAuthor, newAuthor);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Author missingAuthor = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAuthor);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Author newAuthor1 = addAuthor();
		Author newAuthor2 = addAuthor();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuthor1.getPrimaryKey());
		primaryKeys.add(newAuthor2.getPrimaryKey());

		Map<Serializable, Author> authors = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, authors.size());
		Assert.assertEquals(
			newAuthor1, authors.get(newAuthor1.getPrimaryKey()));
		Assert.assertEquals(
			newAuthor2, authors.get(newAuthor2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Author> authors = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(authors.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Author newAuthor = addAuthor();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuthor.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Author> authors = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, authors.size());
		Assert.assertEquals(newAuthor, authors.get(newAuthor.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Author> authors = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(authors.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Author newAuthor = addAuthor();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuthor.getPrimaryKey());

		Map<Serializable, Author> authors = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, authors.size());
		Assert.assertEquals(newAuthor, authors.get(newAuthor.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Author newAuthor = addAuthor();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Author.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("authorId", newAuthor.getAuthorId()));

		List<Author> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Author existingAuthor = result.get(0);

		Assert.assertEquals(existingAuthor, newAuthor);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Author.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"authorId", RandomTestUtil.randomString()));

		List<Author> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Author newAuthor = addAuthor();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Author.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("authorId"));

		Object newAuthorId = newAuthor.getAuthorId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("authorId", new Object[] {newAuthorId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAuthorId = result.get(0);

		Assert.assertEquals(existingAuthorId, newAuthorId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Author.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("authorId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"authorId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Author newAuthor = addAuthor();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAuthor.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Author newAuthor = addAuthor();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Author.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("authorId", newAuthor.getAuthorId()));

		List<Author> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Author author) {
		Assert.assertEquals(
			author.getName(),
			ReflectionTestUtil.invoke(
				author, "getColumnOriginalValue", new Class<?>[] {String.class},
				"name"));
	}

	protected Author addAuthor() throws Exception {
		String pk = RandomTestUtil.randomString();

		Author author = _persistence.create(pk);

		author.setName(RandomTestUtil.randomString());

		author.setCreateDate(RandomTestUtil.nextDate());

		author.setModifiedDate(RandomTestUtil.nextDate());

		_authors.add(_persistence.update(author));

		return author;
	}

	private List<Author> _authors = new ArrayList<Author>();
	private AuthorPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}