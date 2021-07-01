package com.lance.mybatisplus.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_1{
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    RestTemplate restTemplate;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void testHttps(){
        String url = "https://free-api.heweather.com/v5/forecast?city=CN101080101&key=5c043b56de9f4371b0c7f8bee8f5b75e";
        String resp = restTemplate.getForObject(url, String.class);
        System.out.println(resp);
    }

    @Test
    public void jedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        System.out.println(jedis.keys("*"));
    }
}
