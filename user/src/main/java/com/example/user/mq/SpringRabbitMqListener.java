package com.example.user.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SpringRabbitMqListener {



    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "fanout.queue1"), exchange = @Exchange(name = "fanout", type = ExchangeTypes.FANOUT), key = "china.#"))
    public void listenTopicQueue2(String msg) {
        System.out.println("msg = " + msg);
    }
}
