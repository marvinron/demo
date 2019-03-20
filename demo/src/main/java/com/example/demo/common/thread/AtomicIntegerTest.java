package com.example.demo.common.thread;




import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest<T> implements Callable {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Object call() throws Exception {
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                atomicInteger.set(atomicInteger.get()+1);
                
            }
        }
        return atomicInteger.get();
    }

  /*  public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<T>> tasks = new ArrayList<>();
    }*/

    @Test
    public void testDemo(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<T>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new AtomicIntegerTest());
        }
        try {
            /*T t = executorService.invokeAny(tasks);
            System.out.println("返回一个创建线程的结果 "+t);*/
            List<Future<T>> futures = executorService.invokeAll(tasks);
            for (int i = 0; i < 5; i++) {
                System.out.println(futures.get(i).get());

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
