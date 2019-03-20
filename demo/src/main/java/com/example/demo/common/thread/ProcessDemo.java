package com.example.demo.common.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-18 9:42
 */
public class ProcessDemo {

    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String name = runtimeMXBean.getName();
        name = name.substring(0,name.lastIndexOf("@"));
        System.out.println(name+"==========");
    }
}
