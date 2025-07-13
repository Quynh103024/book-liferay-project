/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.impl;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.service.base.SubtitleServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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

//	CREATE
	
	public Subtitle addSubtitle(String name) {
		return subtitleLocalService.addSubtitle(name);
	}
	
//	READ
	
	public Subtitle getSubtitleById(String subtitleId) throws PortalException {
		return subtitleLocalService.getSubtitle(subtitleId);
	}
	
	public List<Subtitle> getSubtitles(int start, int end, OrderByComparator<Subtitle> obc){
		return subtitleLocalService.getSubtitles(start, end, obc);
	}
	
	public List<Subtitle> getSubtitles(){
		return subtitleLocalService.getSubtitles(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	}
	
	public Subtitle getSubtitleByBookId(String bookId) throws PortalException {
		return subtitleLocalService.getSubtitleByBookId(bookId);
	}
	
//	UPDATE
	
	public Subtitle updateSubtitle(Subtitle subtitle) {
		return subtitleLocalService.updateSubtitle(subtitle);
	}
	
//	DELETE
	
	public Subtitle deleteSubtitle(String subtitleId) throws PortalException {
		return subtitleLocalService.deleteSubtitle(subtitleId);
	}
	
//	LOGIC METHOD

	public int getSubtitlesCount() {
		return subtitleLocalService.getSubtitlesCount();
	}
	
	public boolean isExist(String name) {
		return subtitleLocalService.isExist(name);
	}
	
	public String getSubtitleIdByName(String name) {
		return subtitleLocalService.getSubtitleIdByName(name);
	}
}