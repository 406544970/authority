package com.lh.authority.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

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

    public boolean writeIntoToken(String clientType, String useId, String useType, String token){
        String keyName = String.format("%s%s:%s", clientType, useId, useType);
        if (token != null) {
            stringRedisTemplate.opsForValue().set(keyName, token);
            return true;
        }
        return false;
    }
}
