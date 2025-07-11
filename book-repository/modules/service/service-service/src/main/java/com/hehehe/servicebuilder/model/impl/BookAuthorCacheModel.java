/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model.impl;

import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BookAuthor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookAuthorCacheModel
	implements CacheModel<BookAuthor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookAuthorCacheModel)) {
			return false;
		}

		BookAuthorCacheModel bookAuthorCacheModel =
			(BookAuthorCacheModel)object;

		if (bookAuthorPK.equals(bookAuthorCacheModel.bookAuthorPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookAuthorPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookAuthor toEntityModel() {
		BookAuthorImpl bookAuthorImpl = new BookAuthorImpl();

		if (bookId == null) {
			bookAuthorImpl.setBookId("");
		}
		else {
			bookAuthorImpl.setBookId(bookId);
		}

		if (authorId == null) {
			bookAuthorImpl.setAuthorId("");
		}
		else {
			bookAuthorImpl.setAuthorId(authorId);
		}

		if (createDate == Long.MIN_VALUE) {
			bookAuthorImpl.setCreateDate(null);
		}
		else {
			bookAuthorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookAuthorImpl.setModifiedDate(null);
		}
		else {
			bookAuthorImpl.setModifiedDate(new Date(modifiedDate));
		}

		bookAuthorImpl.resetOriginalValues();

		return bookAuthorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readUTF();
		authorId = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		bookAuthorPK = new BookAuthorPK(bookId, authorId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (bookId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookId);
		}

		if (authorId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorId);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String bookId;
	public String authorId;
	public long createDate;
	public long modifiedDate;
	public transient BookAuthorPK bookAuthorPK;

}