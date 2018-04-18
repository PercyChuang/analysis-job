/*
 * Copyright (c) 2014 hytz365, Inc. All rights reserved.
 *
 * @author lichunlin https://github.com/springlin2012
 *
 */
package com.lmw.analysis.controller;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lmw.analysis.model.dto.BaseResponseDTO;
import com.lmw.analysis.service.IUserService;

/**
 *控
 *
 * @author yangyi
 * @version 1.0.0
 */
@Controller
public class MonitorController extends WebBaseController{
    @Resource
    IUserService userService;
    
    @RequestMapping("/monitor")
    @ResponseBody
    public String findBannerList() throws IOException{
    	BaseResponseDTO result = new BaseResponseDTO();
    	try {
    		userService.findAll();
        	result.setCode("0");
        	result.setMsg("success");
            return JSON.toJSONString(result);
		} catch (Exception e) {
			logger.error("test.product.query:",e);
			result.setCode("-1");
        	result.setMsg("fail");
            return JSON.toJSONString(result);
		}
    	
    	
    }

}
