/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.impl;

import com.hehehe.servicebuilder.exception.NoSuchSubtitleException;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.model.SubtitleTable;
import com.hehehe.servicebuilder.model.impl.SubtitleImpl;
import com.hehehe.servicebuilder.model.impl.SubtitleModelImpl;
import com.hehehe.servicebuilder.service.persistence.SubtitlePersistence;
import com.hehehe.servicebuilder.service.persistence.SubtitleUtil;
import com.hehehe.servicebuilder.service.persistence.impl.constants.BookServiceBuilderPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the subtitle service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubtitlePersistence.class)
public class SubtitlePersistenceImpl
	extends BasePersistenceImpl<Subtitle> implements SubtitlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubtitleUtil</code> to access the subtitle persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubtitleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SubtitlePersistenceImpl() {
		setModelClass(Subtitle.class);

		setModelImplClass(SubtitleImpl.class);
		setModelPKClass(String.class);

		setTable(SubtitleTable.INSTANCE);
	}

	/**
	 * Caches the subtitle in the entity cache if it is enabled.
	 *
	 * @param subtitle the subtitle
	 */
	@Override
	public void cacheResult(Subtitle subtitle) {
		entityCache.putResult(
			SubtitleImpl.class, subtitle.getPrimaryKey(), subtitle);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the subtitles in the entity cache if it is enabled.
	 *
	 * @param subtitles the subtitles
	 */
	@Override
	public void cacheResult(List<Subtitle> subtitles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subtitles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Subtitle subtitle : subtitles) {
			if (entityCache.getResult(
					SubtitleImpl.class, subtitle.getPrimaryKey()) == null) {

				cacheResult(subtitle);
			}
		}
	}

	/**
	 * Clears the cache for all subtitles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubtitleImpl.class);

		finderCache.clearCache(SubtitleImpl.class);
	}

	/**
	 * Clears the cache for the subtitle.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subtitle subtitle) {
		entityCache.removeResult(SubtitleImpl.class, subtitle);
	}

	@Override
	public void clearCache(List<Subtitle> subtitles) {
		for (Subtitle subtitle : subtitles) {
			entityCache.removeResult(SubtitleImpl.class, subtitle);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SubtitleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubtitleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new subtitle with the primary key. Does not add the subtitle to the database.
	 *
	 * @param subtitleId the primary key for the new subtitle
	 * @return the new subtitle
	 */
	@Override
	public Subtitle create(String subtitleId) {
		Subtitle subtitle = new SubtitleImpl();

		subtitle.setNew(true);
		subtitle.setPrimaryKey(subtitleId);

		return subtitle;
	}

	/**
	 * Removes the subtitle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle that was removed
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	@Override
	public Subtitle remove(String subtitleId) throws NoSuchSubtitleException {
		return remove((Serializable)subtitleId);
	}

	/**
	 * Removes the subtitle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subtitle
	 * @return the subtitle that was removed
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	@Override
	public Subtitle remove(Serializable primaryKey)
		throws NoSuchSubtitleException {

		Session session = null;

		try {
			session = openSession();

			Subtitle subtitle = (Subtitle)session.get(
				SubtitleImpl.class, primaryKey);

			if (subtitle == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubtitleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subtitle);
		}
		catch (NoSuchSubtitleException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Subtitle removeImpl(Subtitle subtitle) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subtitle)) {
				subtitle = (Subtitle)session.get(
					SubtitleImpl.class, subtitle.getPrimaryKeyObj());
			}

			if (subtitle != null) {
				session.delete(subtitle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subtitle != null) {
			clearCache(subtitle);
		}

		return subtitle;
	}

	@Override
	public Subtitle updateImpl(Subtitle subtitle) {
		boolean isNew = subtitle.isNew();

		if (!(subtitle instanceof SubtitleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subtitle.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subtitle);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subtitle proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Subtitle implementation " +
					subtitle.getClass());
		}

		SubtitleModelImpl subtitleModelImpl = (SubtitleModelImpl)subtitle;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (subtitle.getCreateDate() == null)) {
			if (serviceContext == null) {
				subtitle.setCreateDate(date);
			}
			else {
				subtitle.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!subtitleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subtitle.setModifiedDate(date);
			}
			else {
				subtitle.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subtitle);
			}
			else {
				subtitle = (Subtitle)session.merge(subtitle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SubtitleImpl.class, subtitle, false, true);

		if (isNew) {
			subtitle.setNew(false);
		}

		subtitle.resetOriginalValues();

		return subtitle;
	}

	/**
	 * Returns the subtitle with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subtitle
	 * @return the subtitle
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	@Override
	public Subtitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubtitleException {

		Subtitle subtitle = fetchByPrimaryKey(primaryKey);

		if (subtitle == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubtitleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subtitle;
	}

	/**
	 * Returns the subtitle with the primary key or throws a <code>NoSuchSubtitleException</code> if it could not be found.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle
	 * @throws NoSuchSubtitleException if a subtitle with the primary key could not be found
	 */
	@Override
	public Subtitle findByPrimaryKey(String subtitleId)
		throws NoSuchSubtitleException {

		return findByPrimaryKey((Serializable)subtitleId);
	}

	/**
	 * Returns the subtitle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subtitleId the primary key of the subtitle
	 * @return the subtitle, or <code>null</code> if a subtitle with the primary key could not be found
	 */
	@Override
	public Subtitle fetchByPrimaryKey(String subtitleId) {
		return fetchByPrimaryKey((Serializable)subtitleId);
	}

	/**
	 * Returns all the subtitles.
	 *
	 * @return the subtitles
	 */
	@Override
	public List<Subtitle> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @return the range of subtitles
	 */
	@Override
	public List<Subtitle> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subtitles
	 */
	@Override
	public List<Subtitle> findAll(
		int start, int end, OrderByComparator<Subtitle> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subtitles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtitles
	 * @param end the upper bound of the range of subtitles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subtitles
	 */
	@Override
	public List<Subtitle> findAll(
		int start, int end, OrderByComparator<Subtitle> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Subtitle> list = null;

		if (useFinderCache) {
			list = (List<Subtitle>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBTITLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBTITLE;

				sql = sql.concat(SubtitleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Subtitle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the subtitles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Subtitle subtitle : findAll()) {
			remove(subtitle);
		}
	}

	/**
	 * Returns the number of subtitles.
	 *
	 * @return the number of subtitles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBTITLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "subtitleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBTITLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubtitleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subtitle persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		SubtitleUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SubtitleUtil.setPersistence(null);

		entityCache.removeCache(SubtitleImpl.class.getName());
	}

	@Override
	@Reference(
		target = BookServiceBuilderPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BookServiceBuilderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BookServiceBuilderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUBTITLE =
		"SELECT subtitle FROM Subtitle subtitle";

	private static final String _SQL_COUNT_SUBTITLE =
		"SELECT COUNT(subtitle) FROM Subtitle subtitle";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subtitle.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Subtitle exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SubtitlePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}