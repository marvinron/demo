package com.example.demo.common;


import org.apache.poi.ss.formula.functions.T;

import java.util.*;

public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
       List<String> list = Collections.emptyList();
       List<String> list1 = new ArrayList<>();
       list.add("a");
        System.out.println("");


    }

    public static Collection<Integer> of(Integer... values){

        return Collections.unmodifiableList(Arrays.asList(values));
    }
}
