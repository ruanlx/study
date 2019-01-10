/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisPoolConfig
 * Author:   Ruanlx
 * Date:     2019/1/8 0008 下午 12:30
 * Description: Redis 配置参数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruanlx.study.redis.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ruanlx
 * @description: Redis 配置参数
 * @create 2019-01-08 12:30
 */
@ConfigurationProperties(prefix = "redis.config")
public class RedisPoolConfig {

    /** Redis地址 */
    private String host;
    /** Redis端口,默认6379 */
    private Integer port;
    /** 如果没有password，此处不设置值，但这一项要保留 */
    private String password;

    /** 连接池最大连接数，设为0表示无限制 最大分配的对象数 */
    private Integer maxTotal;
    /** 连接池最大连接空闲数 */
    private Integer maxIdle;
    /** 连接池最小连接空闲数 */
    private Integer minIdle;

    /** 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true */
    private String blockWhenExhausted;
    /** 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1 */
    private Integer maxWaitMillis=10000;

    /** 获取一个连接时是否进行有效检测 */
    private Boolean testOnBorrow=true;
    /** 返回一个连接时是否进行有效检测 */
    private Boolean testOnReturn=true;
    /** 连接空闲时是否进行有效检测，默认false */
    private Boolean testWhileIdle=false;

    /** 表示idle object evitor两次扫描之间要sleep的毫秒数 */
    private Integer timeBetweenEvictionRunsMillis=3000;

    /** 表示一个对象至少停留在idle状态的最短时间,这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义 */
    private Integer minEvictableIdleTimeMillis=-1;

    /** 连接空闲的最小时间,达到此值后空闲链接将会被移除,且保留“minIdle”个空闲连接数 */
    /** 如果minEvictableIdleTimeMillis>0，则此项设置无意义，且只有在timeBetweenEvictionRunsMillis大于0时才有意义；*/
    private Integer softMinEvictableIdleTimeMillis=60000;




}
