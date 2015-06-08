package com.simple.toadiot.rtinfosdk.model;
/**
 * @Description: 传感器属性值
 * @Author: scwang
 * @Version: V1.0, 2015-3-3 下午5:00:06
 */
public class SensorValueWanda {
	/**
	 * 传感器状态名称
	 */
	private String propertyName = ""; 
	/**
	 * 传感器状态代码
	 */
	private String propertyCode = ""; 
    /**
     * 数据类型
     */
	private String dataType = ""; 
    /**
     * 数据单位
     */
	private String unit = ""; 
    /**
     * 最大值
     */
	private float maxValue = 0f; 
    /**
     * 最小值
     */
	private float minValue = 0f; 
	/**
	 * 当前值
	 */
	private float value = 0f;
    /**
     * 数据状态
     */
	private String status = ""; 
	
	
	public SensorValueWanda() {
		// TODO Auto-generated constructor stub
	}

//	public SensorValue(String propertyName, String propertyCode,
//			String dataType, String unit, float maxValue, float minValue,
//			float value) {
//		super();
//		this.propertyName = propertyName;
//		this.propertyCode = propertyCode;
//		this.dataType = dataType;
//		this.unit = unit;
//		this.maxValue = maxValue;
//		this.minValue = minValue;
//		this.value = value;
//	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public float getMinValue() {
		return minValue;
	}

	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	
}
