/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Author service. Represents a row in the &quot;BookServiceBuilder_Author&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorModel
 * @generated
 */
@ImplementationClassName("com.hehehe.servicebuilder.model.impl.AuthorImpl")
@ProviderType
public interface Author extends AuthorModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.hehehe.servicebuilder.model.impl.AuthorImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Author, String> AUTHOR_ID_ACCESSOR =
		new Accessor<Author, String>() {

			@Override
			public String get(Author author) {
				return author.getAuthorId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Author> getTypeClass() {
				return Author.class;
			}

		};

}