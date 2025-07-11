/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.http;

import com.hehehe.servicebuilder.service.BookServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>BookServiceUtil</code> service
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
public class BookServiceHttp {

	public static com.hehehe.servicebuilder.model.Book addBook(
		HttpPrincipal httpPrincipal, String title, String description,
		String thumbnail, String subtitleId, String categoryId, Integer price,
		Integer stock, Integer pages, Integer publicYear) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "addBook", _addBookParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, description, thumbnail, subtitleId,
				categoryId, price, stock, pages, publicYear);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Book getBook(
			HttpPrincipal httpPrincipal, String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getBook", _getBookParameterTypes1);

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

			return (com.hehehe.servicebuilder.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Book updateBook(
		HttpPrincipal httpPrincipal,
		com.hehehe.servicebuilder.model.Book book) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "updateBook",
				_updateBookParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, book);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.hehehe.servicebuilder.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.hehehe.servicebuilder.model.Book deleteBook(
			HttpPrincipal httpPrincipal, String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "deleteBook",
				_deleteBookParameterTypes3);

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

			return (com.hehehe.servicebuilder.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Book> getBooks(
		HttpPrincipal httpPrincipal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.hehehe.servicebuilder.model.Book> obc) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getBooks", _getBooksParameterTypes4);

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

			return (java.util.List<com.hehehe.servicebuilder.model.Book>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Author>
			getAuthors(HttpPrincipal httpPrincipal, String bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getAuthors",
				_getAuthorsParameterTypes5);

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

			return (java.util.List<com.hehehe.servicebuilder.model.Author>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.hehehe.servicebuilder.model.Book>
		getAllBook(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getAllBook",
				_getAllBookParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.hehehe.servicebuilder.model.Book>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteBooksByCategoryId(
			HttpPrincipal httpPrincipal, String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "deleteBooksByCategoryId",
				_deleteBooksByCategoryIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
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
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteBooksBySubtitleId(
			HttpPrincipal httpPrincipal, String subtitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "deleteBooksBySubtitleId",
				_deleteBooksBySubtitleIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subtitleId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
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
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getBooksCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getBooksCount",
				_getBooksCountParameterTypes9);

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

	public static void addAuthers(
		HttpPrincipal httpPrincipal, java.util.List<String> autherIds,
		String bookId) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "addAuthers",
				_addAuthersParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, autherIds, bookId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BookServiceHttp.class);

	private static final Class<?>[] _addBookParameterTypes0 = new Class[] {
		String.class, String.class, String.class, String.class, String.class,
		Integer.class, Integer.class, Integer.class, Integer.class
	};
	private static final Class<?>[] _getBookParameterTypes1 = new Class[] {
		String.class
	};
	private static final Class<?>[] _updateBookParameterTypes2 = new Class[] {
		com.hehehe.servicebuilder.model.Book.class
	};
	private static final Class<?>[] _deleteBookParameterTypes3 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getBooksParameterTypes4 = new Class[] {
		int.class, int.class,
		com.liferay.portal.kernel.util.OrderByComparator.class
	};
	private static final Class<?>[] _getAuthorsParameterTypes5 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getAllBookParameterTypes6 = new Class[] {};
	private static final Class<?>[] _deleteBooksByCategoryIdParameterTypes7 =
		new Class[] {String.class};
	private static final Class<?>[] _deleteBooksBySubtitleIdParameterTypes8 =
		new Class[] {String.class};
	private static final Class<?>[] _getBooksCountParameterTypes9 =
		new Class[] {};
	private static final Class<?>[] _addAuthersParameterTypes10 = new Class[] {
		java.util.List.class, String.class
	};

}