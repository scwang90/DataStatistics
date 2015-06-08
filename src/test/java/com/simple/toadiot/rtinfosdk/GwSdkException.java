// Copyright (c) 2003-2013, LogMeIn, Inc. All rights reserved.
// This is part of Xively4J library, it is under the BSD 3-Clause license.
package com.simple.toadiot.rtinfosdk;

/**
 * Parent exception from which all exception classes in this library extends.
 * 
 * @author s0pau
 * 
 */
public class GwSdkException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public GwSdkException(String msg, Throwable e)
	{
		super(msg, e);
	}

	public GwSdkException(String msg)
	{
		super(msg);
	}

	@Override
	public String getLocalizedMessage()
	{
		return String.format("%s: exception: %s", super.getMessage(), super.getCause() == null ? "" : super.getCause()
				.getLocalizedMessage());
	}

	@Override
	public synchronized Throwable getCause()
	{
		return super.getCause();
	}
}
