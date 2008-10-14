/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.kb.knowledgebase.service.persistence;

import com.liferay.kb.knowledgebase.NoSuchFeedbackEntryException;
import com.liferay.kb.knowledgebase.model.KBFeedbackEntry;
import com.liferay.kb.knowledgebase.model.impl.KBFeedbackEntryImpl;
import com.liferay.kb.knowledgebase.model.impl.KBFeedbackEntryModelImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="KBFeedbackEntryPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Jorge Ferrer
 *
 */
public class KBFeedbackEntryPersistenceImpl extends BasePersistenceImpl
	implements KBFeedbackEntryPersistence {
	public KBFeedbackEntry create(long feedbackEntryId) {
		KBFeedbackEntry kbFeedbackEntry = new KBFeedbackEntryImpl();

		kbFeedbackEntry.setNew(true);
		kbFeedbackEntry.setPrimaryKey(feedbackEntryId);

		return kbFeedbackEntry;
	}

	public KBFeedbackEntry remove(long feedbackEntryId)
		throws NoSuchFeedbackEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KBFeedbackEntry kbFeedbackEntry = (KBFeedbackEntry)session.get(KBFeedbackEntryImpl.class,
					new Long(feedbackEntryId));

			if (kbFeedbackEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No KBFeedbackEntry exists with the primary key " +
						feedbackEntryId);
				}

				throw new NoSuchFeedbackEntryException(
					"No KBFeedbackEntry exists with the primary key " +
					feedbackEntryId);
			}

			return remove(kbFeedbackEntry);
		}
		catch (NoSuchFeedbackEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public KBFeedbackEntry remove(KBFeedbackEntry kbFeedbackEntry)
		throws SystemException {
		if (_listeners.length > 0) {
			for (ModelListener listener : _listeners) {
				listener.onBeforeRemove(kbFeedbackEntry);
			}
		}

		kbFeedbackEntry = removeImpl(kbFeedbackEntry);

		if (_listeners.length > 0) {
			for (ModelListener listener : _listeners) {
				listener.onAfterRemove(kbFeedbackEntry);
			}
		}

		return kbFeedbackEntry;
	}

	protected KBFeedbackEntry removeImpl(KBFeedbackEntry kbFeedbackEntry)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(KBFeedbackEntryImpl.class,
						kbFeedbackEntry.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(kbFeedbackEntry);

			session.flush();

			return kbFeedbackEntry;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);

			FinderCacheUtil.clearCache(KBFeedbackEntry.class.getName());
		}
	}

	public KBFeedbackEntry update(KBFeedbackEntry kbFeedbackEntry)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(KBFeedbackEntry kbFeedbackEntry) method. Use update(KBFeedbackEntry kbFeedbackEntry, boolean merge) instead.");
		}

		return update(kbFeedbackEntry, false);
	}

	public KBFeedbackEntry update(KBFeedbackEntry kbFeedbackEntry, boolean merge)
		throws SystemException {
		boolean isNew = kbFeedbackEntry.isNew();

		if (_listeners.length > 0) {
			for (ModelListener listener : _listeners) {
				if (isNew) {
					listener.onBeforeCreate(kbFeedbackEntry);
				}
				else {
					listener.onBeforeUpdate(kbFeedbackEntry);
				}
			}
		}

		kbFeedbackEntry = updateImpl(kbFeedbackEntry, merge);

		if (_listeners.length > 0) {
			for (ModelListener listener : _listeners) {
				if (isNew) {
					listener.onAfterCreate(kbFeedbackEntry);
				}
				else {
					listener.onAfterUpdate(kbFeedbackEntry);
				}
			}
		}

		return kbFeedbackEntry;
	}

	public KBFeedbackEntry updateImpl(
		com.liferay.kb.knowledgebase.model.KBFeedbackEntry kbFeedbackEntry,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, kbFeedbackEntry, merge);

			kbFeedbackEntry.setNew(false);

			return kbFeedbackEntry;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);

			FinderCacheUtil.clearCache(KBFeedbackEntry.class.getName());
		}
	}

	public KBFeedbackEntry findByPrimaryKey(long feedbackEntryId)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = fetchByPrimaryKey(feedbackEntryId);

		if (kbFeedbackEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No KBFeedbackEntry exists with the primary key " +
					feedbackEntryId);
			}

			throw new NoSuchFeedbackEntryException(
				"No KBFeedbackEntry exists with the primary key " +
				feedbackEntryId);
		}

		return kbFeedbackEntry;
	}

	public KBFeedbackEntry fetchByPrimaryKey(long feedbackEntryId)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			return (KBFeedbackEntry)session.get(KBFeedbackEntryImpl.class,
				new Long(feedbackEntryId));
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<KBFeedbackEntry> findByArticleResourcePrimKey(
		long articleResourcePrimKey) throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByArticleResourcePrimKey";
		String[] finderParams = new String[] { Long.class.getName() };
		Object[] finderArgs = new Object[] { new Long(articleResourcePrimKey) };

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				List<KBFeedbackEntry> list = q.list();

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public List<KBFeedbackEntry> findByArticleResourcePrimKey(
		long articleResourcePrimKey, int start, int end)
		throws SystemException {
		return findByArticleResourcePrimKey(articleResourcePrimKey, start, end,
			null);
	}

	public List<KBFeedbackEntry> findByArticleResourcePrimKey(
		long articleResourcePrimKey, int start, int end, OrderByComparator obc)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByArticleResourcePrimKey";
		String[] finderParams = new String[] {
				Long.class.getName(),
				
				"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				List<KBFeedbackEntry> list = (List<KBFeedbackEntry>)QueryUtil.list(q,
						getDialect(), start, end);

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public KBFeedbackEntry findByArticleResourcePrimKey_First(
		long articleResourcePrimKey, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		List<KBFeedbackEntry> list = findByArticleResourcePrimKey(articleResourcePrimKey,
				0, 1, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry findByArticleResourcePrimKey_Last(
		long articleResourcePrimKey, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		int count = countByArticleResourcePrimKey(articleResourcePrimKey);

		List<KBFeedbackEntry> list = findByArticleResourcePrimKey(articleResourcePrimKey,
				count - 1, count, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry[] findByArticleResourcePrimKey_PrevAndNext(
		long feedbackEntryId, long articleResourcePrimKey, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = findByPrimaryKey(feedbackEntryId);

		int count = countByArticleResourcePrimKey(articleResourcePrimKey);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

			query.append("articleResourcePrimKey = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("createDate DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleResourcePrimKey);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					kbFeedbackEntry);

			KBFeedbackEntry[] array = new KBFeedbackEntryImpl[3];

			array[0] = (KBFeedbackEntry)objArray[0];
			array[1] = (KBFeedbackEntry)objArray[1];
			array[2] = (KBFeedbackEntry)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<KBFeedbackEntry> findByUserId(long userId)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByUserId";
		String[] finderParams = new String[] { Long.class.getName() };
		Object[] finderArgs = new Object[] { new Long(userId) };

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("userId = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<KBFeedbackEntry> list = q.list();

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public List<KBFeedbackEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<KBFeedbackEntry> findByUserId(long userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByUserId";
		String[] finderParams = new String[] {
				Long.class.getName(),
				
				"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
		Object[] finderArgs = new Object[] {
				new Long(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("userId = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<KBFeedbackEntry> list = (List<KBFeedbackEntry>)QueryUtil.list(q,
						getDialect(), start, end);

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public KBFeedbackEntry findByUserId_First(long userId, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		List<KBFeedbackEntry> list = findByUserId(userId, 0, 1, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry findByUserId_Last(long userId, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		int count = countByUserId(userId);

		List<KBFeedbackEntry> list = findByUserId(userId, count - 1, count, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry[] findByUserId_PrevAndNext(long feedbackEntryId,
		long userId, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = findByPrimaryKey(feedbackEntryId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

			query.append("userId = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("createDate DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					kbFeedbackEntry);

			KBFeedbackEntry[] array = new KBFeedbackEntryImpl[3];

			array[0] = (KBFeedbackEntry)objArray[0];
			array[1] = (KBFeedbackEntry)objArray[1];
			array[2] = (KBFeedbackEntry)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<KBFeedbackEntry> findByA_S(long articleResourcePrimKey,
		int score) throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByA_S";
		String[] finderParams = new String[] {
				Long.class.getName(), Integer.class.getName()
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Integer(score)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("score = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(score);

				List<KBFeedbackEntry> list = q.list();

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public List<KBFeedbackEntry> findByA_S(long articleResourcePrimKey,
		int score, int start, int end) throws SystemException {
		return findByA_S(articleResourcePrimKey, score, start, end, null);
	}

	public List<KBFeedbackEntry> findByA_S(long articleResourcePrimKey,
		int score, int start, int end, OrderByComparator obc)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByA_S";
		String[] finderParams = new String[] {
				Long.class.getName(), Integer.class.getName(),
				
				"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Integer(score),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("score = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(score);

				List<KBFeedbackEntry> list = (List<KBFeedbackEntry>)QueryUtil.list(q,
						getDialect(), start, end);

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public KBFeedbackEntry findByA_S_First(long articleResourcePrimKey,
		int score, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		List<KBFeedbackEntry> list = findByA_S(articleResourcePrimKey, score,
				0, 1, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(", ");
			msg.append("score=" + score);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry findByA_S_Last(long articleResourcePrimKey,
		int score, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		int count = countByA_S(articleResourcePrimKey, score);

		List<KBFeedbackEntry> list = findByA_S(articleResourcePrimKey, score,
				count - 1, count, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(", ");
			msg.append("score=" + score);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry[] findByA_S_PrevAndNext(long feedbackEntryId,
		long articleResourcePrimKey, int score, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = findByPrimaryKey(feedbackEntryId);

		int count = countByA_S(articleResourcePrimKey, score);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

			query.append("articleResourcePrimKey = ?");

			query.append(" AND ");

			query.append("score = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("createDate DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleResourcePrimKey);

			qPos.add(score);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					kbFeedbackEntry);

			KBFeedbackEntry[] array = new KBFeedbackEntryImpl[3];

			array[0] = (KBFeedbackEntry)objArray[0];
			array[1] = (KBFeedbackEntry)objArray[1];
			array[2] = (KBFeedbackEntry)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public KBFeedbackEntry findByA_U(long articleResourcePrimKey, long userId)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = fetchByA_U(articleResourcePrimKey,
				userId);

		if (kbFeedbackEntry == null) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(", ");
			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeedbackEntryException(msg.toString());
		}

		return kbFeedbackEntry;
	}

	public KBFeedbackEntry fetchByA_U(long articleResourcePrimKey, long userId)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "fetchByA_U";
		String[] finderParams = new String[] {
				Long.class.getName(), Long.class.getName()
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Long(userId)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("userId = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(userId);

				List<KBFeedbackEntry> list = q.list();

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				if (list.size() == 0) {
					return null;
				}
				else {
					return list.get(0);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			List<KBFeedbackEntry> list = (List<KBFeedbackEntry>)result;

			if (list.size() == 0) {
				return null;
			}
			else {
				return list.get(0);
			}
		}
	}

	public List<KBFeedbackEntry> findByA_V(long articleResourcePrimKey, int vote)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByA_V";
		String[] finderParams = new String[] {
				Long.class.getName(), Integer.class.getName()
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Integer(vote)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("vote = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(vote);

				List<KBFeedbackEntry> list = q.list();

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public List<KBFeedbackEntry> findByA_V(long articleResourcePrimKey,
		int vote, int start, int end) throws SystemException {
		return findByA_V(articleResourcePrimKey, vote, start, end, null);
	}

	public List<KBFeedbackEntry> findByA_V(long articleResourcePrimKey,
		int vote, int start, int end, OrderByComparator obc)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findByA_V";
		String[] finderParams = new String[] {
				Long.class.getName(), Integer.class.getName(),
				
				"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Integer(vote),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("vote = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(vote);

				List<KBFeedbackEntry> list = (List<KBFeedbackEntry>)QueryUtil.list(q,
						getDialect(), start, end);

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public KBFeedbackEntry findByA_V_First(long articleResourcePrimKey,
		int vote, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		List<KBFeedbackEntry> list = findByA_V(articleResourcePrimKey, vote, 0,
				1, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(", ");
			msg.append("vote=" + vote);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry findByA_V_Last(long articleResourcePrimKey,
		int vote, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		int count = countByA_V(articleResourcePrimKey, vote);

		List<KBFeedbackEntry> list = findByA_V(articleResourcePrimKey, vote,
				count - 1, count, obc);

		if (list.size() == 0) {
			StringBuilder msg = new StringBuilder();

			msg.append("No KBFeedbackEntry exists with the key {");

			msg.append("articleResourcePrimKey=" + articleResourcePrimKey);

			msg.append(", ");
			msg.append("vote=" + vote);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFeedbackEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KBFeedbackEntry[] findByA_V_PrevAndNext(long feedbackEntryId,
		long articleResourcePrimKey, int vote, OrderByComparator obc)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = findByPrimaryKey(feedbackEntryId);

		int count = countByA_V(articleResourcePrimKey, vote);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

			query.append("articleResourcePrimKey = ?");

			query.append(" AND ");

			query.append("vote = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("createDate DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleResourcePrimKey);

			qPos.add(vote);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					kbFeedbackEntry);

			KBFeedbackEntry[] array = new KBFeedbackEntryImpl[3];

			array[0] = (KBFeedbackEntry)objArray[0];
			array[1] = (KBFeedbackEntry)objArray[1];
			array[2] = (KBFeedbackEntry)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<KBFeedbackEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<KBFeedbackEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<KBFeedbackEntry> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "findAll";
		String[] finderParams = new String[] {
				"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate DESC");
				}

				Query q = session.createQuery(query.toString());

				List<KBFeedbackEntry> list = (List<KBFeedbackEntry>)QueryUtil.list(q,
						getDialect(), start, end);

				if (obc == null) {
					Collections.sort(list);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<KBFeedbackEntry>)result;
		}
	}

	public void removeByArticleResourcePrimKey(long articleResourcePrimKey)
		throws SystemException {
		for (KBFeedbackEntry kbFeedbackEntry : findByArticleResourcePrimKey(
				articleResourcePrimKey)) {
			remove(kbFeedbackEntry);
		}
	}

	public void removeByUserId(long userId) throws SystemException {
		for (KBFeedbackEntry kbFeedbackEntry : findByUserId(userId)) {
			remove(kbFeedbackEntry);
		}
	}

	public void removeByA_S(long articleResourcePrimKey, int score)
		throws SystemException {
		for (KBFeedbackEntry kbFeedbackEntry : findByA_S(
				articleResourcePrimKey, score)) {
			remove(kbFeedbackEntry);
		}
	}

	public void removeByA_U(long articleResourcePrimKey, long userId)
		throws NoSuchFeedbackEntryException, SystemException {
		KBFeedbackEntry kbFeedbackEntry = findByA_U(articleResourcePrimKey,
				userId);

		remove(kbFeedbackEntry);
	}

	public void removeByA_V(long articleResourcePrimKey, int vote)
		throws SystemException {
		for (KBFeedbackEntry kbFeedbackEntry : findByA_V(
				articleResourcePrimKey, vote)) {
			remove(kbFeedbackEntry);
		}
	}

	public void removeAll() throws SystemException {
		for (KBFeedbackEntry kbFeedbackEntry : findAll()) {
			remove(kbFeedbackEntry);
		}
	}

	public int countByArticleResourcePrimKey(long articleResourcePrimKey)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "countByArticleResourcePrimKey";
		String[] finderParams = new String[] { Long.class.getName() };
		Object[] finderArgs = new Object[] { new Long(articleResourcePrimKey) };

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public int countByUserId(long userId) throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "countByUserId";
		String[] finderParams = new String[] { Long.class.getName() };
		Object[] finderArgs = new Object[] { new Long(userId) };

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("userId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public int countByA_S(long articleResourcePrimKey, int score)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "countByA_S";
		String[] finderParams = new String[] {
				Long.class.getName(), Integer.class.getName()
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Integer(score)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("score = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(score);

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public int countByA_U(long articleResourcePrimKey, long userId)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "countByA_U";
		String[] finderParams = new String[] {
				Long.class.getName(), Long.class.getName()
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Long(userId)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("userId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(userId);

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public int countByA_V(long articleResourcePrimKey, int vote)
		throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "countByA_V";
		String[] finderParams = new String[] {
				Long.class.getName(), Integer.class.getName()
			};
		Object[] finderArgs = new Object[] {
				new Long(articleResourcePrimKey), new Integer(vote)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry WHERE ");

				query.append("articleResourcePrimKey = ?");

				query.append(" AND ");

				query.append("vote = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleResourcePrimKey);

				qPos.add(vote);

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public int countAll() throws SystemException {
		boolean finderClassNameCacheEnabled = KBFeedbackEntryModelImpl.CACHE_ENABLED;
		String finderClassName = KBFeedbackEntry.class.getName();
		String finderMethodName = "countAll";
		String[] finderParams = new String[] {  };
		Object[] finderArgs = new Object[] {  };

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM com.liferay.kb.knowledgebase.model.KBFeedbackEntry");

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public void registerListener(ModelListener listener) {
		List<ModelListener> listeners = ListUtil.fromArray(_listeners);

		listeners.add(listener);

		_listeners = listeners.toArray(new ModelListener[listeners.size()]);
	}

	public void unregisterListener(ModelListener listener) {
		List<ModelListener> listeners = ListUtil.fromArray(_listeners);

		listeners.remove(listener);

		_listeners = listeners.toArray(new ModelListener[listeners.size()]);
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.kb.knowledgebase.model.KBFeedbackEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener> listeners = new ArrayList<ModelListener>();

				for (String listenerClassName : listenerClassNames) {
					listeners.add((ModelListener)Class.forName(
							listenerClassName).newInstance());
				}

				_listeners = listeners.toArray(new ModelListener[listeners.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	private static Log _log = LogFactory.getLog(KBFeedbackEntryPersistenceImpl.class);
	private ModelListener[] _listeners = new ModelListener[0];
}