/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.test;

import com.hehehe.servicebuilder.exception.NoSuchSubtitleException;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.service.persistence.SubtitlePersistence;
import com.hehehe.servicebuilder.service.persistence.SubtitleUtil;

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
public class SubtitlePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.hehehe.servicebuilder.service"));

	@Before
	public void setUp() {
		_persistence = SubtitleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Subtitle> iterator = _subtitles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Subtitle subtitle = _persistence.create(pk);

		Assert.assertNotNull(subtitle);

		Assert.assertEquals(subtitle.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Subtitle newSubtitle = addSubtitle();

		_persistence.remove(newSubtitle);

		Subtitle existingSubtitle = _persistence.fetchByPrimaryKey(
			newSubtitle.getPrimaryKey());

		Assert.assertNull(existingSubtitle);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSubtitle();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Subtitle newSubtitle = _persistence.create(pk);

		newSubtitle.setName(RandomTestUtil.randomString());

		newSubtitle.setCreateDate(RandomTestUtil.nextDate());

		newSubtitle.setModifiedDate(RandomTestUtil.nextDate());

		_subtitles.add(_persistence.update(newSubtitle));

		Subtitle existingSubtitle = _persistence.findByPrimaryKey(
			newSubtitle.getPrimaryKey());

		Assert.assertEquals(
			existingSubtitle.getSubtitleId(), newSubtitle.getSubtitleId());
		Assert.assertEquals(existingSubtitle.getName(), newSubtitle.getName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubtitle.getCreateDate()),
			Time.getShortTimestamp(newSubtitle.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubtitle.getModifiedDate()),
			Time.getShortTimestamp(newSubtitle.getModifiedDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Subtitle newSubtitle = addSubtitle();

		Subtitle existingSubtitle = _persistence.findByPrimaryKey(
			newSubtitle.getPrimaryKey());

		Assert.assertEquals(existingSubtitle, newSubtitle);
	}

	@Test(expected = NoSuchSubtitleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Subtitle> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BookServiceBuilder_Subtitle", "subtitleId", true, "name", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Subtitle newSubtitle = addSubtitle();

		Subtitle existingSubtitle = _persistence.fetchByPrimaryKey(
			newSubtitle.getPrimaryKey());

		Assert.assertEquals(existingSubtitle, newSubtitle);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Subtitle missingSubtitle = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSubtitle);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Subtitle newSubtitle1 = addSubtitle();
		Subtitle newSubtitle2 = addSubtitle();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubtitle1.getPrimaryKey());
		primaryKeys.add(newSubtitle2.getPrimaryKey());

		Map<Serializable, Subtitle> subtitles = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, subtitles.size());
		Assert.assertEquals(
			newSubtitle1, subtitles.get(newSubtitle1.getPrimaryKey()));
		Assert.assertEquals(
			newSubtitle2, subtitles.get(newSubtitle2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Subtitle> subtitles = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subtitles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Subtitle newSubtitle = addSubtitle();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubtitle.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Subtitle> subtitles = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subtitles.size());
		Assert.assertEquals(
			newSubtitle, subtitles.get(newSubtitle.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Subtitle> subtitles = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subtitles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Subtitle newSubtitle = addSubtitle();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubtitle.getPrimaryKey());

		Map<Serializable, Subtitle> subtitles = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subtitles.size());
		Assert.assertEquals(
			newSubtitle, subtitles.get(newSubtitle.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Subtitle newSubtitle = addSubtitle();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtitle.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"subtitleId", newSubtitle.getSubtitleId()));

		List<Subtitle> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Subtitle existingSubtitle = result.get(0);

		Assert.assertEquals(existingSubtitle, newSubtitle);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtitle.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"subtitleId", RandomTestUtil.randomString()));

		List<Subtitle> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Subtitle newSubtitle = addSubtitle();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtitle.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("subtitleId"));

		Object newSubtitleId = newSubtitle.getSubtitleId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"subtitleId", new Object[] {newSubtitleId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSubtitleId = result.get(0);

		Assert.assertEquals(existingSubtitleId, newSubtitleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtitle.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("subtitleId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"subtitleId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Subtitle addSubtitle() throws Exception {
		String pk = RandomTestUtil.randomString();

		Subtitle subtitle = _persistence.create(pk);

		subtitle.setName(RandomTestUtil.randomString());

		subtitle.setCreateDate(RandomTestUtil.nextDate());

		subtitle.setModifiedDate(RandomTestUtil.nextDate());

		_subtitles.add(_persistence.update(subtitle));

		return subtitle;
	}

	private List<Subtitle> _subtitles = new ArrayList<Subtitle>();
	private SubtitlePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}