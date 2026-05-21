package com.example.order;

import com.example.order.clients.UserClient;
import com.example.order.mapper.FundNvlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class OrderApplicationTests {

    @Autowired
    private FundNvlMapper fundNvlMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        String queueName = "simple.queue";
        String msg = "hello,amqp";
        rabbitTemplate.convertAndSend("fanout","china.1", "fanout交换机测试");

    }

    @Test
    void contextLoads2() {
        String queueName = "simple.queue2";
        String msg = "hello,amqp";
        rabbitTemplate.convertAndSend(queueName,"hello2");
    }

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","王迪");
        Object name = valueOperations.get("name");
        System.out.println("name = " + name.toString());
    }

}
