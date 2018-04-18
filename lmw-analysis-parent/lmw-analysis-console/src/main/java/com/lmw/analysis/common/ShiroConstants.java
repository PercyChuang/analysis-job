/*
 * Copyright (c) 2014 hytz365, Inc. All rights reserved.
 *
 * @author lichunlin https://github.com/springlin2012
 *
 */
package com.lmw.analysis.common;

/**
 * Shiro常量类
 *
 * @author lcl 2014/11/08.
 * @version 1.0.0
 */
public class ShiroConstants {

    /**
     * ================= Shiro 用户身份 ==================
     */
    public static final String SHIRO_USER_IDENTITY_ADMIN        = "0";
    public static final String SHIRO_USER_IDENTITY_CUSTOMER     = "1";


    /**
     * ================= Shiro ==================
     */
    public static final String KEY_SHIRO_USER_INFO  = "userInfo";
    //用户编号
    public static final String KEY_SHIRO_UID        = "uid";
    //userLoginName
    public static final String KEY_SHIRO_USER_NAME  = "userName";
    //userAs
    public static final String KEY_SHIRO_USER_AS    = "userAs";
    //email
    public static final String KEY_SHIRO_USER_EMAIL = "email";
    //phone
    public static final String KEY_SHIRO_USER_PHONE = "phone";
    //实名认证
    public static final String KEY_SHIRO_USER_REALNAME = "isRealname";
    //是否设置密保问题
    public static final String KEY_SHIRO_QUESTION = "isQuestion";
    //是否修改支付密码
    public static final String KEY_SHIRO_IS_PAYMENTPWD = "isPaymentPwd";

    //最后登录时间
    public static final String KEY_SHIRO_LOGIN_TIME = "loginLastTime";


    //实名认证中文名
    public static final String KEY_SHIRO_AUTH_NAME  = "cname";
    //实名认证身份证
    public static final String KEY_SHIRO_AUTH_ID    = "cid";


    /**
     * ================= 认证状常量 ==================
     */
    public static final String AUTH_STATE_PHONE     = "isNotPhone";

    public static final String AUTH_STATE_REALNAME  = "isNotRealName";
    
    /***
     * =================是否体验金===================
     */
    public static final Integer IS_EXP_N = 0;
    
    public static final Integer IS_EXP_Y = 1;
    /***
     * =================还款是否支付利息===================
     */
    public static final Integer IS_REPAY_N = 0;
    
    public static final Integer IS_REPAY_Y = 1;
    
    /***
     * =================投资表还款状态========================
     */
    public static final Integer INVEST_REPAYMENT_STATUS_N = 1;
    
    public static final Integer INVEST_REPAYMENT_STATUS_Y = 2;
    /***
     * =================还款表还款状态====================
     */
    public static final Integer REPAYMENT_STATUS_N = 0;
    
    public static final Integer REPAYMENT_STATUS_Y = 1;
    /***
     * =================是否募集期利息===================
     */
    public static final Integer IS_COLLECT_Y = 0;
    
    public static final Integer IS_COLLECT_N = 1;
    
    public static final Integer BORROW_STATUS_6 = 6;
    
    
    /***
     * =================还款表还款类型状态  1还款，2转让回款(转让人)，3债权回款(投资人)，4募集成功回款，5募集失败回款,6 加息劵回款 ，7 理财金回款,8月增利补息回款,9服务费====================
     */
    public static final Integer REPAYMENT_REPAY_TYPE_1 = 1;
    public static final Integer REPAYMENT_REPAY_TYPE_2 = 2;
    public static final Integer REPAYMENT_REPAY_TYPE_3 = 3;
    public static final Integer REPAYMENT_REPAY_TYPE_4 = 4;
    public static final Integer REPAYMENT_REPAY_TYPE_5 = 5;
    public static final Integer REPAYMENT_REPAY_TYPE_6 = 6;
    public static final Integer REPAYMENT_REPAY_TYPE_7 = 7;
    public static final Integer REPAYMENT_REPAY_TYPE_8 = 8;
    public static final Integer REPAYMENT_REPAY_TYPE_9 = 9;
    
    /***
     * 投资转让状态类型 转让状态（0未转让，1，转让中，2，部分转让，3，转让完成,4转让失败）
     */
    public static final Integer INVEST_DEBT_STATUS_0 = 0;
    public static final Integer INVEST_DEBT_STATUS_1 = 1;
    public static final Integer INVEST_DEBT_STATUS_2 = 2;
    public static final Integer INVEST_DEBT_STATUS_3 = 3;
    public static final Integer INVEST_DEBT_STATUS_4 = 4;
    
    /***
     * 续投状态 -1-不续投、0-待续投、1-续投中、2-已续投,3续投过期
     */
    public static final Integer IS_CONTINUE_N = -1;
    public static final Integer IS_CONTINUE_0 = 0;
    public static final Integer IS_CONTINUE_1 = 1;
    public static final Integer IS_CONTINUE_2 = 2;
    public static final Integer IS_CONTINUE_3 = 3;
    public static final Integer IS_CONTINUE_4 = 4;
    public static final Integer IS_CONTINUE_5 = 5;
    
    /***
     * 续投类型 0-本息续投、1-本金续投、2-利息续投'
     */
    public static final Integer IS_CONTINUE_MODE_0=0;
    public static final Integer IS_CONTINUE_MODE_1=1;
    public static final Integer IS_CONTINUE_MODE_2=2;
    
    /***
     * 生成PDF合同加签名
     */
    public static String CONTRACT_KEY ="WEB-INF/contract/yunying@liminwang.com_sha1_cn.pfx";
	public static String CONTRACT_PWD ="Mima15090590066";
	public static String CONTRACT_PNG ="WEB-INF/contract/gongzhang.png";
	public static String CONTRACT_PATH ="/data/config/bus/contract/";//临时pdf路径
	public static Integer CONTRACT_IS_DEBT_0=0;
	public static Integer CONTRACT_IS_DEBT_1=1;
	
	public static String CONTRACT_HTML_DEBT ="debt.html";
	public static String CONTRACT_HTML_DQB ="dqb.html";
	public static String CONTRACT_HTML_CARLOAN ="carLoan.html";
	public static String CONTRACT_HTML_YZL_CARLOAN ="yzlCarLoan.html";
	public static String CONTRACT_HTML_CAR_JUJIAN ="cdb_protocol.html";
	public static String CONTRACT_HTML_YZL_CAR_JUJIAN ="yzlProtocol.html";
	public static String CONTRACT_HTML_JYL_CARLOAN ="jylCarLoan.html";
	public static String CONTRACT_HTML_JYL_CAR_JUJIAN ="jylProtocol.html";
	public static String CONTRACT_HTML_SLB_CARLOAN ="slbCarLoan.html";
	public static String CONTRACT_HTML_SLB_CAR_JUJIAN ="slbProtocol.html";
	public static String CONTRACT_HTML_ZYB_JUJIAN ="zybProtocol.html";
	public static String CONTRACT_HTML_ZYB_LOAN ="zybLoan.html";
	public static String CONTRACT_HTML_ZYB_DEBT ="zybDebt.html";
}
