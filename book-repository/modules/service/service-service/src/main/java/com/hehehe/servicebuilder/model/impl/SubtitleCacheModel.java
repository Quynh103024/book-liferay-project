/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model.impl;

import com.hehehe.servicebuilder.model.Subtitle;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subtitle in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubtitleCacheModel
	implements CacheModel<Subtitle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubtitleCacheModel)) {
			return false;
		}

		SubtitleCacheModel subtitleCacheModel = (SubtitleCacheModel)object;

		if (subtitleId.equals(subtitleCacheModel.subtitleId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subtitleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{subtitleId=");
		sb.append(subtitleId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subtitle toEntityModel() {
		SubtitleImpl subtitleImpl = new SubtitleImpl();

		if (subtitleId == null) {
			subtitleImpl.setSubtitleId("");
		}
		else {
			subtitleImpl.setSubtitleId(subtitleId);
		}

		if (name == null) {
			subtitleImpl.setName("");
		}
		else {
			subtitleImpl.setName(name);
		}

		if (createDate == Long.MIN_VALUE) {
			subtitleImpl.setCreateDate(null);
		}
		else {
			subtitleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subtitleImpl.setModifiedDate(null);
		}
		else {
			subtitleImpl.setModifiedDate(new Date(modifiedDate));
		}

		subtitleImpl.resetOriginalValues();

		return subtitleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subtitleId = objectInput.readUTF();
		name = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (subtitleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subtitleId);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String subtitleId;
	public String name;
	public long createDate;
	public long modifiedDate;

}