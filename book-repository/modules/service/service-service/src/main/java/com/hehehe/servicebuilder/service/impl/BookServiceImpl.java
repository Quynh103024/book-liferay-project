/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.base.BookServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=bookservicebuilder",
		"json.web.service.context.path=Book" }, service = AopService.class)
public class BookServiceImpl extends BookServiceBaseImpl {
	
//	CREATE
	
	public Book addBook(List<String> authorIds,String title,String description, String thumbnail, String subtitleId, String categoryId, Integer price, Integer stock, Integer pages, Integer publicYear) {
		return bookLocalService.addBook(authorIds, title, description, thumbnail, subtitleId, categoryId, price, stock, pages, publicYear);
	}
	
//	READ
	
	public Book getBookById(String bookId) throws PortalException {
		return bookLocalService.getBook(bookId);
	}
	
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc){
		return bookLocalService.getBooks(start, end, obc);
	}
	
	public List<Book> getBooks(int start, int end){
		return bookLocalService.getBooks(start, end);
	}
	
	public List<Book> getBooks(){
		return bookLocalService.getBooks(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<Book> getBooksByAuthorId(String authorId) throws PortalException {
		return bookLocalService.getBooksByAuthorId(authorId);
	}
	
	public List<Book> getBooksByCategoryId(String categoryId){
		return bookLocalService.getBooksByCategoryId(categoryId);
	}
	
	public List<Book> getBooksByCategoryId(String categoryId, int start, int end){
		return bookLocalService.getBooksByCategoryId(categoryId, start, end);
	}
	
	public List<Book> getBooksByCategoryId(String categoryId, int start, int end, OrderByComparator<Book> obc){
		return bookLocalService.getBooksByCategoryId(categoryId, start, end, obc);
	}
	
	public List<Book> getBooksBySubtitleId(String subtitleId){
		return bookLocalService.getBooksBySubtitleId(subtitleId);
	}
	
	public List<Book> getBooksBySubtitleId(String subtitleId, int start, int end){
		return bookLocalService.getBooksBySubtitleId(subtitleId, start, end);
	}
	
	public List<Book> getBooksBySubtitleId(String subtitleId, int start, int end, OrderByComparator<Book> obc){
		return bookLocalService.getBooksBySubtitleId(subtitleId, start, end, obc);
	}
	
//	UPDATE
	
	public Book updateBook(Book book) {
		return bookLocalService.updateBook(book);
	}
	
//	DELETE
	
	public Book deleteBook(String bookId) throws PortalException {
		return bookLocalService.deleteBook(bookId);
	}
	
	public void deleteBooksByCategoryId(String categoryId) throws PortalException {
	    bookLocalService.deleteBooksByCategoryId(categoryId);
	}
	
	public void deleteBooksBySubtitleId(String subtitleId) throws PortalException {
	    bookLocalService.deleteBooksBySubtitleId(subtitleId);
	}
	
//	LOGIC METHOD
	
	public int getBooksCount() {
		return bookLocalService.getBooksCount();
	}	
	
	public void addAuthers(List<String> autherIds, String bookId) {
		bookLocalService.addAuthers(autherIds, bookId);
	}
	
	public void changeAuthors(List<String> authorIds,String bookId) {
		bookLocalService.changeAuthors(authorIds, bookId);
	}
}