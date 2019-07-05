package com.gzyijian.cache;

import com.gzyijian.cache.bean.Employee;
import com.gzyijian.cache.mapper.EmployeeMapper;
import com.gzyijian.cache.util.JedisPoolUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.Set;

/**
 * @author zmjiangi
 * @date 2019-6-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

    /**
     * k-v都是对象的
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 操作k-v都是字符串的
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * Redis常见的五大数据类型
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     * stringRedisTemplate.opsForValue()[String（字符串）]
     * stringRedisTemplate.opsForList()[List（列表）]
     * stringRedisTemplate.opsForSet()[Set（集合）]
     * stringRedisTemplate.opsForHash()[Hash（散列）]
     * stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void test01() {
        //给redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

//		stringRedisTemplate.opsForList().leftPush("mylist","1");
//		stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    /**
     * 测试保存对象
     */
    @Test
    public void test02() {
        Employee empById = employeeMapper.getById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        empRedisTemplate.opsForValue().set("emp-01", empById);
    }


    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getById(1);
        System.out.println(empById);
    }

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("192.168.74.130", 6379);

        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");
        jedis.set("k4", "v4");

        System.out.println(jedis.get("k3"));

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println(keys.size());
    }

    @Test
    public void testTransaction() {
        Jedis jedis = new Jedis("192.168.74.130", 6379);

        Transaction transaction = jedis.multi();

        transaction.set("k55", "v55");
        transaction.set("k66", "v66");

//        transaction.exec();

        transaction.discard();
    }

    /**
     * 通俗点讲, watch 命令就是标记一个键，如果标记了键,
     * 在提交事务前如果该键被别人修改过, 那事务就会失败, 这种情况通常可以在程序中重新在尝试一次。
     * <p>
     * 首先标记了键 balance, 然后检查余额是否足够, 不足就取消标记, 并不做扣减。
     * 足够的话, 就启动事务镜像更新操作。
     * <p>
     * 如果在此期间键 balance 被其他人修改, 那在提交事务(执行 exec) 时就会报错,
     * 程序中通常可以铺货这类错误再重新执行一次, 直到成功。
     *
     * @return
     */
    @Test
    public void testWatch() {
        System.out.println(transMethod());
    }


    private boolean transMethod() {
        Jedis jedis = new Jedis("192.168.74.130", 6379);
        // 可用余额
        int balance;

        // 欠额
        int debt;

        // 实刷余额
        int amtToSubtract = 10;

        jedis.watch("balance");

        balance = Integer.parseInt(jedis.get("balance"));

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (balance < amtToSubtract) {
            jedis.unwatch();
            System.out.println("modify");
            return false;
        }

        System.out.println("开启事务");
        Transaction transaction = jedis.multi();

        System.out.println("处理业务逻辑");
        transaction.decrBy("balance", amtToSubtract);
        transaction.incrBy("debt", amtToSubtract);

        System.out.println("提交事务");
        transaction.exec();

        balance = Integer.parseInt(jedis.get("balance"));
        debt = Integer.parseInt(jedis.get("debt"));

        System.out.println("***********" + balance);
        System.out.println("***********" + debt);
        return true;
    }


    @Test
    public void testReplication() {
        Jedis jedisMaster = new Jedis("192.168.74.130", 6379);
        Jedis jedisSlave = new Jedis("192.168.74.130", 6380);
        jedisSlave.slaveof("192.168.74.130", 6379);

        jedisMaster.set("class", "121212");

        String result = jedisSlave.get("class");
        System.out.println(result);
    }

    @Test
    public void testJedisPool() {

        JedisPool jedisPool = JedisPoolUtil.getInstance();
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set("aa", "bb");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.release(jedisPool, jedis);
        }
    }


}
