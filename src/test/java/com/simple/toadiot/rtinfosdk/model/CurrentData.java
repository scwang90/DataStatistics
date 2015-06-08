package com.simple.toadiot.rtinfosdk.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description: 传感器属性值
 * @Author: scwang
 * @Version: V1.0, 2015-3-3 下午5:00:06
 */
public class CurrentData {
	
    private Date dataTime;// 1430098397737,
    private float value;// 当前值 "0.6414191448693151",
    private String status;// 数据状态  "Normal",
    private Timestamp systemTimesamp;// 系统时间戳  1430098397737,
    private String sensorStatus;//传感器状态 "online"
    
    public CurrentData() {
		// TODO Auto-generated constructor stub
	}
    
	public CurrentData(Date dataTime, float value, String status,
			Timestamp systemTimesamp, String sensorStatus) {
		super();
		this.dataTime = dataTime;
		this.value = value;
		this.status = status;
		this.systemTimesamp = systemTimesamp;
		this.sensorStatus = sensorStatus;
	}



	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getSystemTimesamp() {
		return systemTimesamp;
	}

	public void setSystemTimesamp(Timestamp systemTimesamp) {
		this.systemTimesamp = systemTimesamp;
	}

	public String getSensorStatus() {
		return sensorStatus;
	}

	public void setSensorStatus(String sensorStatus) {
		this.sensorStatus = sensorStatus;
	}
    
    
	
}
