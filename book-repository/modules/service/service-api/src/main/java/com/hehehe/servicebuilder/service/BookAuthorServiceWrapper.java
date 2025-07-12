/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookAuthorService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthorService
 * @generated
 */
public class BookAuthorServiceWrapper
	implements BookAuthorService, ServiceWrapper<BookAuthorService> {

	public BookAuthorServiceWrapper() {
		this(null);
	}

	public BookAuthorServiceWrapper(BookAuthorService bookAuthorService) {
		_bookAuthorService = bookAuthorService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookAuthorService.getOSGiServiceIdentifier();
	}

	@Override
	public BookAuthorService getWrappedService() {
		return _bookAuthorService;
	}

	@Override
	public void setWrappedService(BookAuthorService bookAuthorService) {
		_bookAuthorService = bookAuthorService;
	}

	private BookAuthorService _bookAuthorService;

}