/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SubtitleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubtitleLocalService
 * @generated
 */
public class SubtitleLocalServiceWrapper
	implements ServiceWrapper<SubtitleLocalService>, SubtitleLocalService {

	public SubtitleLocalServiceWrapper() {
		this(null);
	}

	public SubtitleLocalServiceWrapper(
		SubtitleLocalService subtitleLocalService) {

		_subtitleLocalService = subtitleLocalService;
	}

	@Override
	public com.hehehe.servicebuilder.model.Subtitle addSubtitle(String name) {
		return _subtitleLocalService.addSubtitle(name);
	}

	/**
	 * Adds the subtitle to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtitle the subtitle
	 * @return the subtitle that was added
	 */
	@Override
	public com.hehehe.servicebuilder.model.Subtitle addSubtitle(
		com.hehehe.servicebuilder.model.Subtitle subtitle) {

		return _subtitleLocalService.addSubtitle(subtitle);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new subtitle with the primary key. Does not add the subtitle to the database.
	 *
	 * @param subtitleId the primary key for the new subtitle
	 * @return the new subtitle
	 */
	@Override
	public com.hehehe.servicebuilder.model.Subtitle createSubtitle(
		String subtitleId) {

		return _subtitleLocalService.createSubtitle(subtitleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the subtitle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle that was removed
	 * @throws PortalException if a subtitle with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.Subtitle deleteSubtitle(
			String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleLocalService.deleteSubtitle(subtitleId);
	}

	/**
	 * Deletes the subtitle from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtitle the subtitle
	 * @return the subtitle that was removed
	 */
	@Override
	public com.hehehe.servicebuilder.model.Subtitle deleteSubtitle(
		com.hehehe.servicebuilder.model.Subtitle subtitle) {

		return _subtitleLocalService.deleteSubtitle(subtitle);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _subtitleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _subtitleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subtitleLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subtitleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _subtitleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _subtitleLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subtitleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _subtitleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.hehehe.servicebuilder.model.Subtitle fetchSubtitle(
		String subtitleId) {

		return _subtitleLocalService.fetchSubtitle(subtitleId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Book> obc,
		String subtitleId) {

		return _subtitleLocalService.getBooks(start, end, obc, subtitleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subtitleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subtitle with the primary key.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle
	 * @throws PortalException if a subtitle with the primary key could not be found
	 */
	@Override
	public com.hehehe.servicebuilder.model.Subtitle getSubtitle(
			String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleLocalService.getSubtitle(subtitleId);
	}

	/**
	 * Returns a range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hehehe.servicebuilder.model.impl.SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @return the range of subtitles
	 */
	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Subtitle>
		getSubtitles(int start, int end) {

		return _subtitleLocalService.getSubtitles(start, end);
	}

	/**
	 * Returns the number of subtitles.
	 *
	 * @return the number of subtitles
	 */
	@Override
	public int getSubtitlesCount() {
		return _subtitleLocalService.getSubtitlesCount();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Subtitle>
		getSubtitlesSorted(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Subtitle> obc) {

		return _subtitleLocalService.getSubtitlesSorted(start, end, obc);
	}

	/**
	 * Updates the subtitle in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtitle the subtitle
	 * @return the subtitle that was updated
	 */
	@Override
	public com.hehehe.servicebuilder.model.Subtitle updateSubtitle(
		com.hehehe.servicebuilder.model.Subtitle subtitle) {

		return _subtitleLocalService.updateSubtitle(subtitle);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _subtitleLocalService.getBasePersistence();
	}

	@Override
	public SubtitleLocalService getWrappedService() {
		return _subtitleLocalService;
	}

	@Override
	public void setWrappedService(SubtitleLocalService subtitleLocalService) {
		_subtitleLocalService = subtitleLocalService;
	}

	private SubtitleLocalService _subtitleLocalService;

}