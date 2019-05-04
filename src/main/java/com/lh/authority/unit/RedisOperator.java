package com.lh.authority.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 梁昊
 * @date 2019/5/4
 * @function
 * @editLog
 */
@Component
public class RedisOperator {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private final TimeUnit timeUnit = TimeUnit.DAYS;

    public int getTimeUnit(){
        return (int) timeUnit.toMillis(1);
    }
    public boolean writeIntoToken(String clientType, String useId, String useType, String token){
        String keyName = String.format("%s%s:%s", clientType, useType, useId);
        if (token != null) {
            stringRedisTemplate.opsForValue().set(keyName,token,600,timeUnit);
            return true;
        }
        return false;
    }
}
