package com.lh.authority.unit;



/**
 * @author 梁昊
 * @date 2019/5/4
 * @function
 * @editLog
 */
//@Component
public class RedisOperator {
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    private final TimeUnit timeUnit = TimeUnit.DAYS;
//
//    public int getTimeUnit() {
//        return (int) timeUnit.toMillis(1);
//    }
//
//    public boolean writeIntoToken(String clientType, String useId, String useType, String token) {
//        String keyName = String.format("%s%s:%s", clientType, useType, useId);
//        if (token != null) {
//            stringRedisTemplate.opsForValue().set(keyName, token, 600, timeUnit);
//            return true;
//        }
//        return false;
//    }
//
//    public void aa() {
//        String useId = null;
//        String useType = null;
//        String accessToken = null;
//        String clientType = null;
//        String key = String.format("%s%s:%s", useType, clientType, useId);
//        RedisAction redisAction = new RedisAction();
//        redisAction.setStringRedisTemplate(this.stringRedisTemplate);
//        redisAction.saveKeyAndValue(key, accessToken, 1L, TimeUnit.DAYS);
//    }
}
