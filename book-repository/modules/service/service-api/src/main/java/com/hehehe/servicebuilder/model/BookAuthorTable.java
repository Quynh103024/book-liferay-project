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
 * The table class for the &quot;BookServiceBuilder_BookAuthor&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BookAuthor
 * @generated
 */
public class BookAuthorTable extends BaseTable<BookAuthorTable> {

	public static final BookAuthorTable INSTANCE = new BookAuthorTable();

	public final Column<BookAuthorTable, String> bookId = createColumn(
		"bookId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<BookAuthorTable, String> authorId = createColumn(
		"authorId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<BookAuthorTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookAuthorTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private BookAuthorTable() {
		super("BookServiceBuilder_BookAuthor", BookAuthorTable::new);
	}

}