package com.datastatistics.controller;

import com.datastatistics.controller.poetry.IPoetry;
import com.datastatistics.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 为你写诗
 * Created by SCWANG on 2015-09-06.
 */
@RestController
@RequestMapping("poetry")
public class PoetryController {

    @Autowired
    IPoetry kernel;

    @RequestMapping("kernel/{type:\\d}/{place:\\d}/{voice:\\d}")
    public Object kernel(@RequestHeader("token") String token,
        @RequestParam String key, @PathVariable int type,
        @PathVariable int place, @PathVariable int voice) throws Exception {
        if(!key.matches("[\\u4E00-\\u9FA5]+")){
            key = new String(key.getBytes("ISO-8859-1"),"UTF-8");
        }
        if(!key.matches("[\\u4E00-\\u9FA5]+")){
            throw new ServiceException("请输入中文");
        }
        kernel.mKey = key;
        kernel.mType = type;
        kernel.mPlace = place;
        kernel.mVoice = voice;
        kernel.checkInput();
        return kernel.versify();
    }
}
