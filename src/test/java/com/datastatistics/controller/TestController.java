package com.datastatistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datastatistics.model.SnSameName;
import com.datastatistics.model.entity.RestfulEntity;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping(value="RequestBody/{id}")
	public SnSameName RequestBody(@RequestBody SnSameName body){
		return body;
	}

	@ResponseBody
	@RequestMapping(value="ResponseBody/{id}")
	public String ResponseBody(@PathVariable String id,@RequestHeader("Accept-Encoding") String type){
		return "中文-test-"+id+"-"+ type;
	}

	@ResponseBody
	@RequestMapping(value="ResponseBodyProduces/{id}",produces="text/plain;charset=GBK")
	public String ResponseBodyProduces(@PathVariable String id,@RequestHeader("Accept-Encoding") String type){
		return "中文-test-"+id+"-"+ type;
	}

	@ResponseBody
	@RequestMapping(value="RestfulEntity/{id}")
	public Object RestfulEntity(@PathVariable String id,@RequestHeader("Accept-Encoding") String type){
		return RestfulEntity.getSuccess("中文-test-"+id+"-"+ type);
	}
}
