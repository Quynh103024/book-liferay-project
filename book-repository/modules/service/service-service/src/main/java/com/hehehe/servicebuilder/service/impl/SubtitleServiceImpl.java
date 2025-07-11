/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.service.base.SubtitleServiceBaseImpl;
import com.hehehe.util.comparator.SubtitleNameComparator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=bookservicebuilder",
		"json.web.service.context.path=Subtitle" }, service = AopService.class)
public class SubtitleServiceImpl extends SubtitleServiceBaseImpl {
	public Subtitle addSubtitle(String name) {
		return subtitleLocalService.addSubtitle(name);
	}
	public Subtitle getSubtitleById(String subtitleId) throws PortalException {
		return subtitleLocalService.getSubtitle(subtitleId);
	}
	public Subtitle updateSubtitle(Subtitle subtitle) {
		return subtitleLocalService.updateSubtitle(subtitle);
	}
	public Subtitle deleteSubtitle(String subtitleId) throws PortalException {
		return subtitleLocalService.deleteSubtitle(subtitleId);
	}
	public List<Subtitle> getSubtitles(int start, int end, OrderByComparator<Subtitle> obc){
		return subtitleLocalService.getSubtitlesSorted(start, end, obc);
	}
	public List<Subtitle> getAllSubtitle(){
		return subtitleLocalService.getSubtitlesSorted(0, getSubtitlesCount(), new SubtitleNameComparator());
	}
	public List<Book> getBooks(int start, int end, OrderByComparator<Book> obc, String subtitleId){
		return subtitleLocalService.getBooks(start,end,obc,subtitleId);
	}
	public int getSubtitlesCount() {
		return subtitleLocalService.getSubtitlesCount();
	}
}