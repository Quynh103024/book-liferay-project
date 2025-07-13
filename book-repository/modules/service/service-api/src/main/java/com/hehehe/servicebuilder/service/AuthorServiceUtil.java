/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Author;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Author. This utility wraps
 * <code>com.hehehe.servicebuilder.service.impl.AuthorServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorService
 * @generated
 */
public class AuthorServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.AuthorServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Author addAuthor(String name) {
		return getService().addAuthor(name);
	}

	public static Author deleteAuthor(String authorId) throws PortalException {
		return getService().deleteAuthor(authorId);
	}

	public static Author getAuthorById(String authorId) throws PortalException {
		return getService().getAuthorById(authorId);
	}

	public static int getAuthorCount() {
		return getService().getAuthorCount();
	}

	public static List<Author> getAuthors() {
		return getService().getAuthors();
	}

	public static List<Author> getAuthors(int start, int end) {
		return getService().getAuthors(start, end);
	}

	public static List<Author> getAuthors(
		int start, int end, OrderByComparator<Author> obc) {

		return getService().getAuthors(start, end, obc);
	}

	public static List<Author> getAuthorsByBookId(String bookId)
		throws PortalException {

		return getService().getAuthorsByBookId(bookId);
	}

	public static List<Author> getAuthorsColaborate(String authorId)
		throws PortalException {

		return getService().getAuthorsColaborate(authorId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean isExist(String name) {
		return getService().isExist(name);
	}

	public static Author updateAuthor(Author author) {
		return getService().updateAuthor(author);
	}

	public static AuthorService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AuthorService> _serviceSnapshot =
		new Snapshot<>(AuthorServiceUtil.class, AuthorService.class);

}