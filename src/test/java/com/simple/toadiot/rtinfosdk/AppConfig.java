package com.simple.toadiot.rtinfosdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: 服务器配置类
 * @Author: scwang
 * @Version: V1.0, 2015-3-4 下午6:58:51
 */
public class AppConfig {

	/**
	 * 编码
	 */
	private static String charset = "UTF-8";
	/**
	 * 服务器接口版本
	 */
	private static String version = "V1.0.0.0";
	/**
	 * 服务器IP
	 */
	private static String ip = "127.0.0.1";
	/**
	 * 服务器端口
	 */
	private static String port = "1234";
	/**
	 * 链接超时
	 */
	private static Integer socketTimeout = 3000;
	/**
	 * 链接超时
	 */
	private static Integer connectionTimeout = 3000;
	/**
	 * 接收类型
	 */
	private static AcceptedMediaType responseMediaType = AcceptedMediaType.json;
	
	/**
	 * @Description: 接收类型
	 * @Author: scwang
	 * @Version: V1.0, 2015-3-6 下午8:24:58
	 */
	public enum AcceptedMediaType {
		json("application/json"), xml("application/xml"), csv("text/html");

		private String contentType;

		private AcceptedMediaType(String contentType) {
			this.contentType = contentType;
		}

		public String getMediaType() {
			return contentType;
		}
	}

//	public static void main(String[] args) {
//		System.out.println(AcceptedMediaType.valueOf("json").contentType);
//	}
//	public static void main(String[] args) {
//		System.out.println(new URIBuilder().setScheme("http").setHost("www.baidu.com:8888").setPath("/123/444"));
//	}
	/**
	 * 静态加载配置文件信息
	 */
	static {
		String path = "config.properties";
		InputStream inputStream = AppConfig.class.getResourceAsStream(path);
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			ip = properties.getProperty("gwsdk.ip");
			port = properties.getProperty("gwsdk.port");
			version = properties.getProperty("gwsdk.version");
			charset = properties.getProperty("gwsdk.charset");
			socketTimeout = Integer.valueOf(properties.getProperty("gwsdk.http.socketTimeout"));
			connectionTimeout = Integer.valueOf(properties.getProperty("gwsdk.http.connectionTimeout"));
		} catch (IOException e) {
			e.printStackTrace();
			// 忽略异常
		}
	}

	public static String getIP() {
		// TODO Auto-generated method stub
		return ip;
	}
	
	public static void setIP(String ip) {
		AppConfig.ip = ip;
	}

	public static String getPort() {
		// TODO Auto-generated method stub
		return port;
	}
	
	public static void setPort(String port) {
		AppConfig.port = port;
	}

	public static String getVersion() {
		// TODO Auto-generated method stub
		return version;
	}
	
	public static void setVersion(String version) {
		AppConfig.version = version;
	}

	public static String getCharset() {
		return charset;
	}
	
	public static void setCharset(String charset) {
		AppConfig.charset = charset;
	}

	public static Integer getSocketTimeout() {
		return socketTimeout;
	}
	
	public static void setSocketTimeout(Integer socketTimeout) {
		AppConfig.socketTimeout = socketTimeout;
	}

	public static Integer getConnectionTimeout() {
		return connectionTimeout;
	}
	
	public static void setConnectionTimeout(Integer connectionTimeout) {
		AppConfig.connectionTimeout = connectionTimeout;
	}
	
	public static AcceptedMediaType getResponseMediaType() {
		return responseMediaType;
	}
	
	public static void setResponseMediaType(AcceptedMediaType responseMediaType) {
		AppConfig.responseMediaType = responseMediaType;
	}
	
	public static String getBaseURI() {
		// TODO Auto-generated method stub
		return getIP() + ":" + getPort();
//		URIBuilder builder = new URIBuilder();
//		builder.setScheme("http");
//		builder.setHost(getIP());
//		builder.setPort(Integer.valueOf(getPort()));
//		builder.setPath("/"+getVersion());
//		return builder.toString();
//		return "http://" + getIP() + ":" + getPort()
//				+ "/"+getVersion();
	}
}
