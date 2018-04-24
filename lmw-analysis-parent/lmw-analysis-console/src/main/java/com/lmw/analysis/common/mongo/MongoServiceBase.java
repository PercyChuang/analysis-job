package com.lmw.analysis.common.mongo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.bson.BsonDocument;
import org.bson.Document;

import com.alibaba.fastjson.JSON;
import com.lmw.p2p.freamwork.mongo.tables.MgConfig;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoServiceBase<T> {
	
	@Resource
	protected MongoFactory mongoFactory;
	
	/**
	 * 外部程序必须要手动关闭MONGOCLIENT
	 * @param collection
	 * @param key
	 * @return
	 */
	protected MgConfig getMgConfig(MongoCollection<Document> collection,String key) {
		try {
			MgConfig config = new MgConfig();
			config.setKey(key);
			String parm = JSON.toJSONString(config);
			BsonDocument filter = BsonDocument.parse(parm);
			Document first = collection.find(filter).first();
			String result = first.toJson();            
			config = JSON.parseObject(result, MgConfig.class);
			return config;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean insertOne(T t) {
		String tableName =t.getClass().getSimpleName();
		char[] charArray = tableName.toCharArray();
		charArray[0] += 32;
		tableName = String.valueOf(charArray);
		MongoClient client = mongoFactory.createMongoDBClientWithURI();
		try {
            MongoDatabase database = client.getDatabase(mongoFactory.getDbName());
            MongoCollection<Document> collection = database.getCollection(tableName);
            String json = JSON.toJSONString(t);
            Document doc = new Document(Document.parse(json));
           collection.insertOne(doc);
        }catch(Exception e){
        	//TODO LOG OR THROWS...
        	return false;
        }
		finally {
            client.close();
        }
		return true;
	}
	
	
	public boolean insertOne(String tableName,Object obj) {
		MongoClient client = mongoFactory.createMongoDBClient();
		try {
            MongoDatabase database = client.getDatabase(mongoFactory.getDbName());
            MongoCollection<Document> collection = database.getCollection(tableName);
            String json = JSON.toJSONString(obj);
            Document doc = new Document(Document.parse(json));
           collection.insertOne(doc);
        }catch(Exception e){
        	//TODO LOG OR THROWS...
        	return false;
        }
		finally {
            client.close();
        }
		return true;
	}
	
	public T findOne(String tableName,String json) {
		MongoClient client = mongoFactory.createMongoDBClient();
		try {
            MongoDatabase database = client.getDatabase(mongoFactory.getDbName());
            MongoCollection<Document> collection = database.getCollection(tableName);
            BsonDocument filter = BsonDocument.parse(json);
            Document first = collection.find(filter).first();
            String json2 = first.toJson();
            Type genType = getClass().getGenericSuperclass();   
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();   
            return (T) JSON.parseObject(json2,(Class)params[0]);
        }catch(Exception e){
        	//TODO LOG OR THROWS...
        	return null;
        }
		finally {
            client.close();
        }
	}
	
}
