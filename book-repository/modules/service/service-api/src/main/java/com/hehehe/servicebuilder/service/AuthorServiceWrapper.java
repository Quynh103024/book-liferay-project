/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuthorService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorService
 * @generated
 */
public class AuthorServiceWrapper
	implements AuthorService, ServiceWrapper<AuthorService> {

	public AuthorServiceWrapper() {
		this(null);
	}

	public AuthorServiceWrapper(AuthorService authorService) {
		_authorService = authorService;
	}

	@Override
	public com.hehehe.servicebuilder.model.Author addAuthor(String name) {
		return _authorService.addAuthor(name);
	}

	@Override
	public com.hehehe.servicebuilder.model.Author deleteAuthor(String authorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorService.deleteAuthor(authorId);
	}

	@Override
	public com.hehehe.servicebuilder.model.Author getAuthorById(String authorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorService.getAuthorById(authorId);
	}

	@Override
	public int getAuthorCount() {
		return _authorService.getAuthorCount();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Author> getAuthors() {
		return _authorService.getAuthors();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Author> getAuthors(
		int start, int end) {

		return _authorService.getAuthors(start, end);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Author> getAuthors(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Author> obc) {

		return _authorService.getAuthors(start, end, obc);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Author>
			getAuthorsByBookId(String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorService.getAuthorsByBookId(bookId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Author>
			getAuthorsColaborate(String authorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorService.getAuthorsColaborate(authorId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _authorService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean isExist(String name) {
		return _authorService.isExist(name);
	}

	@Override
	public com.hehehe.servicebuilder.model.Author updateAuthor(
		com.hehehe.servicebuilder.model.Author author) {

		return _authorService.updateAuthor(author);
	}

	@Override
	public AuthorService getWrappedService() {
		return _authorService;
	}

	@Override
	public void setWrappedService(AuthorService authorService) {
		_authorService = authorService;
	}

	private AuthorService _authorService;

}