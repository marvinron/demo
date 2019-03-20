package com.example.demo.common.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author houlei
 * @DESC:优化TaskDemo
 * @create 2019-01-10 9:55
 */
public class FutureTaskDemo {
    private ConcurrentHashMap<String,FutureTask<Connection>> taskConcurrentHashMap = new ConcurrentHashMap<>();
    private Connection getConnection(String key) throws ExecutionException, InterruptedException {
        FutureTask<Connection> connectionFutureTask = taskConcurrentHashMap.get(key);
        if(connectionFutureTask != null){
            return connectionFutureTask.get();
        }else {
            //创建一个线程任务
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return createConnection();
                }
            };

            FutureTask<Connection> futureTask = new FutureTask<>(callable);
            FutureTask<Connection> futureTask1 = taskConcurrentHashMap.putIfAbsent(key, futureTask);
            if(futureTask1 == null){
                connectionFutureTask= futureTask1;
                connectionFutureTask.run();
            }


            return connectionFutureTask.get();
        }
    }

    private Connection createConnection(){
        return null;
    }

    public static void main(String[] args) throws Exception {
       while (true){
           Socket clientSocket = new Socket("localhost",8080);

           //向服务器发送数据
           PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
           System.out.println("请输入:");
           String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
           printStream.println(s);
           //读取服务器的数据
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           String s1 = bufferedReader.readLine();
           System.out.println("接收到服务器返回来的数据："+s1);
           if("OK".equals(s1)){
               System.out.println("客户端将关闭连接。。。");
               Thread.sleep(500);
               break;
           }

       }
    }


}
