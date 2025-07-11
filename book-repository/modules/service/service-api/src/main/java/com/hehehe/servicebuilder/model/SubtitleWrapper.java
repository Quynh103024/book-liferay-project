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
 * This class is a wrapper for {@link Subtitle}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Subtitle
 * @generated
 */
public class SubtitleWrapper
	extends BaseModelWrapper<Subtitle>
	implements ModelWrapper<Subtitle>, Subtitle {

	public SubtitleWrapper(Subtitle subtitle) {
		super(subtitle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subtitleId", getSubtitleId());
		attributes.put("name", getName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String subtitleId = (String)attributes.get("subtitleId");

		if (subtitleId != null) {
			setSubtitleId(subtitleId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	public Subtitle cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this subtitle.
	 *
	 * @return the create date of this subtitle
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this subtitle.
	 *
	 * @return the modified date of this subtitle
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this subtitle.
	 *
	 * @return the name of this subtitle
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this subtitle.
	 *
	 * @return the primary key of this subtitle
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the subtitle ID of this subtitle.
	 *
	 * @return the subtitle ID of this subtitle
	 */
	@Override
	public String getSubtitleId() {
		return model.getSubtitleId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this subtitle.
	 *
	 * @param createDate the create date of this subtitle
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this subtitle.
	 *
	 * @param modifiedDate the modified date of this subtitle
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this subtitle.
	 *
	 * @param name the name of this subtitle
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this subtitle.
	 *
	 * @param primaryKey the primary key of this subtitle
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the subtitle ID of this subtitle.
	 *
	 * @param subtitleId the subtitle ID of this subtitle
	 */
	@Override
	public void setSubtitleId(String subtitleId) {
		model.setSubtitleId(subtitleId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SubtitleWrapper wrap(Subtitle subtitle) {
		return new SubtitleWrapper(subtitle);
	}

}