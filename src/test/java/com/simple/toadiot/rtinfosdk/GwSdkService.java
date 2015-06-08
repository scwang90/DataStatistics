package com.simple.toadiot.rtinfosdk;

import com.simple.toadiot.rtinfosdk.api.IToadiotData;
import com.simple.toadiot.rtinfosdk.api.IToadiotDataWanda;
import com.simple.toadiot.rtinfosdk.impl.ToadiotDataImpl;
import com.simple.toadiot.rtinfosdk.impl.ToadiotDataWandaImpl;

/**
 * 工厂类
 * @author Administrator
 */
public class GwSdkService {

	private static GwSdkService instance;

	private GwSdkService() {
	}
	
	public static GwSdkService instance() {
		if (instance == null) {
			instance = new GwSdkService();
		}
		return instance;
	}
	public IToadiotDataWanda getToadiotDataWanda() {
		// TODO Auto-generated method stub
		return new ToadiotDataWandaImpl();
	}
	public IToadiotData getToadiotData() {
		// TODO Auto-generated method stub
		return new ToadiotDataImpl();
	}
}
