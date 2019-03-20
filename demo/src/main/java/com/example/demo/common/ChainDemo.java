package com.example.demo.common;

import java.util.LinkedList;
import java.util.List;

public class ChainDemo {
    public static void main(String[] args) {
        MyExecuteChain myExecuteChain = new MyExecuteChain();
        myExecuteChain.addExecutorChain(new Executor() {
            @Override
            public void execute(ExecutorChain executorChain) {
                System.out.println("hello zhixing ing...");
                executorChain.execute();
            }
        });
        myExecuteChain.addExecutorChain(new Executor() {
            @Override
            public void execute(ExecutorChain executorChain) {
                System.out.println("hello next");
            }
        });
        myExecuteChain.execute();

    }




    //自己实现的执行连
    public static class MyExecuteChain implements ExecutorChain{
        //定义一个方法可以添加连的执行节点
        private List<Executor> list = new LinkedList<>();
        //定义一个pos 指定到那个节点
        int pos;
        public  void addExecutorChain(Executor executor){
            list.add(executor);
        }

        @Override
        public void execute() {
            int position = pos;
            Executor executor = list.get(position);
            pos++;
            executor.execute(this);

        }
    }

    //执行连  执行执行器
    public interface ExecutorChain{
        void execute();
    }

    //执行器 带实现
    public interface Executor{
        void execute(ExecutorChain executorChain);
    }
}
