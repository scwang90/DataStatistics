package com.datastatistics.controller.util;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class CharsetUtil {

	@Test
	public void charsetUTF8toISO() throws UnsupportedEncodingException {
		String name = "树朾";
		System.out.println(name);
		name = new String(name.getBytes("UTF-8"),"ISO-8859-1");
		System.out.println(name);
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(name);
	}

	@Test
	public void charsetISO() throws UnsupportedEncodingException {
		String name = "树朾";
		System.out.println(name);
		name = new String(name.getBytes("ISO-8859-1"),"ISO-8859-1");
		System.out.println(name);
	}
}
