/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BookAuthor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthor
 * @generated
 */
public class BookAuthorWrapper
	extends BaseModelWrapper<BookAuthor>
	implements BookAuthor, ModelWrapper<BookAuthor> {

	public BookAuthorWrapper(BookAuthor bookAuthor) {
		super(bookAuthor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("authorId", getAuthorId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String bookId = (String)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String authorId = (String)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public BookAuthor cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the author ID of this book author.
	 *
	 * @return the author ID of this book author
	 */
	@Override
	public String getAuthorId() {
		return model.getAuthorId();
	}

	/**
	 * Returns the book ID of this book author.
	 *
	 * @return the book ID of this book author
	 */
	@Override
	public String getBookId() {
		return model.getBookId();
	}

	/**
	 * Returns the create date of this book author.
	 *
	 * @return the create date of this book author
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this book author.
	 *
	 * @return the modified date of this book author
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this book author.
	 *
	 * @return the primary key of this book author
	 */
	@Override
	public com.hehehe.servicebuilder.service.persistence.BookAuthorPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the author ID of this book author.
	 *
	 * @param authorId the author ID of this book author
	 */
	@Override
	public void setAuthorId(String authorId) {
		model.setAuthorId(authorId);
	}

	/**
	 * Sets the book ID of this book author.
	 *
	 * @param bookId the book ID of this book author
	 */
	@Override
	public void setBookId(String bookId) {
		model.setBookId(bookId);
	}

	/**
	 * Sets the create date of this book author.
	 *
	 * @param createDate the create date of this book author
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this book author.
	 *
	 * @param modifiedDate the modified date of this book author
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this book author.
	 *
	 * @param primaryKey the primary key of this book author
	 */
	@Override
	public void setPrimaryKey(
		com.hehehe.servicebuilder.service.persistence.BookAuthorPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BookAuthorWrapper wrap(BookAuthor bookAuthor) {
		return new BookAuthorWrapper(bookAuthor);
	}

}