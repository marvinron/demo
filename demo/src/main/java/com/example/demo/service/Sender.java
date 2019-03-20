package com.example.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-14 14:07
 */
@Service("sender")
public class Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    //直连交换机模式
    public void send(String msg){
//        rabbitTemplate.convertAndSend(routigKey,msg);
        rabbitTemplate.convertAndSend("direct","key1",msg);

    }

}
