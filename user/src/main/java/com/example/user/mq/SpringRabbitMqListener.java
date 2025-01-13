package com.example.user.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitMqListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) {
        System.out.println("msg = " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic.queue1"), exchange = @Exchange(name = "topic", type = ExchangeTypes.TOPIC), key = "china.#"))
    public void listenTopicQueue1(String msg) {
        System.out.println("msg = " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic.queue2"), exchange = @Exchange(name = "topic", type = ExchangeTypes.TOPIC), key = "japan.#"))
    public void listenTopicQueue2(String msg) {
        System.out.println("msg = " + msg);
    }
}
