package com.pers.guofucheng.controller;

import com.pers.guofucheng.util.RedissLockUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试redisson分布式锁类Controller
 *
 * @author guofucheng
 * @date 2021/02/05
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/redisTest/add/{key}/{value}")
    public String redisAdd(@PathVariable("key") String key, @PathVariable("value") String value) {
        log.info("@redisAdd入参:[{},{}]", key, value);
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @RequestMapping(value = "/redisTest/del/{key}")
    public String redisDel(@PathVariable("key") String key) {
        log.info("@redisDel入参:{}", key);
        Boolean flag = false;
        try {
            flag = redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "移除结果:" + flag;
    }

    @RequestMapping(value = "/redisTest/get/{key}")
    public String redisGet(@PathVariable("key") String key) {
        String s = "";
        try {
            s = redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功:" + s;
    }

    @RequestMapping(value = "/redisTest/setHash/{key}/{key1}/{value1}")
    @ResponseBody
    public String redisSetHash(@PathVariable("key") String key, @PathVariable("key1") String key1, @PathVariable("value1") String value1) {
        try {
            redisTemplate.opsForHash().put(key, key1, value1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @RequestMapping(value = "/redisTest/getHash/{key}")
    @ResponseBody
    public String redisGetHash(@PathVariable("key") String key) {
        List<Object> values = null;
        try {
            values = redisTemplate.opsForHash().values(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功:" + values;
    }

    @RequestMapping(value = "/redissonTest/lock/{key}/{timeout}")
    public String redissonLock(@PathVariable("key") String lockKey, @PathVariable("timeout") long timeout) {
        try {
            // 设置锁时间为10秒，验证并发请求中，第一个请求超时自动在10秒钟之内释放锁，第二个请求在锁自动释放后继续执行请求
            RedissLockUtil.lock(lockKey,10);
            //获取Lock锁，设置锁的名称
//            RedissLockUtil.lock(lockKey);
            //模拟业务处理耗时
            Thread.sleep(1000 * timeout);
            System.out.println("业务处理完毕，耗时（秒）:" + timeout);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedissLockUtil.unlock(lockKey);
        }
        return "锁" + lockKey + "内部耗时（秒）:" + timeout;
    }

    @RequestMapping(value = "/redissonTest/lock2/{key}")
    public String redissonLock2(@PathVariable("key") String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            lock.lock();
            Thread.sleep(10000);
            System.out.println("业务处理完毕!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "已解锁";
    }

}