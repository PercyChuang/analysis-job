package com.lmw.analysis.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.modest.core.util.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 单节点REDIS
 * 
 * @Description:
 * @author chenlin
 * @date 2018年4月5日 下午8:01:45
 */
public class SNRedisUtil implements IRedisCache {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**主机*/
    private String host = null;
    /**端口*/
    private Integer port = null;
    /**密码*/
    private String password = null;
    /**超时时间*/
    private int timeout = 0;
    /**配置*/
    private JedisPoolConfig jedisPoolConfig = null;
	/**连接池*/
    private JedisPool pool = null;
   		
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public JedisPoolConfig getJedisPoolConfig() {
		return jedisPoolConfig;
	}

	public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
		this.jedisPoolConfig = jedisPoolConfig;
	}

	public JedisPool getPool() {
		return pool;
	}

	public void setPool(JedisPool pool) {
		this.pool = pool;
	}
    
	private boolean isSetPassword(){
		if(password == null || password.trim().length() == 0 || "null".equalsIgnoreCase(password)){
    		return false;
    	}else{
    		return true;
    	}
	}
    
    public void init(){
    	// 可以断开重联
    	if(isSetPassword()){	
    		pool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
    	}else{
    		pool = new JedisPool(jedisPoolConfig, host, port, timeout);
    	}
    }
    
	public void close() {
		if(pool != null){
			pool.close();
		}
	}

	public SNRedisUtil() {
		super();
	}

	/**
	 * 从连接中获取连接(不开放此接方法，是基于连接泄漏考虑)
	 */
	private Jedis getJedis() {
		Jedis jedis = pool.getResource();
		return jedis;
	}

	private void closeJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	@Override
	public boolean setnx(String key, String value) {
		Jedis jedis = getJedis();
		try {
			Long result = jedis.setnx(key, value);
			return (result == 1);// 1表示成功
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean expire(String key, int seconds) {
		Jedis jedis = getJedis();
		try {
			long result = jedis.expire(key, seconds);
			return (result == 1);// 1表示成功
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean set(String key, String value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean set(String key, String value, int expireSeconds) {
		Jedis jedis = getJedis();
		try {
			jedis.setex(key, expireSeconds, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean setObject(String key, Object value) {
		Jedis jedis = getJedis();
		try {
			byte[] bytes = SerializeUtil.serialize(value);
			jedis.set(key.getBytes("UTF8"), bytes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean setObject(String key, Object value, int expireSeconds) {
		Jedis jedis = getJedis();
		try {
			byte[] bytes = SerializeUtil.serialize(value);
			jedis.setex(key.getBytes("UTF8"), expireSeconds, bytes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean set(String key, int value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, String.valueOf(value));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean set(String key, long value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, String.valueOf(value));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean set(String key, float value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, String.valueOf(value));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public Integer incr(String key) {
		Jedis jedis = getJedis();
		try {
			return (int) (long) jedis.incr(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean set(String key, double value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, String.valueOf(value));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public Float getFloat(String key) {
		Jedis jedis = getJedis();
		try {
			String strVal = jedis.get(key);
			if(strVal != null){
				return Float.valueOf(strVal);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public Double getDouble(String key) {
		Jedis jedis = getJedis();
		try {
			String strVal = jedis.get(key);
			if(strVal != null){
				return Double.valueOf(strVal);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public Long getLong(String key) {
		Jedis jedis = getJedis();
		try {
			String strVal = jedis.get(key);
			if(strVal != null){
				return Long.valueOf(strVal);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public Integer getInt(String key) {
		Jedis jedis = getJedis();
		try {
			String strVal = jedis.get(key);
			if(strVal != null){
				return Integer.valueOf(strVal);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public String getString(String key) {
		Jedis jedis = getJedis();
		try {
			String val = jedis.get(key);
			return val;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public void lpush(String key, Object obj) {
		Jedis jedis = getJedis();
		try {
			jedis.lpush(key.getBytes(), SerializeUtil.serialize(obj));
		} catch (Exception e) {
			logger.error("Redis is Exception ", e);
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public List<Object> lrange(String key, int start, int end) {
		Jedis jedis = getJedis();
		try {
			List<byte[]> bytes = jedis.lrange(key.getBytes(), start, end);
			List<Object> objects = new ArrayList<Object>();
			if (null != bytes && !bytes.isEmpty()) {
				for (byte[] bits : bytes) {
					objects.add(SerializeUtil.unserialize(bits));
				}
			}
			return objects;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeJedis(jedis);
		}
		return null;
	}

	@Override
	public Object getObject(String key) {
		Jedis jedis = getJedis();
		try {
			byte[] bytes = jedis.get(key.getBytes("UTF8"));
			if(bytes != null){
				return SerializeUtil.unserialize(bytes);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public TreeSet<String> keys(String pattern) {
		Jedis jedis = getJedis();
		try {
			TreeSet<String> keys = new TreeSet<String>();
			keys.addAll(jedis.keys(pattern));
			return keys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean del(String key) {
		Jedis jedis = getJedis();
		try {
			long result = jedis.del(key);
			return (result == 1);// 1表示成功
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public boolean setnx(String key, String value, int seconds) {
		Jedis jedis = getJedis();
		try {
			long result = jedis.setnx(key, value);
			if (result == 1) {// 1表示成功
				if (seconds > 0) {
					jedis.expire(key, seconds);
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public Long hset(String key, String field, String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.hset(key, field, value);
		} catch (Exception e) {
			e.printStackTrace();
			return -1L;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public List<String> hvals(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.hvals(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}
	
	@Override
	public Map<String, String> hgetAll(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.hgetAll(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}
		
	@Override
	public Set<String> hkeys(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.hkeys(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}
	
	@Override
	public boolean hdel(String key, final String... fields) {
		Jedis jedis = getJedis();
		try {
			long result = jedis.hdel(key, fields);
			return (result == 1); //1表示成功
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public void hmset(String key, Map<String, String> hash) {
		Jedis jedis = getJedis();
		try {
			jedis.hmset(key, hash);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeJedis(jedis);
		}
	}

	@Override
	public String getSet(String key, String value){
		Jedis jedis = getJedis();
		try {
			return jedis.getSet(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeJedis(jedis);
		}
	}
	
	@Override
	public IRedisLock newLock(String lockName, int timeoutMsecs, int expireMsecs) {
		return new SNRedisLock(this, lockName, timeoutMsecs, expireMsecs);
	}
	
}