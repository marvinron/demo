package com.example.demo.common.thread;

import java.util.Random;

/**
 * @author houlei
 * @DESC:写内容的线程类
 * @create 2019-03-01 11:19
 */
public class WriterThread extends Thread {
    private final Data data;
    private final Random random=new Random();
    public WriterThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for(int i=0;true;i++){
                data.changed("NO."+i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        Data data = new Data("E:\\projects\\demo\\src\\main\\resources\\123.txt","");
        new WriterThread("write thread ",data).start();
        new SaverThread("save thread ",data).start();
    }
}
