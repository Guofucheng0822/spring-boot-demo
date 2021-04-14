package com.pers.guofucheng.config;

import com.pers.guofucheng.interceptor.CacheKeyGenerator;
import com.pers.guofucheng.interceptor.LockKeyGenerator;
import com.pers.guofucheng.interceptor.LockMethodInterceptor;
import com.pers.guofucheng.utils.RedisLockHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 幂等自动装配
 *
 * @author guofucheng
 * @date 2021/04/02
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class IdempotentAutoConfiguration {

    /**
     * Redis分布式锁
     *
     * @param stringRedisTemplate 字符串复述,模板
     * @return {@link RedisLockHelper}
     */
    @Bean("redisLockHelper")
    public RedisLockHelper redisLockHelper(StringRedisTemplate stringRedisTemplate){
        return new RedisLockHelper(stringRedisTemplate);
    }

    /**
     * 缓存键生成器
     *
     * @return {@link CacheKeyGenerator}
     */
    @Bean("cacheKeyGenerator")
    public CacheKeyGenerator cacheKeyGenerator(){
        return new LockKeyGenerator();
    }

    /**
     * 锁方法拦截器
     *
     * @return {@link LockMethodInterceptor}
     */
    @Bean("lockMethodInterceptor")
    public LockMethodInterceptor lockMethodInterceptor(@Qualifier("redisLockHelper") RedisLockHelper redisLockHelper, @Qualifier("cacheKeyGenerator") CacheKeyGenerator cacheKeyGenerator){
        return new LockMethodInterceptor(redisLockHelper,cacheKeyGenerator);
    }
}
