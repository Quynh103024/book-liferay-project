/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @generated
 */
public class BookServiceWrapper
	implements BookService, ServiceWrapper<BookService> {

	public BookServiceWrapper() {
		this(null);
	}

	public BookServiceWrapper(BookService bookService) {
		_bookService = bookService;
	}

	@Override
	public void addAuthers(java.util.List<String> autherIds, String bookId) {
		_bookService.addAuthers(autherIds, bookId);
	}

	@Override
	public com.hehehe.servicebuilder.model.Book addBook(
		String title, String description, String thumbnail, String subtitleId,
		String categoryId, Integer price, Integer stock, Integer pages,
		Integer publicYear) {

		return _bookService.addBook(
			title, description, thumbnail, subtitleId, categoryId, price, stock,
			pages, publicYear);
	}

	@Override
	public com.hehehe.servicebuilder.model.Book deleteBook(String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.deleteBook(bookId);
	}

	@Override
	public void deleteBooksByCategoryId(String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_bookService.deleteBooksByCategoryId(categoryId);
	}

	@Override
	public void deleteBooksBySubtitleId(String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_bookService.deleteBooksBySubtitleId(subtitleId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getAllBook() {
		return _bookService.getAllBook();
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Author> getAuthors(
			String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.getAuthors(bookId);
	}

	@Override
	public com.hehehe.servicebuilder.model.Book getBook(String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.getBook(bookId);
	}

	@Override
	public java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Book> obc) {

		return _bookService.getBooks(start, end, obc);
	}

	@Override
	public int getBooksCount() {
		return _bookService.getBooksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookService.getOSGiServiceIdentifier();
	}

	@Override
	public com.hehehe.servicebuilder.model.Book updateBook(
		com.hehehe.servicebuilder.model.Book book) {

		return _bookService.updateBook(book);
	}

	@Override
	public BookService getWrappedService() {
		return _bookService;
	}

	@Override
	public void setWrappedService(BookService bookService) {
		_bookService = bookService;
	}

	private BookService _bookService;

}