/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;BookServiceBuilder_Category&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
public class CategoryTable extends BaseTable<CategoryTable> {

	public static final CategoryTable INSTANCE = new CategoryTable();

	public final Column<CategoryTable, String> categoryId = createColumn(
		"categoryId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<CategoryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CategoryTable() {
		super("BookServiceBuilder_Category", CategoryTable::new);
	}

}