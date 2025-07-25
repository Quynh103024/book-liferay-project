/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Subtitle;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Subtitle. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SubtitleServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SubtitleService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.SubtitleServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the subtitle remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SubtitleServiceUtil} if injection and service tracking are not available.
	 */
	public Subtitle addSubtitle(String name);

	public Subtitle deleteSubtitle(String subtitleId) throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Subtitle getSubtitleByBookId(String bookId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Subtitle getSubtitleById(String subtitleId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getSubtitleIdByName(String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Subtitle> getSubtitles();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Subtitle> getSubtitles(
		int start, int end, OrderByComparator<Subtitle> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSubtitlesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isExist(String name);

	public Subtitle updateSubtitle(Subtitle subtitle);

}