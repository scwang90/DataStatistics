package com.datastatistics.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping("ResponseBody/{id}")
	public String ResponseBody(@PathVariable String id,@RequestHeader("Accept-Encoding") String type){
		return "中文-test-"+id+"-"+ type;
	}
}
