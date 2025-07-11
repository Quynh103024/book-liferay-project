/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubtitleService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubtitleService
 * @generated
 */
public class SubtitleServiceWrapper
	implements ServiceWrapper<SubtitleService>, SubtitleService {

	public SubtitleServiceWrapper() {
		this(null);
	}

	public SubtitleServiceWrapper(SubtitleService subtitleService) {
		_subtitleService = subtitleService;
	}

	@Override
	public com.hehehe.servicebuilder.model.Subtitle addSubtitle(String name) {
		return _subtitleService.addSubtitle(name);
	}

	@Override
	public com.hehehe.servicebuilder.model.Subtitle deleteSubtitle(
			String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleService.deleteSubtitle(subtitleId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Subtitle>
		getAllSubtitle() {

		return _subtitleService.getAllSubtitle();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Book> obc,
		String subtitleId) {

		return _subtitleService.getBooks(start, end, obc, subtitleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subtitleService.getOSGiServiceIdentifier();
	}

	@Override
	public com.hehehe.servicebuilder.model.Subtitle getSubtitleById(
			String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtitleService.getSubtitleById(subtitleId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Subtitle>
		getSubtitles(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Subtitle> obc) {

		return _subtitleService.getSubtitles(start, end, obc);
	}

	@Override
	public int getSubtitlesCount() {
		return _subtitleService.getSubtitlesCount();
	}

	@Override
	public com.hehehe.servicebuilder.model.Subtitle updateSubtitle(
		com.hehehe.servicebuilder.model.Subtitle subtitle) {

		return _subtitleService.updateSubtitle(subtitle);
	}

	@Override
	public SubtitleService getWrappedService() {
		return _subtitleService;
	}

	@Override
	public void setWrappedService(SubtitleService subtitleService) {
		_subtitleService = subtitleService;
	}

	private SubtitleService _subtitleService;

}