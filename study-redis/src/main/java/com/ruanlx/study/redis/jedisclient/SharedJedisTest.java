/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SharedJedisTest
 * Author:   Ruanlx
 * Date:     2019/1/9 0009 下午 3:11
 * Description: SharedJedis 分布式redis客户端连接方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruanlx.study.redis.jedisclient;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @description: SharedJedis 分布式redis客户端连接方式
 *
 * @author Ruanlx
 * @create 2019-01-09 15:11
 */
public class SharedJedisTest {

    private ShardedJedis shardedJedis;//切片客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池
}
