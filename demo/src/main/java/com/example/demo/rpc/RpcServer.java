package com.example.demo.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-14 9:53
 */
public class RpcServer {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();


    public void publisher(final Object service,final int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                EXECUTOR_SERVICE.execute(new ProcessDemoHandler(service,socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
