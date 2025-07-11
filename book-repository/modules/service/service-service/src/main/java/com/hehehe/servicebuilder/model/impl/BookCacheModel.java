/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model.impl;

import com.hehehe.servicebuilder.model.Book;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookCacheModel)) {
			return false;
		}

		BookCacheModel bookCacheModel = (BookCacheModel)object;

		if (bookId.equals(bookCacheModel.bookId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", thumbnail=");
		sb.append(thumbnail);
		sb.append(", published_year=");
		sb.append(published_year);
		sb.append(", num_pages=");
		sb.append(num_pages);
		sb.append(", price=");
		sb.append(price);
		sb.append(", stock=");
		sb.append(stock);
		sb.append(", subtitleId=");
		sb.append(subtitleId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		if (bookId == null) {
			bookImpl.setBookId("");
		}
		else {
			bookImpl.setBookId(bookId);
		}

		if (title == null) {
			bookImpl.setTitle("");
		}
		else {
			bookImpl.setTitle(title);
		}

		if (createDate == Long.MIN_VALUE) {
			bookImpl.setCreateDate(null);
		}
		else {
			bookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookImpl.setModifiedDate(null);
		}
		else {
			bookImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			bookImpl.setDescription("");
		}
		else {
			bookImpl.setDescription(description);
		}

		if (thumbnail == null) {
			bookImpl.setThumbnail("");
		}
		else {
			bookImpl.setThumbnail(thumbnail);
		}

		bookImpl.setPublished_year(published_year);
		bookImpl.setNum_pages(num_pages);
		bookImpl.setPrice(price);
		bookImpl.setStock(stock);

		if (subtitleId == null) {
			bookImpl.setSubtitleId("");
		}
		else {
			bookImpl.setSubtitleId(subtitleId);
		}

		if (categoryId == null) {
			bookImpl.setCategoryId("");
		}
		else {
			bookImpl.setCategoryId(categoryId);
		}

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readUTF();
		title = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		thumbnail = objectInput.readUTF();

		published_year = objectInput.readInt();

		num_pages = objectInput.readInt();

		price = objectInput.readInt();

		stock = objectInput.readInt();
		subtitleId = objectInput.readUTF();
		categoryId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (bookId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookId);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (thumbnail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thumbnail);
		}

		objectOutput.writeInt(published_year);

		objectOutput.writeInt(num_pages);

		objectOutput.writeInt(price);

		objectOutput.writeInt(stock);

		if (subtitleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subtitleId);
		}

		if (categoryId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryId);
		}
	}

	public String bookId;
	public String title;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String thumbnail;
	public int published_year;
	public int num_pages;
	public int price;
	public int stock;
	public String subtitleId;
	public String categoryId;

}