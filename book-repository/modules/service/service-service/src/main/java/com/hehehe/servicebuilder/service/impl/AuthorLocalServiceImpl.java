/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.model.impl.AuthorImpl;
import com.hehehe.servicebuilder.service.base.AuthorLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.hehehe.servicebuilder.model.Author", service = AopService.class)
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	public Author addAuthor(String name) {
		Author author = new AuthorImpl();
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		author.setAuthorId(id);
		author.setName(name);
		author.setCreateDate(now);
		author.setModifiedDate(now);
		return authorLocalService.addAuthor(author);
	}
	public List<Author> getAuthorsSorted(int start, int end, OrderByComparator<Author> obc){
		return authorPersistence.findAll(start,end,obc);
	}
	public List<Book> getBooks(String authorId) throws PortalException {
		List<BookAuthor> bas = bookAuthorPersistence.findByAuthorId(authorId);
		List<Book> books = new ArrayList<>();
		for(BookAuthor ba : bas) {
			Book book = bookPersistence.findByPrimaryKey(ba.getBookId());
			books.add(book);
		}
		return books;
	}
	@Override
	public Author deleteAuthor(String authorId) throws PortalException {
		bookAuthorPersistence.removeByBookId(authorId);
		return authorPersistence.remove(authorId);
	}
	@Override
	public Author updateAuthor(Author author) {
		Date now = new Date();
		author.setModifiedDate(now);
		List<BookAuthor> bas = bookAuthorPersistence.findByAuthorId(author.getAuthorId());
		for(BookAuthor ba : bas) {
			ba.setModifiedDate(now);
			bookAuthorPersistence.update(ba);
		}
		return authorPersistence.update(author);
	}
}