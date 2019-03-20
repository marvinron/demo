package com.example.demo.common;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author houlei
 * @DESC:streamDemo
 * @create 2019-02-12 11:04
 */
public class StreamDemo {
    public static void main(String[] args) {
        Function<Integer,String> function = a->a.toString();
         Stream.of(function.apply(10)).forEach(System.out::println);




    }

    public static void count(Integer... numbers) {
        Stream.of(numbers).reduce(Integer::sum).map(String::valueOf).ifPresent(System.out::println);
    }

    private static void sorted(Comparator<Integer> comparator, Integer... numbers) {
        Stream.of(numbers).sorted(comparator).forEach(System.out::println);
    }


}
