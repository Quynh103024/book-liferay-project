/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service;

import com.hehehe.servicebuilder.model.Book;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Book. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BookServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BookService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.hehehe.servicebuilder.service.impl.BookServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the book remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BookServiceUtil} if injection and service tracking are not available.
	 */
	public void addAuthers(List<String> autherIds, String bookId);

	public Book addBook(
		List<String> authorIds, String title, String description,
		String thumbnail, String subtitleId, String categoryId, Integer price,
		Integer stock, Integer pages, Integer publicYear);

	public void changeAuthors(List<String> authorIds, String bookId);

	public Book deleteBook(String bookId) throws PortalException;

	public void deleteBooksByCategoryId(String categoryId)
		throws PortalException;

	public void deleteBooksBySubtitleId(String subtitleId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Book getBookById(String bookId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooks();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooks(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksByAuthorId(String authorId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksByCategoryId(String categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksByCategoryId(
		String categoryId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksByCategoryId(
		String categoryId, int start, int end, OrderByComparator<Book> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksBySubtitleId(String subtitleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksBySubtitleId(
		String subtitleId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksBySubtitleId(
		String subtitleId, int start, int end, OrderByComparator<Book> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBooksCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Book updateBook(Book book);

}