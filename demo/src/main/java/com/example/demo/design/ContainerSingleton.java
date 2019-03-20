package com.example.demo.design;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-14 11:45
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,ContainerSingleton> map = new HashMap<>();
    private static void putInstance(String key,ContainerSingleton instance){
        if(StringUtils.isNotBlank(key) && instance != null){
            if(!map.containsKey(key)){
                map.put(key,instance);
            }

        }
    }

    public static ContainerSingleton getInstance(String key){
        return map.get(key);
    }
}
