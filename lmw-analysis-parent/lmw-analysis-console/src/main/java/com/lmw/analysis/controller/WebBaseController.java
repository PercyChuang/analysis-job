package com.lmw.analysis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lmw.analysis.model.UserInfo;
import com.lmw.analysis.service.IUserService;
import com.modest.util.crypto.MD5util;

/**
 * 基础控制类
 * @author lcl 2014/07/30
 * @version 1.0.0
 */
public class WebBaseController extends BaseController
{
    final Logger logger = LoggerFactory.getLogger(WebBaseController.class);

    @Autowired
    private IUserService userService;

    /**
     * 用户支付密码校验
     * @param payPwd
    * @return
            */
    public boolean checkPayPwd(String userName, String payPwd) {

        UserInfo userInfo = userService.findInfoAllByUser(userName);
        if (null != userInfo) {
            if (MD5util.md5(payPwd).equals(userInfo.getPaymentPwd()))
                return true;
        }

        return false;
    }


}
