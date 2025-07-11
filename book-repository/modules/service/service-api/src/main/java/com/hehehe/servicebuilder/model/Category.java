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
 * The extended model interface for the Category service. Represents a row in the &quot;BookServiceBuilder_Category&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryModel
 * @generated
 */
@ImplementationClassName("com.hehehe.servicebuilder.model.impl.CategoryImpl")
@ProviderType
public interface Category extends CategoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.hehehe.servicebuilder.model.impl.CategoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Category, String> CATEGORY_ID_ACCESSOR =
		new Accessor<Category, String>() {

			@Override
			public String get(Category category) {
				return category.getCategoryId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Category> getTypeClass() {
				return Category.class;
			}

		};

}