package com.simple.toadiot.rtinfosdk.model.constant;


/**
 * 网关类型枚举
 * @Description: GatewayType
 * @Author: scwang
 * @Version: V1.0, 2015-3-5 下午1:08:12
 */
public enum GatewayType {
	general("general","通用型"),//（通用型网关） 
	virtual("virtual","虚拟型"),//（虚拟型网关）   - 6 - / 85 
	electricMeter("electricMeter","电能表"),//（电能表网关） 
	mutilfunctional("mutilfunctionalElectricMeter","多功能电力仪"),//（多功能电力仪网关） 
	rs485IOmodule("rs485IOmodule","RS485类型IO"),//（RS485类型IO网关） 
	rs485Device("rs485Device","RS485 类型数字设备"),//（RS485 类型数字设备网关） 
	TCPIP_IOmodule("TCPIP-IOmodule","TCP/IP类型IO"),//（TCP/IP类型IO网关） 
	TCPIP_Device("TCPIP-Device","TCP/IP类型数字设备");//（TCP/IP类型数字设备网关）
	private String value;
	private String text;
	private GatewayType(String value,String text) 
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
