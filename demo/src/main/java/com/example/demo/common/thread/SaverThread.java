package com.example.demo.common.thread;

/**
 * @author houlei
 * @DESC:保存数据的线程类
 * @create 2019-03-01 11:14
 */
public class SaverThread extends Thread {
    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }
    @Override
    public void run() {
        while (true){
            try {
                data.save();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
