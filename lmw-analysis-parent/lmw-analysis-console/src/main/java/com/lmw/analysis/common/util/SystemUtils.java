/*
 * Copyright (c) 2015 xiaoniu, Inc. All rights reserved.
 *
 * @author lichunlin https://github.com/springlin2012
 *
 */
package com.lmw.analysis.common.util;

/**
 *
 * 系统工具类
 *
 * Created by moker.li on 2015/07/04.
 * @version 1.0
 * Copyright (c) 深圳利民网金融信息服务有限公司-版权所有
 */
public class SystemUtils {

    /**
     * 部署项目名
     */
    private String sysName = "/analysis-console";

    public String getSystemPath() {
        return sysName;
    }


    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }
}
