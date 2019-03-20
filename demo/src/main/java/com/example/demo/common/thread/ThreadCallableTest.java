package com.example.demo.common.thread;

import java.util.concurrent.*;

/**
 * @author houlei
 * @DESC:callable线程
 * @create 2019-01-08 13:35
 */
public class ThreadCallableTest implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(new ThreadCallableTest());
        String s = submit.get();
        System.out.println("======callable的返回字段是 "+s);

    }

    @Override
    public String call() throws Exception {
        return "callable String";
    }
}
