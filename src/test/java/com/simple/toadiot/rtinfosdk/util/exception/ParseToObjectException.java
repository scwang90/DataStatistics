// Copyright (c) 2003-2013, LogMeIn, Inc. All rights reserved.
// This is part of Xively4J library, it is under the BSD 3-Clause license.
package com.simple.toadiot.rtinfosdk.util.exception;

import com.simple.toadiot.rtinfosdk.GwSdkException;
import com.simple.toadiot.rtinfosdk.model.DomainObject;

/**
 * Exception condition when parsing to {@link DomainObject}
 * 
 * @author s0pau
 * 
 */
public class ParseToObjectException extends GwSdkException
{
	private static final long serialVersionUID = 7105379283948908356L;

	public ParseToObjectException(String msg, Throwable e)
	{
		super(msg, e);
	}

	public ParseToObjectException(String msg)
	{
		super(msg);
	}
}
