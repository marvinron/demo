package com.example.demo.controller;

import com.example.demo.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-14 14:10
 */
@RestController
public class RabbitmqController {
    @Autowired
    private Sender sender;
    @RequestMapping("/send/{msg}")
    public String getStr(@PathVariable String msg){
        sender.send(msg);
        return "success";
    }
}
