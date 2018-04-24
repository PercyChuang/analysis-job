package com.lmw.analysis.common.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Component
public class MongoFactory {

	/**
	 * 配置信息
	 */
	@Resource
	private MongodbConfig mongodbConfig;

	/**
	 * 默认库名
	 */
	private static String DEFAULT_DB = "test";

	/**
	 * 默认超时时间 x/毫秒
	 */
	private static int DEFAULT_TIMEOUT = 30000;


	private ServerAddress server;

	/**
	 * 关闭连接对象。注意：使用完毕后，一定要做关闭操作。
	 * 
	 * @param client
	 * @return
	 */
	public static boolean distory(MongoClient client) {
		if (null != client) {
			try {
				client.close();
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 如果要支持集群，在这里扩展
	 */
	@PostConstruct
	public void init() {
		if (org.apache.commons.lang.StringUtils.isBlank(mongodbConfig.getDbName())) {
			mongodbConfig.setDbName(DEFAULT_DB);
		}
		if (0 == mongodbConfig.getTimeOut()) {
			mongodbConfig.setTimeOut(DEFAULT_TIMEOUT);
		}
		if (null == server) {
			server = new ServerAddress(mongodbConfig.getHost(),mongodbConfig.getPort());
		}
	}

	/**
	 * 客取MONGO连接对象
	 * 
	 * @return MongoClient
	 */
	public MongoClient createMongoDBClientWithURI() {
		 MongoClientURI connectionString = new MongoClientURI("mongodb://" + mongodbConfig.getUserName() + ":" + mongodbConfig.getPassWord() + "@" +  server.getHost()+":"+server.getPort() + "/" + mongodbConfig.getDbName());
		return new MongoClient(connectionString);
	}

	/**
	 * 客取MONGO连接对象
	 * 
	 * @return MongoClient
	 */
	public MongoClient createMongoDBClient() {
		List<ServerAddress> seedList = new ArrayList<ServerAddress>();
		seedList.add(server);
		// 构建鉴权信息
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(MongoCredential.createScramSha1Credential(
				mongodbConfig.getUserName(), mongodbConfig.getDbName(),
				mongodbConfig.getPassWord().toCharArray()));
		// 构建操作选项，requiredReplicaSetName属性外的选项根据自己的实际需求配置，默认参数满足大多数场景
		MongoClientOptions options = MongoClientOptions.builder()
				.socketTimeout(mongodbConfig.getTimeOut()).connectionsPerHost(1).build();
		// 可配置requiredReplicaSetName(ReplSetName)集群
		if (!mongodbConfig.isAuth()) {
			return new MongoClient(seedList, options);
		}
		return new MongoClient(seedList, credentials, options);
	}

	public MongodbConfig getMongodbConfig() {
		return mongodbConfig;
	}

	public void setMongodbConfig(MongodbConfig mongodbConfig) {
		this.mongodbConfig = mongodbConfig;
	}

	public String getDbName() {
		return this.mongodbConfig.getDbName();
	}
}
