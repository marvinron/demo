package com.example.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author houlei
 * @DESC:spring的源码解析
 * @create 2019-01-28 10:26
 */
public class SpringDemo {
    public static void main(String[] args) {
       /* //配置文件的路径 进行有参构造
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("");

        //获取bean
        SpringDemo bean = classPathXmlApplicationContext.getBean(SpringDemo.class);
        String[] strings = StringUtils.tokenizeToStringArray("1,2,3,4,5", ",");
        Arrays.stream(strings).forEach(System.out::println);*/

        int countxiao = 0;
        int countda = 0;
        int countzhong = 0;
        String str = "(){}[";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                countxiao++;

            } else if (chars[i] == '{') {
                countda++;
            } else if (chars[i] == '[') {
                countzhong++;
            } else if (chars[i] == ')') {
                if (countxiao != 0) {

                    countxiao--;
                }
            } else if (chars[i] == '}') {
                if (countda != 0) {
                    countda--;
                }
            } else if (chars[i] == ']') {
                if (countzhong != 0) {
                    countzhong--;
                }
            }

        }
        if (countxiao == 0 && countda == 0 && countzhong == 0) {

            System.out.println("该表达式正确！");
        }else {
            System.out.println("该表达式错误");
        }

    }
}
