/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.model.impl.BookAuthorImpl;
import com.hehehe.servicebuilder.model.impl.BookImpl;
import com.hehehe.servicebuilder.service.BookAuthorLocalService;
import com.hehehe.servicebuilder.service.base.BookLocalServiceBaseImpl;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPK;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPersistence;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hehehe.servicebuilder.model.Book",
	service = AopService.class
)
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
	public Book addBook(String title,String description, String thumbnail, String subtitleId, String categoryId, Integer price, Integer stock, Integer pages, Integer publicYear) {
		Book book = new BookImpl();
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		book.setBookId(id);
		book.setTitle(title);
		book.setDescription(description);
		book.setThumbnail(thumbnail);
		book.setSubtitleId(subtitleId);
		book.setCategoryId(categoryId);
		book.setNum_pages(pages);
		book.setPrice(price);
		book.setStock(stock);
		book.setPublished_year(publicYear);
		book.setCreateDate(now);
		book.setModifiedDate(now);
		return bookLocalService.addBook(book);
	}
	public List<Book> getBooksSorted(int start, int end, OrderByComparator<Book> obc){
		return bookPersistence.findAll(start, end, obc);
	}
	public List<Author> getAuthors(String bookId) throws PortalException {
		List<BookAuthor> bas = bookAuthorPersistence.findByBookId(bookId);
		List<Author> authors = new ArrayList<>();
		for(BookAuthor ba : bas) {
			Author author = authorPersistence.findByPrimaryKey(ba.getAuthorId());
			authors.add(author);
		}
		return authors;
	}
	public void deleteBooksByCategoryId(String categoryId) throws PortalException {
	    List<Book> books = bookPersistence.findByCategoryId(categoryId);
	    for (Book book : books) {
	        deleteBook(book.getBookId());
	    }
	}
	public void deleteBooksBySubtitleId(String subtitleId) throws PortalException {
	    List<Book> books = bookPersistence.findBySubtitleId(subtitleId);
	    for (Book book : books) {
	        deleteBook(book.getBookId());
	    }
	}
	@Override
	public Book deleteBook(String bookId) throws PortalException {
		bookAuthorPersistence.removeByBookId(bookId);
		return bookPersistence.remove(bookId);
	}
	@Override
	public Book updateBook(Book book) {
		Date now = new Date();
		book.setModifiedDate(now);
		List<BookAuthor> bas = bookAuthorPersistence.findByBookId(book.getBookId());
		for(BookAuthor ba : bas) {
			ba.setModifiedDate(now);
			bookAuthorPersistence.update(ba);
		}
		return bookPersistence.update(book);
	}

	public void addAuthers(List<String> autherIds, String bookId) {
		BookAuthorLocalService bas = new BookAuthorLocalServiceImpl();
		Date now = new Date();
		for(String id : autherIds) {
			BookAuthor ba = new BookAuthorImpl();
			ba.setAuthorId(id);
			ba.setBookId(bookId);
			ba.setCreateDate(now);
			ba.setModifiedDate(now);
			bas.addBookAuthor(ba);
		}
	}
}