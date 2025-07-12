/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Subtitle;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Subtitle. This utility wraps
 * <code>com.hehehe.servicebuilder.service.impl.SubtitleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SubtitleService
 * @generated
 */
public class SubtitleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.SubtitleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Subtitle addSubtitle(String name) {
		return getService().addSubtitle(name);
	}

	public static Subtitle deleteSubtitle(String subtitleId)
		throws PortalException {

		return getService().deleteSubtitle(subtitleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Subtitle getSubtitleByBookId(String bookId)
		throws PortalException {

		return getService().getSubtitleByBookId(bookId);
	}

	public static Subtitle getSubtitleById(String subtitleId)
		throws PortalException {

		return getService().getSubtitleById(subtitleId);
	}

	public static List<Subtitle> getSubtitles() {
		return getService().getSubtitles();
	}

	public static List<Subtitle> getSubtitles(
		int start, int end, OrderByComparator<Subtitle> obc) {

		return getService().getSubtitles(start, end, obc);
	}

	public static int getSubtitlesCount() {
		return getService().getSubtitlesCount();
	}

	public static boolean isExist(String name) {
		return getService().isExist(name);
	}

	public static Subtitle updateSubtitle(Subtitle subtitle) {
		return getService().updateSubtitle(subtitle);
	}

	public static SubtitleService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SubtitleService> _serviceSnapshot =
		new Snapshot<>(SubtitleServiceUtil.class, SubtitleService.class);

}