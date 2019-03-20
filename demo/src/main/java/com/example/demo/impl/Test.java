package com.example.demo.impl;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author houlei
 * @DESC:
 * @create 2019-02-27 9:50
 */
public class Test {

    public static String substring(final String input) {
        Map<Integer, Integer> resultCache = new HashMap<>();
        int start = 0;
        int curIndex = -1;
        StringBuilder subStr = new StringBuilder();
        String[] chars = input.split("");
        for (String ch : chars) {
            curIndex++;
            int indexCh = subStr.indexOf(ch);
            if (indexCh == -1) {
                subStr.append(ch);
            }
            else {
                int l = subStr.length();
                subStr = new StringBuilder(subStr.substring(indexCh + 1));
                subStr.append(ch);
                start += indexCh + 1;
            }
            resultCache.put(start, curIndex);
        }
        return processResult(resultCache, chars);
    }

    public static String processResult(Map<Integer, Integer> result, String[] chars) {
        int maxLength = 0;
        int resultStart = 0;
        int resultEnd = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int start = entry.getKey().intValue();
            int end = entry.getValue().intValue();
            int length = end - start + 1;
            if (length > maxLength) {
                maxLength = length;
                resultStart = start;
                resultEnd = end;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = resultStart; i <= resultEnd; i++) {

            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static String reverse(String in) {
        char[] chrs = new char[in.length()];
        for (int i = 0; i < in.length(); i++) {
            chrs[in.length() - i - 1] = in.charAt(i);
        }
        return String.valueOf(chrs);
    }

    public static  <T> List<T> reverse(List<T> list) {

        Stack<T> stack = new Stack<>();
        list.forEach(stack::push);
        List<T> reversed = new LinkedList<>();
        while (!stack.isEmpty()) {
            reversed.add(stack.pop());
        }
        return reversed;
    }



    public static void main(String[] args) throws Exception {
//        System.out.println(reverse("asdfghjk"));
        /*List<String> list = Arrays.asList("a","b","c","d");
        List<String> reverseList = reverse(list);
        System.out.println(reverseList.toString());
        reverseList.forEach(System.out::println);*/
       /* double[] nums = {1,2,2,3,4,5};
        DoubleColumn nc = DoubleColumn.create("Test", nums);
//        System.out.print(nc.print());
//        System.out.println(nc.get(2));
        System.out.println(nc.isLessThan(3));
        System.out.println(nc.where(nc.isLessThan(3)).print());*/

        String[] animals = {"bear", "cat", "giraffe"};
        double[] cuteness = {90.1, 84.3, 99.7};

        /*Table cuteAnimals = Table.create("Cute Animals")
                .addColumns(
                        StringColumn.create("Animal types", animals),
                        DoubleColumn.create("rating", cuteness));*/
        /*String s = cuteAnimals.printHtml();
        System.out.println(s);*/
        Table csv = Table.read().csv("E:\\temp\\123.csv");
        int i = csv.columnCount();
        System.out.println("table的count"+i);
        String name = csv.name();
        System.out.println("name=="+name);
        Column<?>[] columns = csv.columnArray();

        Stream.of(columns).forEach(System.out::println);

    }
}
