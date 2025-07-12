/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.model.impl.BookAuthorImpl;
import com.hehehe.servicebuilder.model.impl.BookImpl;
import com.hehehe.servicebuilder.service.AuthorLocalService;
import com.hehehe.servicebuilder.service.BookAuthorLocalService;
import com.hehehe.servicebuilder.service.base.BookLocalServiceBaseImpl;

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
//	REFERENCE
	
	@Reference
	BookAuthorLocalService bookAuthorLocalService;
	
//	CREATE
	
	public Book addBook(List<String> authorIds,String title,String description, String thumbnail, String subtitleId, String categoryId, Integer price, Integer stock, Integer pages, Integer publicYear) {
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		Book book = new BookImpl();
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
		addAuthers(authorIds, id, now);
		return super.addBook(book);
	}
	
//	READ
	
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc){
		return bookPersistence.findAll(start, end, obc);
	}
	
	public List<Book> getBooksByAuthorId(String authorId) throws PortalException {
		List<BookAuthor> bas = bookAuthorLocalService.getBookAuthorByAuthorId(authorId);
		List<Book> books = new ArrayList<>();
		for(BookAuthor ba : bas) {
			Book book = super.getBook(ba.getBookId());
			books.add(book);
		}
		return books;
	}
	
	public List<Book> getBooksByCategoryId(String categoryId){
		return bookPersistence.findByCategoryId(categoryId);
	}
	
	public List<Book> getBooksByCategoryId(String categoryId, int start, int end){
		return bookPersistence.findByCategoryId(categoryId, start, end);
	}
	
	public List<Book> getBooksByCategoryId(String categoryId, int start, int end, OrderByComparator<Book> obc){
		return bookPersistence.findByCategoryId(categoryId, start, end, obc);
	}
	
	public List<Book> getBooksBySubtitleId(String subtitleId){
		return bookPersistence.findBySubtitleId(subtitleId);
	}
	
	public List<Book> getBooksBySubtitleId(String subtitleId, int start, int end){
		return bookPersistence.findBySubtitleId(subtitleId, start, end);
	}
	
	public List<Book> getBooksBySubtitleId(String subtitleId, int start, int end, OrderByComparator<Book> obc){
		return bookPersistence.findBySubtitleId(subtitleId, start, end, obc);
	}
	
//	UPDATE
	
	@Override
	public Book updateBook(Book book) {
		Date now = new Date();
		book.setModifiedDate(now);
		List<BookAuthor> bas = bookAuthorLocalService.getBookAuthorByBookId(book.getBookId());
		for(BookAuthor ba : bas) {
			ba.setModifiedDate(now);
			bookAuthorLocalService.updateBookAuthor(ba);
		}
		return super.updateBook(book);
	}

//	DELETE
	
	public List<Book> deleteBooksByCategoryId(String categoryId) throws PortalException {
	    List<Book> books = bookPersistence.findByCategoryId(categoryId);
	    for (Book book : books) {
	        super.deleteBook(book.getBookId());
	    }
	    return books;
	}
	
	public List<Book> deleteBooksBySubtitleId(String subtitleId) throws PortalException {
	    List<Book> books = bookPersistence.findBySubtitleId(subtitleId);
	    for (Book book : books) {
	    	super.deleteBook(book.getBookId());
	    }
	    return books;
	}
	
	@Override
	public Book deleteBook(String bookId) throws PortalException {
		bookAuthorLocalService.deleteBookAuthorByBookId(bookId);
		return super.deleteBook(bookId);
	}
	
//	LOGIC METHOD
	
	public void addAuthers(List<String> autherIds, String bookId) {
		Date now = new Date();
		for(String id : autherIds) {
			BookAuthor ba = new BookAuthorImpl();
			ba.setAuthorId(id);
			ba.setBookId(bookId);
			ba.setCreateDate(now);
			ba.setModifiedDate(now);
			bookAuthorLocalService.addBookAuthor(ba);
		}
	}
	
	public void addAuthers(List<String> autherIds, String bookId, Date date) {
		for(String id : autherIds) {
			BookAuthor ba = new BookAuthorImpl();
			ba.setAuthorId(id);
			ba.setBookId(bookId);
			ba.setCreateDate(date);
			ba.setModifiedDate(date);
			bookAuthorLocalService.addBookAuthor(ba);
		}
	}
	
	public void changeAuthors(List<String> authorIds,String bookId) {
		bookAuthorLocalService.deleteBookAuthorByBookId(bookId);
		addAuthers(authorIds, bookId);
	}
}