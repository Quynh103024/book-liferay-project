/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookAuthorPK implements Comparable<BookAuthorPK>, Serializable {

	public String bookId;
	public String authorId;

	public BookAuthorPK() {
	}

	public BookAuthorPK(String bookId, String authorId) {
		this.bookId = bookId;
		this.authorId = authorId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public int compareTo(BookAuthorPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = bookId.compareTo(pk.bookId);

		if (value != 0) {
			return value;
		}

		value = authorId.compareTo(pk.authorId);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookAuthorPK)) {
			return false;
		}

		BookAuthorPK pk = (BookAuthorPK)object;

		if (bookId.equals(pk.bookId) && authorId.equals(pk.authorId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, bookId);
		hashCode = HashUtil.hash(hashCode, authorId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("bookId=");

		sb.append(bookId);
		sb.append(", authorId=");

		sb.append(authorId);

		sb.append("}");

		return sb.toString();
	}

}