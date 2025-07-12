/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.hehehe.servicebuilder.service.persistence.impl;

import com.hehehe.servicebuilder.exception.NoSuchCategoryException;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.model.CategoryTable;
import com.hehehe.servicebuilder.model.impl.CategoryImpl;
import com.hehehe.servicebuilder.model.impl.CategoryModelImpl;
import com.hehehe.servicebuilder.service.persistence.CategoryPersistence;
import com.hehehe.servicebuilder.service.persistence.CategoryUtil;
import com.hehehe.servicebuilder.service.persistence.impl.constants.BookServiceBuilderPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CategoryPersistence.class)
public class CategoryPersistenceImpl
	extends BasePersistenceImpl<Category> implements CategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CategoryUtil</code> to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByName;

	/**
	 * Returns the category where name = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByName(String name) throws NoSuchCategoryException {
		Category category = fetchByName(name);

		if (category == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCategoryException(sb.toString());
		}

		return category;
	}

	/**
	 * Returns the category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof Category) {
			Category category = (Category)result;

			if (!Objects.equals(name, category.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<Category> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"CategoryPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Category category = list.get(0);

					result = category;

					cacheResult(category);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Category)result;
		}
	}

	/**
	 * Removes the category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the category that was removed
	 */
	@Override
	public Category removeByName(String name) throws NoSuchCategoryException {
		Category category = findByName(name);

		return remove(category);
	}

	/**
	 * Returns the number of categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching categories
	 */
	@Override
	public int countByName(String name) {
		Category category = fetchByName(name);

		if (category == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"category.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(category.name IS NULL OR category.name = '')";

	public CategoryPersistenceImpl() {
		setModelClass(Category.class);

		setModelImplClass(CategoryImpl.class);
		setModelPKClass(String.class);

		setTable(CategoryTable.INSTANCE);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	@Override
	public void cacheResult(Category category) {
		entityCache.putResult(
			CategoryImpl.class, category.getPrimaryKey(), category);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {category.getName()},
			category);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	@Override
	public void cacheResult(List<Category> categories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (categories.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Category category : categories) {
			if (entityCache.getResult(
					CategoryImpl.class, category.getPrimaryKey()) == null) {

				cacheResult(category);
			}
		}
	}

	/**
	 * Clears the cache for all categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoryImpl.class);

		finderCache.clearCache(CategoryImpl.class);
	}

	/**
	 * Clears the cache for the category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Category category) {
		entityCache.removeResult(CategoryImpl.class, category);
	}

	@Override
	public void clearCache(List<Category> categories) {
		for (Category category : categories) {
			entityCache.removeResult(CategoryImpl.class, category);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CategoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CategoryModelImpl categoryModelImpl) {

		Object[] args = new Object[] {categoryModelImpl.getName()};

		finderCache.putResult(_finderPathFetchByName, args, categoryModelImpl);
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public Category create(String categoryId) {
		Category category = new CategoryImpl();

		category.setNew(true);
		category.setPrimaryKey(categoryId);

		return category;
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category remove(String categoryId) throws NoSuchCategoryException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category remove(Serializable primaryKey)
		throws NoSuchCategoryException {

		Session session = null;

		try {
			session = openSession();

			Category category = (Category)session.get(
				CategoryImpl.class, primaryKey);

			if (category == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(category);
		}
		catch (NoSuchCategoryException noSuchEntityException) {
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
	protected Category removeImpl(Category category) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(category)) {
				category = (Category)session.get(
					CategoryImpl.class, category.getPrimaryKeyObj());
			}

			if (category != null) {
				session.delete(category);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (category != null) {
			clearCache(category);
		}

		return category;
	}

	@Override
	public Category updateImpl(Category category) {
		boolean isNew = category.isNew();

		if (!(category instanceof CategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(category.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(category);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in category proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Category implementation " +
					category.getClass());
		}

		CategoryModelImpl categoryModelImpl = (CategoryModelImpl)category;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (category.getCreateDate() == null)) {
			if (serviceContext == null) {
				category.setCreateDate(date);
			}
			else {
				category.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!categoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				category.setModifiedDate(date);
			}
			else {
				category.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(category);
			}
			else {
				category = (Category)session.merge(category);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CategoryImpl.class, categoryModelImpl, false, true);

		cacheUniqueFindersCache(categoryModelImpl);

		if (isNew) {
			category.setNew(false);
		}

		category.resetOriginalValues();

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException {

		Category category = fetchByPrimaryKey(primaryKey);

		if (category == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category findByPrimaryKey(String categoryId)
		throws NoSuchCategoryException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	@Override
	public Category fetchByPrimaryKey(String categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	@Override
	public List<Category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	@Override
	public List<Category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	@Override
	public List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categories
	 */
	@Override
	public List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator,
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

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORY;

				sql = sql.concat(CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Category>)QueryUtil.list(
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
	 * Removes all the categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Category category : findAll()) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATEGORY);

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
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category persistence.
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

		_finderPathFetchByName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		CategoryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CategoryUtil.setPersistence(null);

		entityCache.removeCache(CategoryImpl.class.getName());
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

	private static final String _SQL_SELECT_CATEGORY =
		"SELECT category FROM Category category";

	private static final String _SQL_SELECT_CATEGORY_WHERE =
		"SELECT category FROM Category category WHERE ";

	private static final String _SQL_COUNT_CATEGORY =
		"SELECT COUNT(category) FROM Category category";

	private static final String _SQL_COUNT_CATEGORY_WHERE =
		"SELECT COUNT(category) FROM Category category WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "category.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Category exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Category exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CategoryPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}