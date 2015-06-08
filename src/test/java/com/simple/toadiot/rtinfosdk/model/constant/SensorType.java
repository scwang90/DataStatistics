package com.simple.toadiot.rtinfosdk.model.constant;


/**
 * 传感器类型枚举
 * @Description: SensorType
 * @Author: scwang
 * @Version: V1.0, 2015-3-5 下午1:08:12
 */
public enum SensorType {
	general("general","通用型"),//（通用型传感器） 
	virtual("virtual","虚拟型"),//（虚拟型传感器）   - 6 - / 85 
	electricMeter("electricMeter","电能表"),//（电能表传感器） 
	mutilfunctional("mutilfunctionalElectricMeter","多功能电力仪"),//（多功能电力仪传感器） 
	rs485IOmodule("rs485IOmodule","RS485类型IO"),//（RS485类型IO传感器） 
	rs485Device("rs485Device","RS485 类型数字设备"),//（RS485 类型数字设备传感器） 
	TCPIP_IOmodule("TCPIP-IOmodule","TCP/IP类型IO"),//（TCP/IP类型IO传感器） 
	TCPIP_Device("TCPIP-Device","TCP/IP类型数字设备");//（TCP/IP类型数字设备传感器）
	private String value;
	private String text;
	private SensorType(String value,String text) 
	{
		// TODO Auto-generated constructor stub
		this.text = text;
		this.value = value;
	}
	public String getValue() 
	{
		return value;
	}
	public String getText()
	{
		return text;
	}
	public boolean equalsType(String type)
	{
		// TODO Auto-generated method stub
		return value.equals(type) || text.equals(type);
	}
}
