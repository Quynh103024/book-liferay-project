/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.service.base.BookServiceBaseImpl;
import com.hehehe.util.comparator.BookTitleComparator;
import com.liferay.portal.aop.AopService;
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
	public Book addBook(String title,String description, String thumbnail, String subtitleId, String categoryId, Integer price, Integer stock, Integer pages, Integer publicYear) {
		return bookLocalService.addBook(title, description, thumbnail, subtitleId, categoryId, price, stock, pages, publicYear);
	}
	public Book getBook(String bookId) throws PortalException {
		return bookLocalService.getBook(bookId);
	}
	public Book updateBook(Book book) {
		return bookLocalService.updateBook(book);
	}
	public Book deleteBook(String bookId) throws PortalException {
		return bookLocalService.deleteBook(bookId);
	}
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc){
		return bookLocalService.getBooksSorted(start, end, obc);
	}
	public List<Author> getAuthors(String bookId) throws PortalException {
		return bookLocalService.getAuthors(bookId);
	}
	public List<Book> getAllBook(){
		return bookLocalService.getBooksSorted(0, getBooksCount(), new BookTitleComparator());
	}
	public void deleteBooksByCategoryId(String categoryId) throws PortalException {
	    bookLocalService.deleteBooksByCategoryId(categoryId);
	}
	public void deleteBooksBySubtitleId(String subtitleId) throws PortalException {
	    bookLocalService.deleteBooksBySubtitleId(subtitleId);
	}
	public int getBooksCount() {
		return bookLocalService.getBooksCount();
	}	
	public void addAuthers(List<String> autherIds, String bookId) {
		bookLocalService.addAuthers(autherIds, bookId);
	}
}