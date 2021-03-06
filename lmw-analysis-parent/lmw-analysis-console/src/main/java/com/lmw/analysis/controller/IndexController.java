/*
 * Copyright (c) 2015 xiaoniu, Inc. All rights reserved.
 *
 * @author lichunlin https://github.com/springlin2012
 *
 */
package com.lmw.analysis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述: 登录操作
 * <p/>
 * 创建人:Ralap
 * <p/>
 * 创建时间: 2015/08/08.
 * <p/>
 * Copyright (c) 深圳利民网金融信息服务有限公司-版权所有
 */
@Controller
@RequestMapping
public class IndexController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/")
    public String layout() {
        return "/home";
    }


    @RequestMapping("/main")
    public String main() {

        return "/home";
    }

    @RequestMapping("/login")
    public String loginPage() {

        return "/login";
    }
    
}
