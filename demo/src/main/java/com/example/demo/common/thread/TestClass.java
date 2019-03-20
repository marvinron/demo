package com.example.demo.common.thread;

import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houlei
 * @DESC:测试hashMap
 * @create 2019-02-14 11:40
 */
public class TestClass {
    private Map<String,Integer> map = new HashMap<>();
    public synchronized void add(String key){
        Integer integer = map.get(key);
        if(integer == null){
            map.put(key,1);
        }else {
            map.put(key,integer+1);
        }


    }
}
