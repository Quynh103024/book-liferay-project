/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.hehehe.servicebuilder.exception.NoSuchSubtitleException;
import com.hehehe.servicebuilder.model.Subtitle;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the subtitle service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubtitleUtil
 * @generated
 */
@ProviderType
public interface SubtitlePersistence extends BasePersistence<Subtitle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubtitleUtil} to access the subtitle persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the subtitle where name = &#63; or throws a <code>NoSuchSubtitleException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching subtitle
	 * @throws NoSuchSubtitleException if a matching subtitle could not be found
	 */
	public Subtitle findByName(String name) throws NoSuchSubtitleException;

	/**
	 * Returns the subtitle where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching subtitle, or <code>null</code> if a matching subtitle could not be found
	 */
	public Subtitle fetchByName(String name);

	/**
	 * Returns the subtitle where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subtitle, or <code>null</code> if a matching subtitle could not be found
	 */
	public Subtitle fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the subtitle where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the subtitle that was removed
	 */
	public Subtitle removeByName(String name) throws NoSuchSubtitleException;

	/**
	 * Returns the number of subtitles where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching subtitles
	 */
	public int countByName(String name);

	/**
	 * Caches the subtitle in the entity cache if it is enabled.
	 *
	 * @param subtitle the subtitle
	 */
	public void cacheResult(Subtitle subtitle);

	/**
	 * Caches the subtitles in the entity cache if it is enabled.
	 *
	 * @param subtitles the subtitles
	 */
	public void cacheResult(java.util.List<Subtitle> subtitles);

	/**
	 * Creates a new subtitle with the primary key. Does not add the subtitle to the database.
	 *
	 * @param subtitleId the primary key for the new subtitle
	 * @return the new subtitle
	 */
	public Subtitle create(String subtitleId);

	/**
	 * Removes the subtitle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle that was removed
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	public Subtitle remove(String subtitleId) throws NoSuchSubtitleException;

	public Subtitle updateImpl(Subtitle subtitle);

	/**
	 * Returns the subtitle with the primary key or throws a <code>NoSuchSubtitleException</code> if it could not be found.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	public Subtitle findByPrimaryKey(String subtitleId)
		throws NoSuchSubtitleException;

	/**
	 * Returns the subtitle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle, or <code>null</code> if a subtitle with the primary key could not be found
	 */
	public Subtitle fetchByPrimaryKey(String subtitleId);

	/**
	 * Returns all the subtitles.
	 *
	 * @return the subtitles
	 */
	public java.util.List<Subtitle> findAll();

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
	public java.util.List<Subtitle> findAll(int start, int end);

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
	public java.util.List<Subtitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtitle>
			orderByComparator);

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
	public java.util.List<Subtitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtitle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the subtitles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of subtitles.
	 *
	 * @return the number of subtitles
	 */
	public int countAll();

}