package com.example.demo.common.thread;

import java.util.concurrent.RecursiveTask;

/**
 * @author houlei
 * @DESC:ForkJoinService的抽象类
 * @create 2019-03-14 17:27
 */
public abstract class ForkJoinAbstractService<T> extends RecursiveTask<T> {
    @Override
    protected abstract T compute();
}
