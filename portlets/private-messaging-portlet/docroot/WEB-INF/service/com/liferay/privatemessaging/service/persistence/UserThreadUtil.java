/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.privatemessaging.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.privatemessaging.model.UserThread;

import java.util.List;

/**
 * The persistence utility for the user thread service. This utility wraps {@link UserThreadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserThreadPersistence
 * @see UserThreadPersistenceImpl
 * @generated
 */
public class UserThreadUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserThread userThread) {
		getPersistence().clearCache(userThread);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static UserThread remove(UserThread userThread)
		throws SystemException {
		return getPersistence().remove(userThread);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserThread update(UserThread userThread, boolean merge)
		throws SystemException {
		return getPersistence().update(userThread, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserThread update(UserThread userThread, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userThread, merge, serviceContext);
	}

	/**
	* Caches the user thread in the entity cache if it is enabled.
	*
	* @param userThread the user thread to cache
	*/
	public static void cacheResult(
		com.liferay.privatemessaging.model.UserThread userThread) {
		getPersistence().cacheResult(userThread);
	}

	/**
	* Caches the user threads in the entity cache if it is enabled.
	*
	* @param userThreads the user threads to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.privatemessaging.model.UserThread> userThreads) {
		getPersistence().cacheResult(userThreads);
	}

	/**
	* Creates a new user thread with the primary key. Does not add the user thread to the database.
	*
	* @param userThreadId the primary key for the new user thread
	* @return the new user thread
	*/
	public static com.liferay.privatemessaging.model.UserThread create(
		long userThreadId) {
		return getPersistence().create(userThreadId);
	}

	/**
	* Removes the user thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userThreadId the primary key of the user thread to remove
	* @return the user thread that was removed
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a user thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread remove(
		long userThreadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence().remove(userThreadId);
	}

	public static com.liferay.privatemessaging.model.UserThread updateImpl(
		com.liferay.privatemessaging.model.UserThread userThread, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userThread, merge);
	}

	/**
	* Finds the user thread with the primary key or throws a {@link com.liferay.privatemessaging.NoSuchUserThreadException} if it could not be found.
	*
	* @param userThreadId the primary key of the user thread to find
	* @return the user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a user thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByPrimaryKey(
		long userThreadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence().findByPrimaryKey(userThreadId);
	}

	/**
	* Finds the user thread with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userThreadId the primary key of the user thread to find
	* @return the user thread, or <code>null</code> if a user thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread fetchByPrimaryKey(
		long userThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userThreadId);
	}

	/**
	* Finds all the user threads where mbThreadId = &#63;.
	*
	* @param mbThreadId the mb thread id to search with
	* @return the matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByMBThreadId(
		long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMBThreadId(mbThreadId);
	}

	/**
	* Finds a range of all the user threads where mbThreadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbThreadId the mb thread id to search with
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @return the range of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByMBThreadId(
		long mbThreadId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMBThreadId(mbThreadId, start, end);
	}

	/**
	* Finds an ordered range of all the user threads where mbThreadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbThreadId the mb thread id to search with
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByMBThreadId(
		long mbThreadId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMBThreadId(mbThreadId, start, end, orderByComparator);
	}

	/**
	* Finds the first user thread in the ordered set where mbThreadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbThreadId the mb thread id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByMBThreadId_First(
		long mbThreadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByMBThreadId_First(mbThreadId, orderByComparator);
	}

	/**
	* Finds the last user thread in the ordered set where mbThreadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbThreadId the mb thread id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByMBThreadId_Last(
		long mbThreadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByMBThreadId_Last(mbThreadId, orderByComparator);
	}

	/**
	* Finds the user threads before and after the current user thread in the ordered set where mbThreadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userThreadId the primary key of the current user thread
	* @param mbThreadId the mb thread id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a user thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread[] findByMBThreadId_PrevAndNext(
		long userThreadId, long mbThreadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByMBThreadId_PrevAndNext(userThreadId, mbThreadId,
			orderByComparator);
	}

	/**
	* Finds all the user threads where userId = &#63; and deleted = &#63;.
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @return the matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByU_D(
		long userId, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_D(userId, deleted);
	}

	/**
	* Finds a range of all the user threads where userId = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @return the range of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByU_D(
		long userId, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_D(userId, deleted, start, end);
	}

	/**
	* Finds an ordered range of all the user threads where userId = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByU_D(
		long userId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_D(userId, deleted, start, end, orderByComparator);
	}

	/**
	* Finds the first user thread in the ordered set where userId = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByU_D_First(
		long userId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByU_D_First(userId, deleted, orderByComparator);
	}

	/**
	* Finds the last user thread in the ordered set where userId = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByU_D_Last(
		long userId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByU_D_Last(userId, deleted, orderByComparator);
	}

	/**
	* Finds the user threads before and after the current user thread in the ordered set where userId = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userThreadId the primary key of the current user thread
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a user thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread[] findByU_D_PrevAndNext(
		long userThreadId, long userId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByU_D_PrevAndNext(userThreadId, userId, deleted,
			orderByComparator);
	}

	/**
	* Finds the user thread where userId = &#63; and mbThreadId = &#63; or throws a {@link com.liferay.privatemessaging.NoSuchUserThreadException} if it could not be found.
	*
	* @param userId the user id to search with
	* @param mbThreadId the mb thread id to search with
	* @return the matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByU_M(
		long userId, long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence().findByU_M(userId, mbThreadId);
	}

	/**
	* Finds the user thread where userId = &#63; and mbThreadId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @param mbThreadId the mb thread id to search with
	* @return the matching user thread, or <code>null</code> if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread fetchByU_M(
		long userId, long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_M(userId, mbThreadId);
	}

	/**
	* Finds the user thread where userId = &#63; and mbThreadId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @param mbThreadId the mb thread id to search with
	* @return the matching user thread, or <code>null</code> if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread fetchByU_M(
		long userId, long mbThreadId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_M(userId, mbThreadId, retrieveFromCache);
	}

	/**
	* Finds all the user threads where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @return the matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByU_R_D(
		long userId, boolean read, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_R_D(userId, read, deleted);
	}

	/**
	* Finds a range of all the user threads where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @return the range of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByU_R_D(
		long userId, boolean read, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_R_D(userId, read, deleted, start, end);
	}

	/**
	* Finds an ordered range of all the user threads where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findByU_R_D(
		long userId, boolean read, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_R_D(userId, read, deleted, start, end,
			orderByComparator);
	}

	/**
	* Finds the first user thread in the ordered set where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByU_R_D_First(
		long userId, boolean read, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByU_R_D_First(userId, read, deleted, orderByComparator);
	}

	/**
	* Finds the last user thread in the ordered set where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a matching user thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread findByU_R_D_Last(
		long userId, boolean read, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByU_R_D_Last(userId, read, deleted, orderByComparator);
	}

	/**
	* Finds the user threads before and after the current user thread in the ordered set where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userThreadId the primary key of the current user thread
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user thread
	* @throws com.liferay.privatemessaging.NoSuchUserThreadException if a user thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.privatemessaging.model.UserThread[] findByU_R_D_PrevAndNext(
		long userThreadId, long userId, boolean read, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		return getPersistence()
				   .findByU_R_D_PrevAndNext(userThreadId, userId, read,
			deleted, orderByComparator);
	}

	/**
	* Finds all the user threads.
	*
	* @return the user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the user threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @return the range of user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the user threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user threads to return
	* @param end the upper bound of the range of user threads to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.privatemessaging.model.UserThread> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user threads where mbThreadId = &#63; from the database.
	*
	* @param mbThreadId the mb thread id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMBThreadId(long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMBThreadId(mbThreadId);
	}

	/**
	* Removes all the user threads where userId = &#63; and deleted = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_D(long userId, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_D(userId, deleted);
	}

	/**
	* Removes the user thread where userId = &#63; and mbThreadId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param mbThreadId the mb thread id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_M(long userId, long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.privatemessaging.NoSuchUserThreadException {
		getPersistence().removeByU_M(userId, mbThreadId);
	}

	/**
	* Removes all the user threads where userId = &#63; and read = &#63; and deleted = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_R_D(long userId, boolean read, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_R_D(userId, read, deleted);
	}

	/**
	* Removes all the user threads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the user threads where mbThreadId = &#63;.
	*
	* @param mbThreadId the mb thread id to search with
	* @return the number of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMBThreadId(long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMBThreadId(mbThreadId);
	}

	/**
	* Counts all the user threads where userId = &#63; and deleted = &#63;.
	*
	* @param userId the user id to search with
	* @param deleted the deleted to search with
	* @return the number of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_D(long userId, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_D(userId, deleted);
	}

	/**
	* Counts all the user threads where userId = &#63; and mbThreadId = &#63;.
	*
	* @param userId the user id to search with
	* @param mbThreadId the mb thread id to search with
	* @return the number of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_M(long userId, long mbThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_M(userId, mbThreadId);
	}

	/**
	* Counts all the user threads where userId = &#63; and read = &#63; and deleted = &#63;.
	*
	* @param userId the user id to search with
	* @param read the read to search with
	* @param deleted the deleted to search with
	* @return the number of matching user threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_R_D(long userId, boolean read, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_R_D(userId, read, deleted);
	}

	/**
	* Counts all the user threads.
	*
	* @return the number of user threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserThreadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserThreadPersistence)PortletBeanLocatorUtil.locate(com.liferay.privatemessaging.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					UserThreadPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(UserThreadPersistence persistence) {
		_persistence = persistence;
	}

	private static UserThreadPersistence _persistence;
}