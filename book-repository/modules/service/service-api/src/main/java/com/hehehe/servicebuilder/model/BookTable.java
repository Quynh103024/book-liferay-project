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
 * The table class for the &quot;BookServiceBuilder_Book&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
public class BookTable extends BaseTable<BookTable> {

	public static final BookTable INSTANCE = new BookTable();

	public final Column<BookTable, String> bookId = createColumn(
		"bookId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<BookTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookTable, String> thumbnail = createColumn(
		"thumbnail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookTable, Integer> published_year = createColumn(
		"published_year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookTable, Integer> num_pages = createColumn(
		"num_pages", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookTable, Integer> price = createColumn(
		"price", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookTable, Integer> stock = createColumn(
		"stock", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookTable, String> subtitleId = createColumn(
		"subtitleId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookTable, String> categoryId = createColumn(
		"categoryId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BookTable() {
		super("BookServiceBuilder_Book", BookTable::new);
	}

}