/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.model.Subtitle;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the subtitle service. This utility wraps <code>com.hehehe.servicebuilder.service.persistence.impl.SubtitlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubtitlePersistence
 * @generated
 */
public class SubtitleUtil {

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
	public static void clearCache(Subtitle subtitle) {
		getPersistence().clearCache(subtitle);
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
	public static Map<Serializable, Subtitle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Subtitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subtitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subtitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Subtitle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Subtitle update(Subtitle subtitle) {
		return getPersistence().update(subtitle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Subtitle update(
		Subtitle subtitle, ServiceContext serviceContext) {

		return getPersistence().update(subtitle, serviceContext);
	}

	/**
	 * Caches the subtitle in the entity cache if it is enabled.
	 *
	 * @param subtitle the subtitle
	 */
	public static void cacheResult(Subtitle subtitle) {
		getPersistence().cacheResult(subtitle);
	}

	/**
	 * Caches the subtitles in the entity cache if it is enabled.
	 *
	 * @param subtitles the subtitles
	 */
	public static void cacheResult(List<Subtitle> subtitles) {
		getPersistence().cacheResult(subtitles);
	}

	/**
	 * Creates a new subtitle with the primary key. Does not add the subtitle to the database.
	 *
	 * @param subtitleId the primary key for the new subtitle
	 * @return the new subtitle
	 */
	public static Subtitle create(String subtitleId) {
		return getPersistence().create(subtitleId);
	}

	/**
	 * Removes the subtitle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle that was removed
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	public static Subtitle remove(String subtitleId)
		throws com.hehehe.servicebuilder.exception.NoSuchSubtitleException {

		return getPersistence().remove(subtitleId);
	}

	public static Subtitle updateImpl(Subtitle subtitle) {
		return getPersistence().updateImpl(subtitle);
	}

	/**
	 * Returns the subtitle with the primary key or throws a <code>NoSuchSubtitleException</code> if it could not be found.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	public static Subtitle findByPrimaryKey(String subtitleId)
		throws com.hehehe.servicebuilder.exception.NoSuchSubtitleException {

		return getPersistence().findByPrimaryKey(subtitleId);
	}

	/**
	 * Returns the subtitle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle, or <code>null</code> if a subtitle with the primary key could not be found
	 */
	public static Subtitle fetchByPrimaryKey(String subtitleId) {
		return getPersistence().fetchByPrimaryKey(subtitleId);
	}

	/**
	 * Returns all the subtitles.
	 *
	 * @return the subtitles
	 */
	public static List<Subtitle> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @return the range of subtitles
	 */
	public static List<Subtitle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subtitles
	 */
	public static List<Subtitle> findAll(
		int start, int end, OrderByComparator<Subtitle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subtitles
	 */
	public static List<Subtitle> findAll(
		int start, int end, OrderByComparator<Subtitle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the subtitles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of subtitles.
	 *
	 * @return the number of subtitles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubtitlePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SubtitlePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SubtitlePersistence _persistence;

}