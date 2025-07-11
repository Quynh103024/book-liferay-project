/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.impl;

import com.hehehe.servicebuilder.model.BookAuthorTable;
import com.hehehe.servicebuilder.model.impl.BookAuthorImpl;
import com.hehehe.servicebuilder.model.impl.BookAuthorModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from BookAuthor.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.hehehe.servicebuilder.model.impl.BookAuthorImpl",
		"table.name=BookServiceBuilder_BookAuthor"
	},
	service = ArgumentsResolver.class
)
public class BookAuthorModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		BookAuthorModelImpl bookAuthorModelImpl =
			(BookAuthorModelImpl)baseModel;

		long columnBitmask = bookAuthorModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(bookAuthorModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= bookAuthorModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(bookAuthorModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return BookAuthorImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return BookAuthorTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		BookAuthorModelImpl bookAuthorModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = bookAuthorModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = bookAuthorModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}