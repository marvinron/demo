package com.example.demo.comparable;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @DESC:Dept比较
 * @create 2019-01-15 10:31
 */
public class DeptDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
//        evaluate(list, n -> n % 2 == 0);
        List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> collect1 = list.stream().map(n -> n + 1).collect(Collectors.toList());
        collect.forEach(System.out::println);
        collect1.forEach(System.out::println);
    }

    @Test
    public void testDept() {

        List<Dept> list = new ArrayList<>();
        list.add(new Dept("2", "研发部", 23));
        list.add(new Dept("2", "总公司", 32));
        list.add(new Dept("2", "总公司", 35));
//        Collections.sort(list);
        list.stream().forEach(System.out::println);
        System.out.println("=================================");
        Collections.sort(list, new Comparator<Dept>() {
            @Override
            public int compare(Dept o1, Dept o2) {
                return o1.compareTo(o2);
            }
        });

        list.forEach(System.out::println);
    }


    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(n -> {
            if (predicate.test(n)) {
                System.out.println("断言的boolen值函数 " + n);
            }
        });

    }


}
