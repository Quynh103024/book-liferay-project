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
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
public class BookWrapper
	extends BaseModelWrapper<Book> implements Book, ModelWrapper<Book> {

	public BookWrapper(Book book) {
		super(book);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("title", getTitle());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("thumbnail", getThumbnail());
		attributes.put("published_year", getPublished_year());
		attributes.put("num_pages", getNum_pages());
		attributes.put("price", getPrice());
		attributes.put("stock", getStock());
		attributes.put("subtitleId", getSubtitleId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String bookId = (String)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String thumbnail = (String)attributes.get("thumbnail");

		if (thumbnail != null) {
			setThumbnail(thumbnail);
		}

		Integer published_year = (Integer)attributes.get("published_year");

		if (published_year != null) {
			setPublished_year(published_year);
		}

		Integer num_pages = (Integer)attributes.get("num_pages");

		if (num_pages != null) {
			setNum_pages(num_pages);
		}

		Integer price = (Integer)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer stock = (Integer)attributes.get("stock");

		if (stock != null) {
			setStock(stock);
		}

		String subtitleId = (String)attributes.get("subtitleId");

		if (subtitleId != null) {
			setSubtitleId(subtitleId);
		}

		String categoryId = (String)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	@Override
	public Book cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the book ID of this book.
	 *
	 * @return the book ID of this book
	 */
	@Override
	public String getBookId() {
		return model.getBookId();
	}

	@Override
	public Category getCategory()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getCategory();
	}

	/**
	 * Returns the category ID of this book.
	 *
	 * @return the category ID of this book
	 */
	@Override
	public String getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the create date of this book.
	 *
	 * @return the create date of this book
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this book.
	 *
	 * @return the description of this book
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the modified date of this book.
	 *
	 * @return the modified date of this book
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the num_pages of this book.
	 *
	 * @return the num_pages of this book
	 */
	@Override
	public Integer getNum_pages() {
		return model.getNum_pages();
	}

	/**
	 * Returns the price of this book.
	 *
	 * @return the price of this book
	 */
	@Override
	public Integer getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this book.
	 *
	 * @return the primary key of this book
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the published_year of this book.
	 *
	 * @return the published_year of this book
	 */
	@Override
	public Integer getPublished_year() {
		return model.getPublished_year();
	}

	/**
	 * Returns the stock of this book.
	 *
	 * @return the stock of this book
	 */
	@Override
	public Integer getStock() {
		return model.getStock();
	}

	@Override
	public Subtitle getSubtitle()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getSubtitle();
	}

	/**
	 * Returns the subtitle ID of this book.
	 *
	 * @return the subtitle ID of this book
	 */
	@Override
	public String getSubtitleId() {
		return model.getSubtitleId();
	}

	/**
	 * Returns the thumbnail of this book.
	 *
	 * @return the thumbnail of this book
	 */
	@Override
	public String getThumbnail() {
		return model.getThumbnail();
	}

	/**
	 * Returns the title of this book.
	 *
	 * @return the title of this book
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the book ID of this book.
	 *
	 * @param bookId the book ID of this book
	 */
	@Override
	public void setBookId(String bookId) {
		model.setBookId(bookId);
	}

	/**
	 * Sets the category ID of this book.
	 *
	 * @param categoryId the category ID of this book
	 */
	@Override
	public void setCategoryId(String categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the create date of this book.
	 *
	 * @param createDate the create date of this book
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this book.
	 *
	 * @param description the description of this book
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the modified date of this book.
	 *
	 * @param modifiedDate the modified date of this book
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the num_pages of this book.
	 *
	 * @param num_pages the num_pages of this book
	 */
	@Override
	public void setNum_pages(Integer num_pages) {
		model.setNum_pages(num_pages);
	}

	/**
	 * Sets the price of this book.
	 *
	 * @param price the price of this book
	 */
	@Override
	public void setPrice(Integer price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this book.
	 *
	 * @param primaryKey the primary key of this book
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the published_year of this book.
	 *
	 * @param published_year the published_year of this book
	 */
	@Override
	public void setPublished_year(Integer published_year) {
		model.setPublished_year(published_year);
	}

	/**
	 * Sets the stock of this book.
	 *
	 * @param stock the stock of this book
	 */
	@Override
	public void setStock(Integer stock) {
		model.setStock(stock);
	}

	/**
	 * Sets the subtitle ID of this book.
	 *
	 * @param subtitleId the subtitle ID of this book
	 */
	@Override
	public void setSubtitleId(String subtitleId) {
		model.setSubtitleId(subtitleId);
	}

	/**
	 * Sets the thumbnail of this book.
	 *
	 * @param thumbnail the thumbnail of this book
	 */
	@Override
	public void setThumbnail(String thumbnail) {
		model.setThumbnail(thumbnail);
	}

	/**
	 * Sets the title of this book.
	 *
	 * @param title the title of this book
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BookWrapper wrap(Book book) {
		return new BookWrapper(book);
	}

}