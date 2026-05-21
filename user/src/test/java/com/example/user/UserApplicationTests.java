package com.example.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest(classes = UserApplication.class)
class UserApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;




    @Test
    void test2() throws JsonProcessingException {
        String json = stringRedisTemplate.opsForValue().get("user:1");
        com.example.user.entity.User user = objectMapper.readValue(json, com.example.user.entity.User.class);
        System.out.println("o = " + user);
    }

}
