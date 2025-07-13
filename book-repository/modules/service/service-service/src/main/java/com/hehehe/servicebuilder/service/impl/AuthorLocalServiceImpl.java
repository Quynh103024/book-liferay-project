/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.exception.NoSuchAuthorException;
import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.model.impl.AuthorImpl;
import com.hehehe.servicebuilder.service.BookAuthorLocalService;
import com.hehehe.servicebuilder.service.BookLocalService;
import com.hehehe.servicebuilder.service.base.AuthorLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.hehehe.servicebuilder.model.Author", service = AopService.class)
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
//	REFERENCE
	
	@Reference
	private BookLocalService bookLocalService;
	@Reference
	private BookAuthorLocalService bookAuthorLocalService;
	
//	CREATE
	
	public Author addAuthor(String name) {
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		Author author = new AuthorImpl();
		author.setAuthorId(id);
		author.setName(name);
		author.setCreateDate(now);
		author.setModifiedDate(now);
		return super.addAuthor(author);
	}
	
//	READ
	
	public List<Author> getAuthors(int start, int end, OrderByComparator<Author> obc){
		return authorPersistence.findAll(start,end,obc);
	}
	
	public List<Author> getAuthorsByBookId(String bookId) throws PortalException {
		List<BookAuthor> bas = bookAuthorLocalService.getBookAuthorByBookId(bookId);
		List<Author> authors = new ArrayList<>();
		for(BookAuthor ba : bas) {
			Author author = super.getAuthor(ba.getAuthorId());
			authors.add(author);
		}
		return authors;
	}
	
	public List<Author> getAuthorsCollaborate(String authorId) throws PortalException{
		List<Book> books = bookLocalService.getBooksByAuthorId(authorId);
		Set<Author> authors = new HashSet<>();
		for(Book book : books) {
			List<Author> list = authorLocalService.getAuthorsByBookId(book.getBookId());
			for(Author au : list) {
				if (!au.getAuthorId().equals(authorId)) {
					authors.add(au);
				}
			}
		}
		return new ArrayList<>(authors);
	}
	
//	UPDATE
	
	@Override
	public Author updateAuthor(Author author) {
		Date now = new Date();
		author.setModifiedDate(now);
		List<BookAuthor> bas = bookAuthorLocalService.getBookAuthorByAuthorId(author.getAuthorId());
		for(BookAuthor ba : bas) {
			ba.setModifiedDate(now);
			bookAuthorLocalService.updateBookAuthor(ba);
		}
		return super.updateAuthor(author);
	}
	
//	DELETE
	
	@Override
	public Author deleteAuthor(String authorId) throws PortalException {
		bookAuthorLocalService.deleteBookAuthorByAuthorId(authorId);
		return super.deleteAuthor(authorId);
	}
	
//	LOGIC METHOD

	public boolean isExist(String name) {
		return authorPersistence.fetchByName(name) != null;
	}
	
	public List<String> getAuthorIdsByNames(List<String> names) {
		List<String> authorIds = new ArrayList<>();
		for(String name : names) {
			Author author = authorPersistence.fetchByName(name);
			if(author != null) authorIds.add(author.getAuthorId());
		}
		return authorIds;
	}
}