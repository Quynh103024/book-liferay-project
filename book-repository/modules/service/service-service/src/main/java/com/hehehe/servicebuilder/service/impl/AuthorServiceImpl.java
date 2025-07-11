/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.base.AuthorServiceBaseImpl;
import com.hehehe.util.comparator.AuthorNameComparator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=bookservicebuilder",
		"json.web.service.context.path=Author" }, service = AopService.class)
public class AuthorServiceImpl extends AuthorServiceBaseImpl {
	public Author addAuthor(String name) {
		return authorLocalService.addAuthor(name);
	}

	public Author getAuthorById(String authorId) throws PortalException {
		return authorLocalService.getAuthor(authorId);
	}

	public Author updateAuthor(Author author) {
		return authorLocalService.updateAuthor(author);
	}

	public Author deleteAuthor(String authorId) throws PortalException {
		return authorLocalService.deleteAuthor(authorId);
	}

	public List<Author> getAuthors(int start, int end, OrderByComparator<Author> obc) {
		return authorLocalService.getAuthorsSorted(start, end, obc);
	}
	
	public List<Author> getAllAuthor(){
		return authorLocalService.getAuthorsSorted(0, getAuthorCount(), new AuthorNameComparator());
	}

	public List<Book> getBooks(String authorId) throws PortalException {
		return authorLocalService.getBooks(authorId);
	}

	public int getAuthorCount() {
		return authorLocalService.getAuthorsCount();
	}
}