package com.simple.toadiot.rtinfosdk.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CurrentSensorWanda extends DomainObject{

	private String sensorID = "";
	private String status = "";
	private String online = "";
	private Date datetime = new Date();
	
	private Timestamp systemtimesamp;
	
	private List<SensorValueWanda> curValue = new ArrayList<SensorValueWanda>();
	
	public CurrentSensorWanda() {
		// TODO Auto-generated constructor stub
	}

	public String getSensorID() {
		return sensorID;
	}

	public void setSensorID(String sensorID) {
		this.sensorID = sensorID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public List<SensorValueWanda> getCurValue() {
		return curValue;
	}

	public void setCurValue(List<SensorValueWanda> curValue) {
		this.curValue = curValue;
	}
	
	public Timestamp getSystemtimesamp() {
		return systemtimesamp;
	}
	
	public void setSystemtimesamp(Timestamp systemtimesamp) {
		this.systemtimesamp = systemtimesamp;
	}

	@Override
	@JsonIgnore
	public String getId() {
		// TODO Auto-generated method stub
		return sensorID;
	}

	@Override
	@JsonIgnore
	public void setId(String id) {
		// TODO Auto-generated method stub
		sensorID = id;
	}
}
