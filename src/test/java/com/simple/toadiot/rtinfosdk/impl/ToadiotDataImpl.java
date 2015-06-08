package com.simple.toadiot.rtinfosdk.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.simple.toadiot.rtinfosdk.api.IToadiotData;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler.HttpMethod;
import com.simple.toadiot.rtinfosdk.http.Response;
import com.simple.toadiot.rtinfosdk.model.CurrentSensor;

/**
 * 
 * @author Administrator
 */
public class ToadiotDataImpl extends AbstractRequester implements IToadiotData{

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
	public String dataHistory(String userkey,String propertyID,Date startTime,Date endTime,long interval) throws Exception{
		Map<String, String> headers = userkeyHeader(userkey);
		String path = "/data/history/"+propertyID;
		HttpMethod method = HttpMethod.POST;
		Map<String,Object> params = new LinkedHashMap<String, Object>();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("interval", interval);
		Response response = requestHandler.doRequest(method , path , headers, params);
		return response.getBody();
	}
	/**
	 * 2、获取传感器实时数据
	 * URL: 90.90.90.114:8080/Toad_IOT_Data/data/current/senssor/{sensorid}
	 * TYPE:GET
	 * Param:无
	 * @param userkey
	 * @return
	 * @throws Exception
	 */
	public CurrentSensor dataCurrentSenssor(String userkey,int sensorid) throws Exception{
		Map<String, String> headers = userkeyHeader(userkey);
		String path = "/data/current/senssor/"+sensorid;
		HttpMethod method = HttpMethod.GET;
		Response response = requestHandler.doRequest(method , path , headers);
		return response.getBodyAsObject(CurrentSensor.class);
	}
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
	public CurrentSensor dataCurrentSenssor(String userkey,int sensorid,String propertyCode,int count) throws Exception{
		Map<String, String> headers = userkeyHeader(userkey);
		HttpMethod method = HttpMethod.GET;
		String path = "/data/current/sensor/"+sensorid+"/"+propertyCode+"/"+count;
		Response response = requestHandler.doRequest(method , path , headers);
//		List<String> strings = response.getBodyAsObjects(String.class);
//		List<CurrentSensor> sensors = new ArrayList<CurrentSensor>();
//		String body = response.getBodyAsObject(String.class);
//		for (String string : strings) {
//			sensors.add(ParserUtil.toConnectedObject(string, CurrentSensor.class));
//		}
//		return sensors;
//		return ParserUtil.toConnectedObjects(body, CurrentSensor.class);
		return response.getBodyAsObject(CurrentSensor.class);
	}
	/**
	 * 4、获取网关状态
	 * URL:90.90.90.114:8080/Toad_IOT_Data/data/current/gateway/{gatewayid}
	 * TYPE:GET
	 * Param:无
	 * @param userkey
	 * @return
	 * @throws Exception
	 */
	public String dataCurrentGateway(String userkey,String gatewayid) throws Exception{
		Map<String, String> headers = userkeyHeader(userkey);
		String path = "/data/current/gateway/"+gatewayid;
		HttpMethod method = HttpMethod.GET;
		Response response = requestHandler.doRequest(method , path , headers);
		return response.getBody();
	}
	
	
}
