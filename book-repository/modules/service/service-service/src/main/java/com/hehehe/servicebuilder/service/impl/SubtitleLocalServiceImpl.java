/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;

import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.model.impl.SubtitleImpl;
import com.hehehe.servicebuilder.service.BookLocalService;
import com.hehehe.servicebuilder.service.base.SubtitleLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.hehehe.servicebuilder.model.Subtitle",
	service = AopService.class
)
public class SubtitleLocalServiceImpl extends SubtitleLocalServiceBaseImpl {

//	REFERENCE
	
	@Reference
	private BookLocalService bookLocalService;

//	CREATE
	
	public Subtitle addSubtitle(String name) {
		String id = UUID.randomUUID().toString();
		Date now = new Date();
		Subtitle subtitle = new SubtitleImpl();
		subtitle.setSubtitleId(id);
		subtitle.setName(name);
		subtitle.setCreateDate(now);
		subtitle.setModifiedDate(now);
		return super.addSubtitle(subtitle);
	}
	
//	READ
	
	public List<Subtitle> getSubtitles(int start, int end, OrderByComparator<Subtitle> obc){
		return subtitlePersistence.findAll(start, end, obc);
	}
	
	public Subtitle getSubtitleByBookId(String bookId) throws PortalException {
		Book book = bookLocalService.getBook(bookId);
		return super.getSubtitle(book.getSubtitleId());
	}
	
//	UPDATE
	
	@Override
	public Subtitle updateSubtitle(Subtitle subtitle) {
		Date now = new Date();
		subtitle.setModifiedDate(now);
		return super.updateSubtitle(subtitle);
	}
	
//	DELETE
	
	@Override
	public Subtitle deleteSubtitle(String subtitleId) throws PortalException {
		bookLocalService.deleteBooksBySubtitleId(subtitleId);
		return super.deleteSubtitle(subtitleId);
	}
	
//	LOGIC METHOD

	public boolean isExist(String name) {
		return subtitlePersistence.fetchByName(name) != null;
	}
	
}