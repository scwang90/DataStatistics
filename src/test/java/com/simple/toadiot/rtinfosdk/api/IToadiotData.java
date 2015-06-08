package com.simple.toadiot.rtinfosdk.api;

import com.simple.toadiot.rtinfosdk.model.CurrentSensor;

/**
 * 
 * @author Administrator
 */
public interface IToadiotData {

	/**
	 * 1、读取历史数据
	 * URL：90.90.90.114:8080/Toad_IOT_Data/data/history/{propertyid}
	 * TYPE:POST
	 * @param userkey
	 * @param propertyID 需要读取属性ID
	 * @param startTime 读取数据开始时间
	 * @param endTime 读取数据结束时间
	 * @param interval 读取时间隔
	 * @return
	 * @throws Exception
	 */
//	public String dataHistory(String userkey,String propertyID,Date startTime,Date endTime,long interval) throws Exception;
	/**
	 * 2、获取传感器实时数据
	 * URL: 90.90.90.114:8080/Toad_IOT_Data/data/current/senssor/{sensorid}
	 * TYPE:GET
	 * Param:无
	 * @param userkey
	 * @return
	 * @throws Exception
	 */
//	public CurrentSensor dataCurrentSenssor(String userkey,int sensorid) throws Exception;
	/**
	 * 3、获取传感器实时数据记录，共1000条
	 * URL:90.90.90.114:8080/Toad_IOT_Data/data/current/senssor/{sensorid}/all
	 * TYPE:GET
	 * Param:无
	 * 国有改
	 * http://222.85.149.5:11111/Toad_IOT_Data-1.0/RESTful/data/current/sensor/4/s4acode/5
	 * @param userkey
	 * @return
	 * @throws Exception
	 */
	public CurrentSensor dataCurrentSenssor(String userkey,int sensorid,String propertyCode,int count) throws Exception;
	/**
	 * 4、获取网关状态
	 * URL:90.90.90.114:8080/Toad_IOT_Data/data/current/gateway/{gatewayid}
	 * TYPE:GET
	 * Param:无
	 * @param userkey
	 * @return
	 * @throws Exception
	 */
//	public String dataCurrentGateway(String userkey,String gatewayid) throws Exception;
	
	
}
