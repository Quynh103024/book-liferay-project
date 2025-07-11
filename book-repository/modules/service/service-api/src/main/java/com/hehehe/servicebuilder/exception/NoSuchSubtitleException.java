/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.hehehe.servicebuilder.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSubtitleException extends NoSuchModelException {

	public NoSuchSubtitleException() {
	}

	public NoSuchSubtitleException(String msg) {
		super(msg);
	}

	public NoSuchSubtitleException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSubtitleException(Throwable throwable) {
		super(throwable);
	}

}