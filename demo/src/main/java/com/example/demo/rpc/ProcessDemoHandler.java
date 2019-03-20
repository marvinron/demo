package com.example.demo.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-14 9:58
 */
public class ProcessDemoHandler implements Runnable {
    private Object service;
    private Socket socket;
    public ProcessDemoHandler(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream= null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object o = objectInputStream.readObject();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
            objectInputStream.close();
            objectOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
