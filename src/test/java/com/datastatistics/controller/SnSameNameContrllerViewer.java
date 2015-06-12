package com.datastatistics.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.datastatistics.controller.util.RegexpUtils;
import com.datastatistics.dao.SnSameNameDao;
import com.datastatistics.model.SnSameName;
import com.datastatistics.model.entity.CountProvinceEntity;
import com.datastatistics.util.JacksonUtil;
import com.simple.toadiot.rtinfosdk.AppConfig;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler;
import com.simple.toadiot.rtinfosdk.http.DefaultRequestHandler.HttpMethod;
import com.simple.toadiot.rtinfosdk.http.DefaultResponseHandler;
import com.simple.toadiot.rtinfosdk.http.Response;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class SnSameNameContrllerViewer {
	
	@Autowired
	SnSameNameDao sameNameDao;

	public static String URL = "http://zhaoren.idtag.cn/samename/searchName!getProvinces.htm?name=";
	
	DefaultRequestHandler request = DefaultRequestHandler.getInstance();

	@Before
	public void init() {
		DefaultRequestHandler.DEBUG = true;
		DefaultResponseHandler.DEBUG = true;
		DefaultResponseHandler.JSONFRAMEWORK = false;
		AppConfig.setCharset("UTF-16");
	}
	

	@Test
	public void Query() throws HttpException, IOException {
		HttpMethod method = HttpMethod.POST;
		String name = "李建国";//"柯南";
		System.out.println(URLEncoder.encode(name,"UTF-8"));
		//name = URLEncoder.encode(name,"UTF-8");
		Response response = request.doRequest(method , "/SnSameName/Query/"+name ,null,null,null);
		for (Entry<String, String> entry : response.getHeaders().entrySet()) {
			System.out.println("p-"+entry.getKey()+"="+entry.getValue());
		}
		System.out.println(response.getBody());
	}

	@Test
	public void Jsoup() throws HttpException, IOException {
		try {
			SnSameName name = new SnSameName();
			name.setSameName("小美");
			List<CountProvinceEntity> entities = new ArrayList<>();
			String url = URL + URLEncoder.encode(name.getSameName(), "UTF-8");
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			Elements frames = doc.select("li");
			for (Element element : frames) {
				//javascript:getCities('61')
				String data = element.html();
				//System.out.println(data);
				String code = new RegexpUtils("('\\d+')").find(data);
				code = new RegexpUtils("\\d+").find(code);
				String poeple = new RegexpUtils(">（\\d+人）<").find(data);
				poeple = new RegexpUtils("\\d+").find(poeple);
				System.out.println(code+"-"+poeple);
				int ipoeple = Integer.parseInt(poeple);
				if (ipoeple > 0) {
					entities.add(new CountProvinceEntity(Integer.parseInt(code),ipoeple));
				}
			}
			if (entities.size() > 0) {
				name.setCountProvince(JacksonUtil.toJson(entities));
				HttpMethod method = HttpMethod.POST;
				Response response = request.doRequest(method , "/SnSameName/Post",null,name,null);
				for (Entry<String, String> entry : response.getHeaders().entrySet()) {
					System.out.println("p-"+entry.getKey()+"="+entry.getValue());
				}
				System.out.println(response.getBody());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void submit() throws HttpException {
		try {
			HttpMethod method = HttpMethod.POST;
			SnSameName name = new SnSameName();
			name.setSameName("树朾-Viewer-"+new Date().getTime());
			name.setCountProvince("[{e:[22,33]},{e:[22,33]}]");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sameName", "树朾");
			map.put("countProvince", "[{e:[22,33]},{e:[22,33]}]");
			Response response = request.doRequest(method , "/SnSameName/Add",null,name,null);
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				System.out.println("p-"+entry.getKey()+"="+entry.getValue());
			}
			System.out.println(response.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void countCountry() throws Exception {
		List<SnSameName> sameNames = sameNameDao.findAll();
		for (SnSameName snSameName : sameNames) {
			if (snSameName.getCountCountry() == 0) {
				List<CountProvinceEntity> entities = snSameName.getCountProvinceEntitys();
				for (CountProvinceEntity entity : entities) {
					snSameName.setCountCountry(entity.getPoepleCount()+snSameName.getCountCountry());
					sameNameDao.update(snSameName);
				}
			}
		}
	}
	
	@Test
	public void testJson() {
		System.out.println(JacksonUtil.toJson(null));
		System.out.println(JacksonUtil.toObject("null", SnSameName.class));
	}

}
