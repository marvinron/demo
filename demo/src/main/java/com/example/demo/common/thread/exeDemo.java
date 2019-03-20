package com.example.demo.common.thread;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-18 11:12
 */
public class exeDemo {
    public static void main(String[] args) {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        if(operatingSystemMXBean.getName().startsWith("windows")){
            try {
                Process calc = Runtime.getRuntime().exec("calc");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
