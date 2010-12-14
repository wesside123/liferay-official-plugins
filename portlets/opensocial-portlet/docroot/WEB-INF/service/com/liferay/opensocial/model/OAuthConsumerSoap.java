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

package com.liferay.opensocial.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.opensocial.service.http.OAuthConsumerServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.opensocial.service.http.OAuthConsumerServiceSoap
 * @generated
 */
public class OAuthConsumerSoap implements Serializable {
	public static OAuthConsumerSoap toSoapModel(OAuthConsumer model) {
		OAuthConsumerSoap soapModel = new OAuthConsumerSoap();

		soapModel.setOauthConsumerId(model.getOauthConsumerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGadgetId(model.getGadgetId());
		soapModel.setServiceName(model.getServiceName());
		soapModel.setConsumerKey(model.getConsumerKey());
		soapModel.setConsumerSecret(model.getConsumerSecret());
		soapModel.setKeyType(model.getKeyType());
		soapModel.setCallbackUrl(model.getCallbackUrl());
		soapModel.setKeyName(model.getKeyName());

		return soapModel;
	}

	public static OAuthConsumerSoap[] toSoapModels(OAuthConsumer[] models) {
		OAuthConsumerSoap[] soapModels = new OAuthConsumerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OAuthConsumerSoap[][] toSoapModels(OAuthConsumer[][] models) {
		OAuthConsumerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OAuthConsumerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OAuthConsumerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OAuthConsumerSoap[] toSoapModels(List<OAuthConsumer> models) {
		List<OAuthConsumerSoap> soapModels = new ArrayList<OAuthConsumerSoap>(models.size());

		for (OAuthConsumer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OAuthConsumerSoap[soapModels.size()]);
	}

	public OAuthConsumerSoap() {
	}

	public long getPrimaryKey() {
		return _oauthConsumerId;
	}

	public void setPrimaryKey(long pk) {
		setOauthConsumerId(pk);
	}

	public long getOauthConsumerId() {
		return _oauthConsumerId;
	}

	public void setOauthConsumerId(long oauthConsumerId) {
		_oauthConsumerId = oauthConsumerId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getGadgetId() {
		return _gadgetId;
	}

	public void setGadgetId(long gadgetId) {
		_gadgetId = gadgetId;
	}

	public String getServiceName() {
		return _serviceName;
	}

	public void setServiceName(String serviceName) {
		_serviceName = serviceName;
	}

	public String getConsumerKey() {
		return _consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		_consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return _consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		_consumerSecret = consumerSecret;
	}

	public String getKeyType() {
		return _keyType;
	}

	public void setKeyType(String keyType) {
		_keyType = keyType;
	}

	public String getCallbackUrl() {
		return _callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		_callbackUrl = callbackUrl;
	}

	public String getKeyName() {
		return _keyName;
	}

	public void setKeyName(String keyName) {
		_keyName = keyName;
	}

	private long _oauthConsumerId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _gadgetId;
	private String _serviceName;
	private String _consumerKey;
	private String _consumerSecret;
	private String _keyType;
	private String _callbackUrl;
	private String _keyName;
}