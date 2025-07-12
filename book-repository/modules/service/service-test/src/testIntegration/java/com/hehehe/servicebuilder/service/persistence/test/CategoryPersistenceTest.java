/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.test;

import com.hehehe.servicebuilder.exception.NoSuchCategoryException;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.service.persistence.CategoryPersistence;
import com.hehehe.servicebuilder.service.persistence.CategoryUtil;

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
public class CategoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.hehehe.servicebuilder.service"));

	@Before
	public void setUp() {
		_persistence = CategoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Category> iterator = _categories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Category category = _persistence.create(pk);

		Assert.assertNotNull(category);

		Assert.assertEquals(category.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Category newCategory = addCategory();

		_persistence.remove(newCategory);

		Category existingCategory = _persistence.fetchByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertNull(existingCategory);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCategory();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Category newCategory = _persistence.create(pk);

		newCategory.setName(RandomTestUtil.randomString());

		newCategory.setCreateDate(RandomTestUtil.nextDate());

		newCategory.setModifiedDate(RandomTestUtil.nextDate());

		_categories.add(_persistence.update(newCategory));

		Category existingCategory = _persistence.findByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertEquals(
			existingCategory.getCategoryId(), newCategory.getCategoryId());
		Assert.assertEquals(existingCategory.getName(), newCategory.getName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCategory.getCreateDate()),
			Time.getShortTimestamp(newCategory.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCategory.getModifiedDate()),
			Time.getShortTimestamp(newCategory.getModifiedDate()));
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Category newCategory = addCategory();

		Category existingCategory = _persistence.findByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertEquals(existingCategory, newCategory);
	}

	@Test(expected = NoSuchCategoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Category> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BookServiceBuilder_Category", "categoryId", true, "name", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Category newCategory = addCategory();

		Category existingCategory = _persistence.fetchByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertEquals(existingCategory, newCategory);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Category missingCategory = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCategory);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Category newCategory1 = addCategory();
		Category newCategory2 = addCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategory1.getPrimaryKey());
		primaryKeys.add(newCategory2.getPrimaryKey());

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, categories.size());
		Assert.assertEquals(
			newCategory1, categories.get(newCategory1.getPrimaryKey()));
		Assert.assertEquals(
			newCategory2, categories.get(newCategory2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(categories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Category newCategory = addCategory();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategory.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, categories.size());
		Assert.assertEquals(
			newCategory, categories.get(newCategory.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(categories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Category newCategory = addCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategory.getPrimaryKey());

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, categories.size());
		Assert.assertEquals(
			newCategory, categories.get(newCategory.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Category newCategory = addCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", newCategory.getCategoryId()));

		List<Category> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Category existingCategory = result.get(0);

		Assert.assertEquals(existingCategory, newCategory);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", RandomTestUtil.randomString()));

		List<Category> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Category newCategory = addCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("categoryId"));

		Object newCategoryId = newCategory.getCategoryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"categoryId", new Object[] {newCategoryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCategoryId = result.get(0);

		Assert.assertEquals(existingCategoryId, newCategoryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("categoryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"categoryId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Category newCategory = addCategory();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCategory.getPrimaryKey()));
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

		Category newCategory = addCategory();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", newCategory.getCategoryId()));

		List<Category> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Category category) {
		Assert.assertEquals(
			category.getName(),
			ReflectionTestUtil.invoke(
				category, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected Category addCategory() throws Exception {
		String pk = RandomTestUtil.randomString();

		Category category = _persistence.create(pk);

		category.setName(RandomTestUtil.randomString());

		category.setCreateDate(RandomTestUtil.nextDate());

		category.setModifiedDate(RandomTestUtil.nextDate());

		_categories.add(_persistence.update(category));

		return category;
	}

	private List<Category> _categories = new ArrayList<Category>();
	private CategoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}