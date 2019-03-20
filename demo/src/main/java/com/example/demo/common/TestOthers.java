package com.example.demo.common;

import org.jboss.netty.util.internal.ConcurrentHashMap;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author houlei
 * @DESC:
 * @create 2019-01-25 9:47
 */
public class TestOthers {


    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("name","dabai");
        concurrentHashMap.put("id","123");
        concurrentHashMap.put("mobile","123456");
        Collection<String> values = concurrentHashMap.values();
        values.forEach(System.out::println);

//        long l = atomicLong.incrementAndGet();
//        System.out.println(atomicLong.incrementAndGet()+"============");



        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(TestOthers.class).listeners(event->{
            System.out.println("监听到事件 ： " + event.getClass().getSimpleName());
        });
    }
}
