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
 * The extended model interface for the Book service. Represents a row in the &quot;BookServiceBuilder_Book&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BookModel
 * @generated
 */
@ImplementationClassName("com.hehehe.servicebuilder.model.impl.BookImpl")
@ProviderType
public interface Book extends BookModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.hehehe.servicebuilder.model.impl.BookImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Book, String> BOOK_ID_ACCESSOR =
		new Accessor<Book, String>() {

			@Override
			public String get(Book book) {
				return book.getBookId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Book> getTypeClass() {
				return Book.class;
			}

		};

}