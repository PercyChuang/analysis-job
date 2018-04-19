package com.lmw.analysis.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/** 
 * Redis缓存定义  
 * @Description:  
 * @author chenlin  
 * @date 2018年4月5日 下午8:01:45 
 */
public interface IRedisCache {	
	public boolean set(String key, String value);	
	public boolean set(String key, String value, int expireSeconds);
	public boolean set(String key, int value);
	public boolean set(String key, long value);
	public boolean set(String key, float value);
	public boolean set(String key, double value);
	public boolean setObject(String key, Object value);
	public boolean setObject(String key, Object value, int expireSeconds);
	
	public String getString(String key);
	public Integer getInt(String key);
	public Long getLong(String key);
	public Float getFloat(String key);
	public Double getDouble(String key);
	public Object getObject(String key);

	public boolean setnx(String key, String value);
	public boolean setnx(String key, String value, int expireSeconds);	
	
	public void lpush(String key, Object obj);
	public List<Object> lrange(String key, int start, int end);	

	public TreeSet<String> keys(String pattern);
	public Integer incr(String key);
	public boolean expire(String key, int seconds);
	public boolean del(String key);
	
	public Long hset(String key, String field, String value);
	public List<String> hvals(String key);
	public Set<String> hkeys(String key);
	public Map<String, String> hgetAll(String key);
	public boolean hdel(String key, String... fields);
	public void hmset(String key, Map<String, String> hash);
	public String getSet(String key, String value);
	
	
	/**
	 * 获取锁   
	 * @Description: 
	 * @param lockName 锁名称
	 * @param timeoutMsecs 等待毫秒数
	 * @param expireMsecs 失效毫秒数
	 * @return 
	 * @author chenlin  
	 * @date 2018年4月5日 下午9:32:13 
	 */
	public IRedisLock newLock(String lockName, int timeoutMsecs, int expireMsecs);

}