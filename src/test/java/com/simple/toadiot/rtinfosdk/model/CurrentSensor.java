package com.simple.toadiot.rtinfosdk.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CurrentSensor extends DomainObject{
	
	private String sensorID;//" 4,
	private String propertyCode;//" "s4acode"
    	
	private List<CurrentData> propertyCurrentData = new ArrayList<CurrentData>();
	
	public CurrentSensor() {
		// TODO Auto-generated constructor stub
	}
	
	public CurrentSensor(String sensorID, String propertyCode,
			List<CurrentData> propertyCurrentData) {
		super();
		this.sensorID = sensorID;
		this.propertyCode = propertyCode;
		this.propertyCurrentData = propertyCurrentData;
	}

	public String getSensorID() {
		return sensorID;
	}

	public void setSensorID(String sensorID) {
		this.sensorID = sensorID;
	}

	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public List<CurrentData> getPropertyCurrentData() {
		return propertyCurrentData;
	}

	public void setPropertyCurrentData(List<CurrentData> propertyCurrentData) {
		this.propertyCurrentData = propertyCurrentData;
	}

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
