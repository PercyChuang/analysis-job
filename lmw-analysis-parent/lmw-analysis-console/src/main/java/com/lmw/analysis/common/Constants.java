/*
 * Copyright (c) 2015 xiaoniu, Inc. All rights reserved.
 *
 * @author lichunlin https://github.com/springlin2012
 *
 */
package com.lmw.analysis.common;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * 公共常量类
 *
 * Created by moker.li on 2015/07/06.
 * @version 1.0
 */
public class Constants {
    public static class Page {
        public static final int DEFAULT_PAGE = 1;
        public static final int DEFAULT_ROWS = 10;
    }

    /** 产品流水 **/
    public static class ProductBalanceConstant {
        public static final Integer PRODUCT_BALANCE_RECORD_TRAD_TYPE_1 = new Integer(1);// 投资
        public static final Integer PRODUCT_BALANCE_RECORD_TRAD_TYPE_2 = new Integer(2);// 回款
    }

    /** 幂等常量 **/
    public static class IdempotentConstant {
        public static final Integer IDEMPOTENT_STATUS_1 = new Integer(1);// 等待
        public static final Integer IDEMPOTENT_STATUS_2 = new Integer(2);// 处理中
        public static final Integer IDEMPOTENT_STATUS_3 = new Integer(3);// 失败
        public static final Integer IDEMPOTENT_STATUS_4 = new Integer(4);// 完成
    }

    /**
     * 还款类型  1还款，2转让回款(转让人)，3债权回款(投资人)，4募集成功回款，5募集失败回款  6加息券回款 7 理财金 8 浮动标补息回款，9还款服务费
     */
    public static class repayTypeConstant{
    	public static final Integer REPAY_TYPE_ONE= 1;
    	public static final Integer REPAY_TYPE_TWO= 2;
    	public static final Integer REPAY_TYPE_THREE= 3;
    	public static final Integer REPAY_TYPE_FOUR= 4;
    	public static final Integer REPAY_TYPE_FICE= 5;
    	public static final Integer REPAY_TYPE_SIX = 6;
    	public static final Integer REPAY_TYPE_SEVEN = 7;
    	public static final Integer REPAY_TYPE_EIGHT = 8;
    	public static final Integer REPAY_TYPE_NINE = 9;
    	
    }

    /**======================================
     * 0/停止, 1/运行中
     *======================================*/
    public final static String SCHEDULE_JOB_STATE_RUN      =   "1";
    public final static String SCHEDULE_JOB_STATE_STOP     =   "0";
    

    /**
     * 接口状态返回
     */
    public static class ResultState {
        public static final Integer SUCCESS_CODE_0 = new Integer(0);// 成功
        public static final String SUCCESS_CODE_0_MSG = "成功";

        /**
         * Dubbo接口调用异常
         */
        public static final Integer ERROR_CODE_99002 = new Integer(99002);
        public static final String ERROR_CODE_99002_MSG = "SOA 接口调用异常";

        /**
         * 99003/参数异常编码
         */
        public static final Integer ERROR_CODE_99003 = new Integer(99003);

        /**
         * 系统处理异常编码
         */
        public static final Integer ERROR_CODE_99005 = new Integer(99005);

    }

    /**
     * 操作说明
     */
    public static class OperationState {
        public static final String BUY_PRODUCT_INSERT_INVESTRECORD_NAME = "投资";

        public static final String INVESTSUCCESS_REMARK = "购买成功";// 投资成功描述

        public static final String INVESTSUCCESS = "2";// 投资成功

        public static final String INVESTRECORD_TYPE = "TZ";// 投资记录

    }


    /**
     * 会员奖励常量
     */
    public static class MemberAward {

        /**
         * 奖励派发状态: 0/未派发,1/已派发
         */
        public static final Integer STATE_0 = new Integer(0);
        public static final Integer STATE_1 = new Integer(1);

    }


    /**
     * APP消息推送
     */
    public static final int MESSAGE_APP_TYPE_1 = 1;//活期宝赎回
    public static final int MESSAGE_APP_TYPE_2 = 2;//活期宝收益率提升
    public static final int MESSAGE_APP_TYPE_3 = 3;//定期产品到期回款

    
    /**
     *债权常量 //0.转让中，1.转让成功,2.取消转让,3.部分转让,4.转让失败
     */
    public static class BorrowDebtContants{
    	public static final int BORROWDEBT_STATUS_ZERO = 0; 
    	public static final int BORROWDEBT_STATUS_ONE = 1;
    	public static final int BORROWDEBT_STATUS_TWO = 2;
    	public static final int BORROWDEBT_STATUS_THREE = 3;
    	public static final int BORROWDEBT_STATUS_FOUR = 4;
    	
    	public static final int IS_DEBT_TRUE = 1;//1:转让过债权，没有装让债权
    	public static final int IS_DEBT_FALSE = 0;
    	
    	public static final BigDecimal MIN_TENDERED_MONEY = BigDecimal.valueOf(100);
    	public static final BigDecimal INCREASE_TENDERED_MONEY = BigDecimal.valueOf(100);
    	
    }

    
    /**
     *债权常量 (投资表) 转让状态（0未转让，1，转让中，2，部分转让，3，转让完成,4转让失败）
     */
    public static class InvestDebtContants{
    	public static final int INVESTDEBT_STATUS_ZERO = 0; 
    	public static final int INVESTDEBT_STATUS_ONE = 1;
    	public static final int INVESTDEBT_STATUS_TWO = 2;
    	public static final int INVESTDEBT_STATUS_THREE = 3;
    	public static final int INVESTDEBT_STATUS_FOUR = 4;
    	
    }

    
    /**
     *债权常量 
     */
    public static class BorrowContants{
    	/**
    	 * 标的状态-2-作废
    	 */
    	public static final int BORROW_STATUS_RD = -2;
    	/**
    	 * 标的状态-1-删除
    	 */
    	public static final int BORROW_STATUS_D = -1;
    	/**
    	 * 标的状态0-(初始)待审核
    	 */
    	public static final int BORROW_STATUS_0 = 0;
    	/**
    	 *  1-审核失败
    	 */
    	public static final int BORROW_STATUS_1 = 1;
    	/**
    	 * 2-预售 
    	 */
    	public static final int BORROW_STATUS_2 = 2;
    	/**
    	 * 3-(在售)正在招标中
    	 */
    	public static final int BORROW_STATUS_3 = 3;
    	/**
    	 *  4-（售罄）已满标  
    	 */
    	public static final int BORROW_STATUS_4 = 4;
    	/**
    	 * 5-募集中 
    	 */
    	public static final int BORROW_STATUS_5 = 5;
    	/**
    	 * 6-募集失败 
    	 */
    	public static final int BORROW_STATUS_6 = 6;
    	/**
    	 * 7-募集成功 
    	 */
    	public static final int BORROW_STATUS_7 = 7;
    	/**
    	 * 8-下架 
    	 */
    	public static final int BORROW_STATUS_8 = 8;
    	/**
    	 * 9-已经结束 
    	 */
    	public static final int BORROW_STATUS_9 = 9;
    	/**
    	 * 10-定时发售 
    	 */
    	public static final int BORROW_STATUS_10 = 10;
    	/**
    	 * 11-投资中
    	 */
    	public static final int BORROW_STATUS_11 = 11;
    	/**
    	 * 12-计息中
    	 */
    	public static final int BORROW_STATUS_12 = 12;
    	/**
    	 * 13-还款中
    	 */
    	public static final int BORROW_STATUS_13 = 13;
    	/**
    	 * 14-已还款
    	 */
    	public static final int BORROW_STATUS_14 = 14;
    	
    	public static final int IS_DEBT_TRUE = 1;//1:是债权，0不是债权   
    	public static final int IS_DEBT_FALSE = 0;
    	
    	public static final BigDecimal MIN_TENDERED_MONEY = BigDecimal.valueOf(100);
    	public static final BigDecimal INCREASE_TENDERED_MONEY = BigDecimal.valueOf(100);
    	
    }
    
    /**
     * 邮件发送状态 1成功 2 失败
     */
    public static class ContractStatus{
    	public static final int SUCCESS = 1;
    	public static final int FAIL = 2;
    }
    
    /**
     * 邮件配置集合
     */
    public static List<Map<String,String>> EMAIL_PROPERTIES_LIST = new ArrayList<Map<String,String>>();
    
	
	public static void initEmail() throws Exception{
			String serverDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			serverDir +="config/emailConfig.properties";
			Properties property = new Properties();;
			FileInputStream input = new FileInputStream(serverDir);
			property.load(input);
			Map<String,String> map1 = new HashMap<String, String>();
			map1.put("mail_host", property.getProperty("email.mail_host"));
			map1.put("mail_username", property.getProperty("email.mail_username"));
			map1.put("mail_password", property.getProperty("email.mail_password"));
			map1.put("mail_from", property.getProperty("email.mail_from"));
			map1.put("mail_alias", property.getProperty("email.mail_alias"));
			
			Map<String,String> map2 = new HashMap<String, String>();
			map2.put("mail_host", property.getProperty("email.mail_host2"));
			map2.put("mail_username", property.getProperty("email.mail_username2"));
			map2.put("mail_password", property.getProperty("email.mail_password2"));
			map2.put("mail_from", property.getProperty("email.mail_from2"));
			map2.put("mail_alias", property.getProperty("email.mail_alias2"));
			
			Map<String,String> map3 = new HashMap<String, String>();
			map3.put("mail_host", property.getProperty("email.mail_host3"));
			map3.put("mail_username", property.getProperty("email.mail_username3"));
			map3.put("mail_password", property.getProperty("email.mail_password3"));
			map3.put("mail_from", property.getProperty("email.mail_from3"));
			map3.put("mail_alias", property.getProperty("email.mail_alias3"));
			
			EMAIL_PROPERTIES_LIST.add(map1);
			EMAIL_PROPERTIES_LIST.add(map2);
			EMAIL_PROPERTIES_LIST.add(map3);
	}
    
    public static final String PLAT_PUBLISHER = "2";//平台发布人
    
    
    //定期宝产品佣金利率
	public static class CommissionContants {
		public static final String REGULAR_COMMISSION_A = "lmw_regular_commission_a";
		public static final String REGULAR_COMMISSION_B = "lmw_regular_commission_b";
		public static final String REGULAR_COMMISSION_C = "lmw_regular_commission_c";
		public static final String REGULAR_COMMISSION_D = "lmw_regular_commission_d";
		public static final String REGULAR_COMMISSION_S = "lmw_regular_commission_s";
		

	}
	//送红包活动用户注册时间
	public static final String  LMW_REG_USER_TIME ="lmw_reguser_time";
	
	//送红包活动结束时间
	public static final String  LMW_REG_USER_ENDTIME ="lmw_reguser_end_time";
	
	//修改现金券红包发放规则系统参数
	public static final String LMW_INVEST_RETURNS= "lmw_invest_returns";
	
	//注册活动任务类型
	public static class RegActivityContants {
		public static final int TASK_TYPE1 = 1;
		public static final int TASK_TYPE2 = 2;
		public static final int TASK_TYPE3 = 3;
		public static final int TASK_TYPE4 = 4;

	}
	
    /**
     * 还款方式
     * 1-等额本息 2-先息后本还款 3-一次性还本付息 4-等额本金 5-按月付息到期还本月 6-等本等息
     */
    public static class BorrowRepayMode{
    	public static final int BORROW_REPAY_MODE_1 = 1;
    	public static final int BORROW_REPAY_MODE_2 = 2;
    	public static final int BORROW_REPAY_MODE_3 = 3;
    	public static final int BORROW_REPAY_MODE_4 = 4;
    	public static final int BORROW_REPAY_MODE_5 = 5;
    	public static final int BORROW_REPAY_MODE_6 = 6;
    }
	
	// 自动队列状态
	public static class BorrowQueueContants {
		public static final int BUS_QUEUE_STATUS0 = 0; // 自动队列中
		public static final int BUS_QUEUE_STATUS1 = 1; // 作废
		public static final int BUS_QUEUE_STATUS2 = 2; // 已上架
	}

	public static class BorrowTypeContants {
		public static final int BORROW_TYPE1 = 1; // 定期宝
		public static final int BORROW_TYPE2 = 2; // 信贷通
		public static final int BORROW_TYPE3 = 3; // 车贷宝
		public static final int BORROW_TYPE4 = 4; // 体验金
		public static final int BORROW_TYPE5 = 5; // 定期宝子项目
		public static final int BORROW_TYPE6 = 6; // 赎楼贷
		public static final int BORROW_TYPE7 = 7; // 新手专享标
		public static final int BORROW_TYPE8 = 8; // 散标
		public static final int BORROW_TYPE9 = 9; // 车贷散标
		public static final int BORROW_TYPE10 = 10; // 定期宝Q-福利标
		public static final int BORROW_TYPE11 = 11; // 易优贷
		public static final int BORROW_TYPE12 = 12; // 月增利
		public static final int BORROW_TYPE13 = 13; // 聚盈利
		public static final int BORROW_TYPE14 = 14; // 速利宝
		public static final int BORROW_TYPE15 = 15; //智盈宝
	}
	
  	/**
  	 * 告警用户微信列表
  	 */
  	public static final String LMW_ALARM_CUSTOMERS_WECAHT="lmw_alarm_customers_wechat";
  	
	/**
	 * 还款日期状态
	 * 
	 * @author zhuxinpu
	 *
	 */
	public static class RepayDateStateContants {
		public static final int REPAYDATESTATE_0 = 0; // 确定
		public static final int REPAYDATESTATE_1 = 1; // 待定
		public static final int REPAYDATESTATE_2 = 2; // 作废
	}

	//我的投资列表（自动投标）
	public static final String LMW_MY_INVEST_LIST_URL = "lmw_my_invest_list_url";

}
