/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.http;

import com.hehehe.servicebuilder.service.SubtitleServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>SubtitleServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubtitleServiceHttp {

	public static com.hehehe.servicebuilder.model.Subtitle addSubtitle(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "addSubtitle",
				_addSubtitleParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Subtitle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Subtitle getSubtitleById(
			HttpPrincipal httpPrincipal, String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "getSubtitleById",
				_getSubtitleByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subtitleId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Subtitle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Subtitle>
		getSubtitles(
			HttpPrincipal httpPrincipal, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Subtitle> obc) {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "getSubtitles",
				_getSubtitlesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end, obc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hehehe.servicebuilder.model.Subtitle>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Subtitle>
		getSubtitles(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "getSubtitles",
				_getSubtitlesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hehehe.servicebuilder.model.Subtitle>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Subtitle getSubtitleByBookId(
			HttpPrincipal httpPrincipal, String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "getSubtitleByBookId",
				_getSubtitleByBookIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, bookId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Subtitle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Subtitle updateSubtitle(
		HttpPrincipal httpPrincipal,
		com.hehehe.servicebuilder.model.Subtitle subtitle) {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "updateSubtitle",
				_updateSubtitleParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subtitle);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Subtitle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Subtitle deleteSubtitle(
			HttpPrincipal httpPrincipal, String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "deleteSubtitle",
				_deleteSubtitleParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subtitleId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Subtitle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getSubtitlesCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "getSubtitlesCount",
				_getSubtitlesCountParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static boolean isExist(HttpPrincipal httpPrincipal, String name) {
		try {
			MethodKey methodKey = new MethodKey(
				SubtitleServiceUtil.class, "isExist", _isExistParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubtitleServiceHttp.class);

	private static final Class<?>[] _addSubtitleParameterTypes0 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getSubtitleByIdParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _getSubtitlesParameterTypes2 = new Class[] {
		int.class, int.class,
		com.liferay.portal.kernel.util.OrderByComparator.class
	};
	private static final Class<?>[] _getSubtitlesParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _getSubtitleByBookIdParameterTypes4 =
		new Class[] {String.class};
	private static final Class<?>[] _updateSubtitleParameterTypes5 =
		new Class[] {com.hehehe.servicebuilder.model.Subtitle.class};
	private static final Class<?>[] _deleteSubtitleParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _getSubtitlesCountParameterTypes7 =
		new Class[] {};
	private static final Class<?>[] _isExistParameterTypes8 = new Class[] {
		String.class
	};

}