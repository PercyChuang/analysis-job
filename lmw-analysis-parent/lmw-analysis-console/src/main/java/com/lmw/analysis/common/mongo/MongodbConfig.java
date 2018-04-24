package com.lmw.analysis.common.mongo;

/**
 * 
 * @title TODO
 * @ClassName: MongodbConfig.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhuangpuxiang
 * @date 2017年12月4日
 * @company 深圳利民网金融信息服务有限公司
 */
public class MongodbConfig {
	
	/**
	 * IP地址
	 */
	private String host;
	
	/**
	 *端口号 
	 */
	private int port;
	
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 数据库名 如果没有配置将使用factory中的默认数据库。
	 */
	private String dbName;
	
	/**
	 * 是否要进行权根较验。如果设置了帐号密码就必须要较验
	 */
	private boolean auth = true;

	/**
	 * 超时配置 如果没有配置将使用factory中的默认值
	 */
	private int timeOut;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
}
