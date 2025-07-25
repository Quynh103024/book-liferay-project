/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Author service. Represents a row in the &quot;BookServiceBuilder_Author&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.hehehe.servicebuilder.model.impl.AuthorModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.hehehe.servicebuilder.model.impl.AuthorImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @generated
 */
@ProviderType
public interface AuthorModel extends BaseModel<Author> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a author model instance should use the {@link Author} interface instead.
	 */

	/**
	 * Returns the primary key of this author.
	 *
	 * @return the primary key of this author
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this author.
	 *
	 * @param primaryKey the primary key of this author
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the author ID of this author.
	 *
	 * @return the author ID of this author
	 */
	@AutoEscape
	public String getAuthorId();

	/**
	 * Sets the author ID of this author.
	 *
	 * @param authorId the author ID of this author
	 */
	public void setAuthorId(String authorId);

	/**
	 * Returns the name of this author.
	 *
	 * @return the name of this author
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this author.
	 *
	 * @param name the name of this author
	 */
	public void setName(String name);

	/**
	 * Returns the create date of this author.
	 *
	 * @return the create date of this author
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this author.
	 *
	 * @param createDate the create date of this author
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this author.
	 *
	 * @return the modified date of this author
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this author.
	 *
	 * @param modifiedDate the modified date of this author
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public Author cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}