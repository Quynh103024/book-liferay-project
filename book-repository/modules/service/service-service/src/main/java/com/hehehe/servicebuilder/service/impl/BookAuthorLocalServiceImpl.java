/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.service.base.BookAuthorLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hehehe.servicebuilder.model.BookAuthor",
	service = AopService.class
)
public class BookAuthorLocalServiceImpl extends BookAuthorLocalServiceBaseImpl {
	public List<BookAuthor> getBookAuthorByAuthorId(String authorId){
		return bookAuthorPersistence.findByAuthorId(authorId);
	}
	public List<BookAuthor> getBookAuthorByBookId(String bookId){
		return bookAuthorPersistence.findByBookId(bookId);
	}
	public void deleteBookAuthorByAuthorId(String authorId) {
		bookAuthorPersistence.removeByAuthorId(authorId);
	}
	public void deleteBookAuthorByBookId(String bookId) {
		bookAuthorPersistence.removeByBookId(bookId);
	}
}