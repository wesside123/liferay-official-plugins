/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.hr.model.impl;

import com.liferay.hr.model.HREmploymentType;
import com.liferay.hr.model.HREmploymentTypeModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the HREmploymentType service. Represents a row in the &quot;HREmploymentType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HREmploymentTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HREmploymentTypeImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HREmploymentTypeImpl
 * @see com.liferay.hr.model.HREmploymentType
 * @see com.liferay.hr.model.HREmploymentTypeModel
 * @generated
 */
public class HREmploymentTypeModelImpl extends BaseModelImpl<HREmploymentType>
	implements HREmploymentTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r employment type model instance should use the {@link com.liferay.hr.model.HREmploymentType} interface instead.
	 */
	public static final String TABLE_NAME = "HREmploymentType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrEmploymentTypeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "code_", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table HREmploymentType (hrEmploymentTypeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table HREmploymentType";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HREmploymentType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HREmploymentType"),
			true);

	public Class<?> getModelClass() {
		return HREmploymentType.class;
	}

	public String getModelClassName() {
		return HREmploymentType.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HREmploymentType"));

	public HREmploymentTypeModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrEmploymentTypeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrEmploymentTypeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrEmploymentTypeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrEmploymentTypeId() {
		return _hrEmploymentTypeId;
	}

	public void setHrEmploymentTypeId(long hrEmploymentTypeId) {
		_hrEmploymentTypeId = hrEmploymentTypeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	public void setCode(String code) {
		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public HREmploymentType toEscapedModel() {
		if (isEscapedModel()) {
			return (HREmploymentType)this;
		}
		else {
			return (HREmploymentType)Proxy.newProxyInstance(HREmploymentType.class.getClassLoader(),
				new Class[] { HREmploymentType.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HREmploymentType.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		HREmploymentTypeImpl hrEmploymentTypeImpl = new HREmploymentTypeImpl();

		hrEmploymentTypeImpl.setHrEmploymentTypeId(getHrEmploymentTypeId());
		hrEmploymentTypeImpl.setGroupId(getGroupId());
		hrEmploymentTypeImpl.setCompanyId(getCompanyId());
		hrEmploymentTypeImpl.setUserId(getUserId());
		hrEmploymentTypeImpl.setUserName(getUserName());
		hrEmploymentTypeImpl.setCreateDate(getCreateDate());
		hrEmploymentTypeImpl.setModifiedDate(getModifiedDate());
		hrEmploymentTypeImpl.setCode(getCode());
		hrEmploymentTypeImpl.setName(getName());
		hrEmploymentTypeImpl.setDescription(getDescription());

		hrEmploymentTypeImpl.resetOriginalValues();

		return hrEmploymentTypeImpl;
	}

	public int compareTo(HREmploymentType hrEmploymentType) {
		long primaryKey = hrEmploymentType.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HREmploymentType hrEmploymentType = null;

		try {
			hrEmploymentType = (HREmploymentType)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrEmploymentType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public void resetOriginalValues() {
		HREmploymentTypeModelImpl hrEmploymentTypeModelImpl = this;

		hrEmploymentTypeModelImpl._originalGroupId = hrEmploymentTypeModelImpl._groupId;

		hrEmploymentTypeModelImpl._setOriginalGroupId = false;

		hrEmploymentTypeModelImpl._originalCode = hrEmploymentTypeModelImpl._code;
	}

	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{hrEmploymentTypeId=");
		sb.append(getHrEmploymentTypeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HREmploymentType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrEmploymentTypeId</column-name><column-value><![CDATA[");
		sb.append(getHrEmploymentTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hrEmploymentTypeId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _originalCode;
	private String _name;
	private String _description;
	private transient ExpandoBridge _expandoBridge;
}