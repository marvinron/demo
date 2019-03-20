package com.example.demo.common;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> s = Optional.of("123");
        String s1 = s.get();
        System.out.println(s1);
        Optional<Double> aDouble = s.map(Double::valueOf);
        Double aDouble1 = aDouble.get();
        System.out.println("======"+aDouble);
        System.out.println("======"+aDouble1);
    }
}
