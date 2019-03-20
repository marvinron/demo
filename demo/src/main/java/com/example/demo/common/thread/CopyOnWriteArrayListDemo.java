package com.example.demo.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @DESC:CopyOnWriteArrayList读写锁的操作
 * @create 2019-01-10 14:01
 */
public class CopyOnWriteArrayListDemo {

    private static class readTask implements Runnable{
        private List<String> list;

        public readTask(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for(String str:list){
                System.out.println(str);
            }
        }
    }

    private static class WriteTask implements Runnable{
        List<String> list;
        int index;

        public WriteTask(List<String> list, int index) {
            this.list = list;
            this.index = index;
        }

        @Override
        public void run() {
            list.remove(index);
            list.add(index,"wite_"+index);


        }
    }

    public void execute(){
        final int NUm=10;
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < NUm; i++) {
            list.add("main_"+i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUm);
        for (int i = 0; i < NUm; i++) {
            executorService.execute(new readTask(list));
            executorService.execute(new WriteTask(list,i));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListDemo().execute();
    }
}
