package com.example.demo.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-14 15:15
 */
@Component
@RabbitListener(queues = "queue1")
public class RabbitMQConsume {

    @RabbitHandler
    public void consume(String key1){
        System.out.println("receiver ："+key1);

    }

}
