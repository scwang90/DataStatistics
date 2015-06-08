// Copyright (c) 2003-2013, LogMeIn, Inc. All rights reserved.
// This is part of Xively4J library, it is under the BSD 3-Clause license.
package com.simple.toadiot.rtinfosdk.http;

import com.simple.toadiot.rtinfosdk.GwSdkException;

/**
 * Exception condition when executing HTTP requests to API
 * 
 * @author s0pau
 * 
 */
public class HttpException extends GwSdkException {
	
	private static final long serialVersionUID = -3285691804558117907L;

	private Integer statusCode;
	private String errorDetail;

	public HttpException(String msg, int statusCode, String errorDetail) {
		super(msg);
		this.statusCode = statusCode;
		this.errorDetail = errorDetail;
	}

	public HttpException(String msg, Exception e) {
		super(msg, e);
	}

	public String getLocalizedMessage() {
		if (statusCode == null) {
			return super.getLocalizedMessage();
		}

		StringBuilder sb = new StringBuilder(getMessage());
		sb.append("[Status code: ").append(statusCode).append(".");
		if (errorDetail != null && errorDetail.length() > 0) {
			sb.append("; Reason: ").append(errorDetail);
		}
		sb.append("]");
		return sb.toString();
	}

	public int getStatusCode() {
		return statusCode == null ? 0 : statusCode;
	}
}
