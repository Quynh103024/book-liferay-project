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
 * The table class for the &quot;BookServiceBuilder_Author&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @generated
 */
public class AuthorTable extends BaseTable<AuthorTable> {

	public static final AuthorTable INSTANCE = new AuthorTable();

	public final Column<AuthorTable, String> authorId = createColumn(
		"authorId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<AuthorTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuthorTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuthorTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AuthorTable() {
		super("BookServiceBuilder_Author", AuthorTable::new);
	}

}