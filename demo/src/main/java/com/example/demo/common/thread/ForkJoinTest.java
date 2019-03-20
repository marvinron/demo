package com.example.demo.common.thread;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @DESC:ForkJoin测试
 * @create 2019-03-14 17:29
 */
public class ForkJoinTest extends RecursiveTask<List<String>> {

    //定义一个阈值  超过这个进行拆分处理
    private int threadhold = 5;
    //待拆分的list
    private List<String> list;

    private ForkJoinTest(List<String> list, int threadhold) {
        this.list = list;
        this.threadhold = threadhold;

    }

    @Override
    protected List<String> compute() {
        if (list.size() < threadhold) {
            return list.stream().filter(x -> x.contains("a")).collect(Collectors.toList());
            //直接处理
        } else {
            //大于阈值进行拆分
            int middle = list.size()/2;
            //计算出左边的list
            List<String> leftList = list.subList(0,middle);
            List<String> rightList = list.subList(middle,list.size());

            ForkJoinTest forkJoinTest = new ForkJoinTest(leftList,middle);
            forkJoinTest.fork();
            ForkJoinTest forkJoinTest1 = new ForkJoinTest(rightList,middle);
            forkJoinTest1.fork();

            List<String> listResult =  forkJoinTest.join();
            listResult.addAll(forkJoinTest1.join());
            return listResult;


        }

    }



    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        String[] arrStr =of("a","ab","abc","d","e","f","asdf","tyu");
//        String[] arrStr =of("a","ab","abc","dr");
        ForkJoinTest forkJoinTest= new ForkJoinTest(Arrays.asList(arrStr),5);
        ForkJoinTask<List<String>> submit = forkJoinPool.submit(forkJoinTest);
        try {
            List<String> list = submit.get();
            forkJoinPool.shutdown();
            list.stream().forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static  <T> T[] of(T... values){
        return values;
    }
}
