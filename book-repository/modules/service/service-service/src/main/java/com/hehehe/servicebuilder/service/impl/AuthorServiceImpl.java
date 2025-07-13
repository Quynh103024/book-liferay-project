/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.service.base.AuthorServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=bookservicebuilder",
		"json.web.service.context.path=Author" }, service = AopService.class)
public class AuthorServiceImpl extends AuthorServiceBaseImpl {
//	CREATE
	
	public Author addAuthor(String name) {
		return authorLocalService.addAuthor(name);
	}
	
//	READ
	
	public Author getAuthorById(String authorId) throws PortalException {
		return authorLocalService.getAuthor(authorId);
	}

	public List<Author> getAuthors(int start, int end, OrderByComparator<Author> obc) {
		return authorLocalService.getAuthors(start, end, obc);
	}
	
	public List<Author> getAuthors(int start, int end) {
		return authorLocalService.getAuthors(start, end);
	}
	
	public List<Author> getAuthors(){
		return authorLocalService.getAuthors(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<Author> getAuthorsByBookId(String bookId) throws PortalException {
		return authorLocalService.getAuthorsByBookId(bookId);
	}
	
	public List<Author> getAuthorsCollaborate(String authorId) throws PortalException{
		return authorLocalService.getAuthorsCollaborate(authorId);
	}
	
//	UPDATE
	
	public Author updateAuthor(Author author) {
		return authorLocalService.updateAuthor(author);
	}
	
//	DELETE
	
	public Author deleteAuthor(String authorId) throws PortalException {
		return authorLocalService.deleteAuthor(authorId);
	}
	
//	LOGIC METHOD
	
	public boolean isExist(String name) {
		return authorLocalService.isExist(name);
	}

	public int getAuthorCount() {
		return authorLocalService.getAuthorsCount();
	}
	
	public List<String> getAuthorIdsByNames(List<String> names) {
		return authorLocalService.getAuthorIdsByNames(names);
	}
}