package com.example.demo.common.thread;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author houlei
 * @DESC:创建连接 只初始化一次
 * @create 2019-01-10 9:29
 */
public class ConnectionDemo {
    //做缓存
    private Map<String,Connection> map = new HashMap<>();
    //用锁
    private ReentrantLock lock = new ReentrantLock();
    public Connection getConnection(String key){
        try{
            lock.lock();
            if(map.containsKey(key)){
                return map.get(key);
            }else {
                Connection connection = createConnection();
                map.put(key,connection);
                List<String> list = Collections.emptyList();
                return connection;
            }

        }finally {
            lock.unlock();
        }

    }
    private Connection createConnection(){
        return null;
    }
}
