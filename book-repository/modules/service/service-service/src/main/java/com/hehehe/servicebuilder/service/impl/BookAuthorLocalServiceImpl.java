/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.BookAuthor;
import com.hehehe.servicebuilder.service.base.BookAuthorLocalServiceBaseImpl;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPK;
import com.hehehe.servicebuilder.service.persistence.BookAuthorPersistence;
import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hehehe.servicebuilder.model.BookAuthor",
	service = AopService.class
)
public class BookAuthorLocalServiceImpl extends BookAuthorLocalServiceBaseImpl {
	@Reference
	protected BookAuthorPersistence bookAuthorPersistence;

}