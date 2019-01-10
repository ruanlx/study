/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JedisClientTest
 * Author:   Ruanlx
 * Date:     2019/1/7 0007 下午 9:37
 * Description: Jedis 客户端的应用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruanlx.study.redis.jedisclient;

import redis.clients.jedis.*;

/**
 * @author Ruanlx
 * @description: Jedis 客户端的应用
 * @create 2019-01-07 21:37
 */
public class JedisClientTest {

    private Jedis jedis;//非切片客户端连接
    private JedisPool jedisPool;//非分片连接池


    public static JedisPoolConfig initJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20); // 连接池最大连接数，设为0表示无限制 最大分配的对象数
        jedisPoolConfig.setMaxIdle(10); // 连接池最大连接空闲数
        jedisPoolConfig.setMinIdle(5); // 连接池最小连接空闲数
        jedisPoolConfig.setMaxWaitMillis(10000); // 获取连接时最大等待时间，毫秒
        return jedisPoolConfig;
    }

    /** 
     * 创建并获取单个jedis实例
     * @Param: []
     * @return: redis.clients.jedis.Jedis 
     * @Author: Ruanlx 
     */
    public static Jedis genericJedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        return jedis;
    }

    /**
     * 创建jedis池并返回池中一个jedis实例
     * @Param: []
     * @return: redis.clients.jedis.Jedis
     * @Author: Ruanlx
     */
    public static Jedis genericJedisPool() {
        JedisPoolConfig jedisPoolConfig = initJedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.01");
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    public static void main(String[] args) {
        Jedis jedis = genericJedisPool();
        System.out.println("插入String类型的数据");
        jedis.set("string", "string value");
        System.out.println("插入List类型的数据");
        jedis.lpush("list", "list1", "list2","list3");
        System.out.println("插入hash类型的数据");
        jedis.hset("hash", "hashKey","hashvalue");
        System.out.println("插入set类型的数据");
        jedis.sadd("set", "setvalue");
        System.out.println("插入zset类型的数据");
        jedis.zadd("zset", 1L, "zset1");


        System.out.println(jedis.keys("*"));

    }

}
