/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Book;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service utility for Book. This utility wraps
 * <code>com.hehehe.servicebuilder.service.impl.BookServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @generated
 */
public class BookServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.BookServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addAuthers(List<String> autherIds, String bookId) {
		getService().addAuthers(autherIds, bookId);
	}

	public static Book addBook(
		List<String> authorIds, String title, String description,
		String thumbnail, String subtitleId, String categoryId, Integer price,
		Integer stock, Integer pages, Integer publicYear) {

		return getService().addBook(
			authorIds, title, description, thumbnail, subtitleId, categoryId,
			price, stock, pages, publicYear);
	}

	public static void changeAuthors(List<String> authorIds, String bookId) {
		getService().changeAuthors(authorIds, bookId);
	}

	public static Book deleteBook(String bookId) throws PortalException {
		return getService().deleteBook(bookId);
	}

	public static void deleteBooksByCategoryId(String categoryId)
		throws PortalException {

		getService().deleteBooksByCategoryId(categoryId);
	}

	public static void deleteBooksBySubtitleId(String subtitleId)
		throws PortalException {

		getService().deleteBooksBySubtitleId(subtitleId);
	}

	public static Book getBookById(String bookId) throws PortalException {
		return getService().getBookById(bookId);
	}

	public static List<Book> getBooks() {
		return getService().getBooks();
	}

	public static List<Book> getBooks(int start, int end) {
		return getService().getBooks(start, end);
	}

	public static List<Book> getBooks(
		int start, int end, OrderByComparator<Book> obc) {

		return getService().getBooks(start, end, obc);
	}

	public static List<Book> getBooksByAuthorId(String authorId)
		throws PortalException {

		return getService().getBooksByAuthorId(authorId);
	}

	public static List<Book> getBooksByCategoryId(String categoryId) {
		return getService().getBooksByCategoryId(categoryId);
	}

	public static List<Book> getBooksByCategoryId(
		String categoryId, int start, int end) {

		return getService().getBooksByCategoryId(categoryId, start, end);
	}

	public static List<Book> getBooksByCategoryId(
		String categoryId, int start, int end, OrderByComparator<Book> obc) {

		return getService().getBooksByCategoryId(categoryId, start, end, obc);
	}

	public static List<Book> getBooksBySubtitleId(String subtitleId) {
		return getService().getBooksBySubtitleId(subtitleId);
	}

	public static List<Book> getBooksBySubtitleId(
		String subtitleId, int start, int end) {

		return getService().getBooksBySubtitleId(subtitleId, start, end);
	}

	public static List<Book> getBooksBySubtitleId(
		String subtitleId, int start, int end, OrderByComparator<Book> obc) {

		return getService().getBooksBySubtitleId(subtitleId, start, end, obc);
	}

	public static int getBooksCount() {
		return getService().getBooksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Book updateBook(Book book) {
		return getService().updateBook(book);
	}

	public static BookService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BookService> _serviceSnapshot =
		new Snapshot<>(BookServiceUtil.class, BookService.class);

}