/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.model.impl;

import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.service.CategoryServiceUtil;
import com.hehehe.servicebuilder.service.SubtitleServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;


/**
 * @author Brian Wing Shun Chan
 */
public class BookImpl extends BookBaseImpl {
	public Category getCategory() throws PortalException {
		return CategoryServiceUtil.getCategoryById(getCategoryId());
	}

	public Subtitle getSubtitle() throws PortalException {
		return SubtitleServiceUtil.getSubtitleById(getSubtitleId());
	}
}