/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.http;

import com.hehehe.servicebuilder.service.CategoryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>CategoryServiceUtil</code> service
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
public class CategoryServiceHttp {

	public static com.hehehe.servicebuilder.model.Category addCategory(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "addCategory",
				_addCategoryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Category)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Category getCategoryById(
			HttpPrincipal httpPrincipal, String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "getCategoryById",
				_getCategoryByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

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

			return (com.hehehe.servicebuilder.model.Category)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Category>
		getCategories(
			HttpPrincipal httpPrincipal, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.hehehe.servicebuilder.model.Category> obc) {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "getCategories",
				_getCategoriesParameterTypes2);

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

			return (java.util.List<com.hehehe.servicebuilder.model.Category>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Category>
		getCategories(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "getCategories",
				_getCategoriesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hehehe.servicebuilder.model.Category>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Category getCategoryByBookId(
			HttpPrincipal httpPrincipal, String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "getCategoryByBookId",
				_getCategoryByBookIdParameterTypes4);

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

			return (com.hehehe.servicebuilder.model.Category)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Category updateCategory(
		HttpPrincipal httpPrincipal,
		com.hehehe.servicebuilder.model.Category category) {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "updateCategory",
				_updateCategoryParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, category);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Category)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Category deleteCategory(
			HttpPrincipal httpPrincipal, String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "deleteCategory",
				_deleteCategoryParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

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

			return (com.hehehe.servicebuilder.model.Category)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getCategoriesCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "getCategoriesCount",
				_getCategoriesCountParameterTypes7);

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
				CategoryServiceUtil.class, "isExist", _isExistParameterTypes8);

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

	public static String getCategoryIdByName(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				CategoryServiceUtil.class, "getCategoryIdByName",
				_getCategoryIdByNameParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CategoryServiceHttp.class);

	private static final Class<?>[] _addCategoryParameterTypes0 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getCategoryByIdParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _getCategoriesParameterTypes2 =
		new Class[] {
			int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getCategoriesParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _getCategoryByBookIdParameterTypes4 =
		new Class[] {String.class};
	private static final Class<?>[] _updateCategoryParameterTypes5 =
		new Class[] {com.hehehe.servicebuilder.model.Category.class};
	private static final Class<?>[] _deleteCategoryParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _getCategoriesCountParameterTypes7 =
		new Class[] {};
	private static final Class<?>[] _isExistParameterTypes8 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getCategoryIdByNameParameterTypes9 =
		new Class[] {String.class};

}