package com.gzyijian.cache.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Objects;

/**
 * @author zmjiangi
 * @date 2019-7-5
 */
public class JedisPoolUtil {

    public static volatile JedisPool instance = null;

    private JedisPoolUtil() {
    }

    public static JedisPool getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (JedisPoolUtil.class) {
                if (Objects.isNull(instance)) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxTotal(1000);
                    jedisPoolConfig.setMaxIdle(32);
                    jedisPoolConfig.setMaxWaitMillis(100 * 1000);
                    jedisPoolConfig.setTestOnBorrow(true);

                    instance = new JedisPool(jedisPoolConfig, "192.168.74.130", 6379);
                }
            }
        }
        return instance;
    }

    public  static  void release(JedisPool jedisPool, Jedis jedis){
        if (Objects.nonNull(jedis)) {
            jedisPool.returnResourceObject(jedis);
        }
    }

}
