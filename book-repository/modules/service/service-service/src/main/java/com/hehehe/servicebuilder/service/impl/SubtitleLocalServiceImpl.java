/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.model.impl.SubtitleImpl;
import com.hehehe.servicebuilder.service.base.SubtitleLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hehehe.servicebuilder.model.Subtitle",
	service = AopService.class
)
public class SubtitleLocalServiceImpl extends SubtitleLocalServiceBaseImpl {
	public Subtitle addSubtitle(String name) {
		Subtitle subtitle = new SubtitleImpl();
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		subtitle.setSubtitleId(id);
		subtitle.setName(name);
		subtitle.setCreateDate(now);
		subtitle.setModifiedDate(now);
		return subtitleLocalService.addSubtitle(subtitle);
	}
	public List<Subtitle> getSubtitlesSorted(int start, int end, OrderByComparator<Subtitle> obc){
		return subtitlePersistence.findAll(start, end, obc);
	}
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc, String subtitleId){
		return bookPersistence.findBySubtitleId(subtitleId, start, end, obc);
	}
	@Override
	public Subtitle updateSubtitle(Subtitle subtitle) {
		Date now = new Date();
		subtitle.setModifiedDate(now);
		return subtitlePersistence.update(subtitle);
	}
}