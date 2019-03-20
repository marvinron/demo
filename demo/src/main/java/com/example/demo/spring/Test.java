package com.example.demo.spring;

import java.util.Stack;

/**
 * @author houlei
 * @DESC:
 * @create 2019-01-29 14:04
 */
public class Test {
    public static void main(String[] args) {
        Stack re = new Stack();
        String str = "[()]{}{[()(]()}";
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '[') {
                re.push(c);
            } else if (c == '(') {
                re.push(c);
            } else if (c == '{') {
                re.push(c);
            } else {
                char pop = (char) re.pop();
                if (pop == '[' && c == ']' || pop == '(' && c == ')' || pop == '{' && c == '}') {
                    flag =true;
                }else{
                    flag =false;
                }
            }
        }
        if(flag){
            System.out.println("匹配");
        }else{
            System.out.println("不匹配");
        }

    }
}
