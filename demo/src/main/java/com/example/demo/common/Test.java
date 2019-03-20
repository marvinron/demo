package com.example.demo.common;


import ch.ethz.ssh2.Connection;
import com.example.demo.wg.myrover.CtrCommond;
import com.example.demo.wg.myrover.HostUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

public class Test {
    /*static {
        try {
            Class<?> cacheClazz = Class.forName("java.lang.Integer$IntegerCache");
            Field cacheField = cacheClazz.getDeclaredField("cache");
            cacheField.setAccessible(true);
            Integer[] cache = (Integer[]) cacheField.get(null); //这里修改为 1 + 1 = 3 cache[2 + 128] = new Integer(3); } catch (Exception e) { e.printStackTrace(); } }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) throws Exception {

        // TODO Auto-generated method stub
        Connection conn = CtrCommond.getConn("192.168.30.48", "root", 22, "root12345");
        System.out.println("CPU型号信息："+HostUtils.getCpuModel(conn));
        System.out.println("物理CPU个数："+HostUtils.getCpuNum(conn));
        System.out.println("每个CPU核数量："+HostUtils.getCpuPerCores(conn));
        System.out.println("系统运行天数："+HostUtils.getSystemDays(conn));
        System.out.println("系统版本信息："+HostUtils.getSystemRelease(conn));
        System.out.println("系统版本详细信息："+HostUtils.getSystemUname(conn));
        System.out.println("cpu Idle使用率："+HostUtils.getCpuState(conn).getIdle());
        System.out.println("磁盘已使用G："+HostUtils.getDfInfo(conn).getUsed());
        System.out.println("磁盘IO状态："+HostUtils.getDiskIoState(conn).getRkBS());
        System.out.println("内存已使用百分比："+HostUtils.getMemState(conn).getUsePer());
        System.out.println("网络吞吐率rxbyt："+HostUtils.getNetIoState(conn).getRxbyt());
        System.out.println("系统一分钟负载："+HostUtils.getSysLoadState(conn).getOneLoad());
        System.out.println("系统TCP active："+HostUtils.getTcpState(conn).getActive());
        //System.out.println("进程2696内存使用率："+HostUtils.getProcessState(conn, "2696").getMemPer());
        System.out.println("系统已加载内核模块："+HostUtils.getLsmodInfo(conn));
        System.out.println("系统密码文件修改时间："+HostUtils.getPasswdFileInfo(conn));
        System.out.println("系统rpc服务开放状态："+HostUtils.getRpcinfo(conn));
        System.out.println("当前系统任务计划："+HostUtils.getCrontab(conn));


    }

    private static void filterFunction(List<String> strings, Predicate<String> condition){

        strings.stream().filter(x->condition.test(x)).forEach(System.out::println);
    }




    public static void swapTwo(Integer a1, Integer b1) throws Exception {
        Field valueField = Integer.class.getDeclaredField("value");
        valueField.setAccessible(true);
        int tempAValue = valueField.getInt(a1);
        valueField.setInt(a1, b1.intValue());
        valueField.setInt(b1, tempAValue);

    }


    /**
     * {@link String}
     *
     * @return
     */
    private static String reverse() {
        StringBuilder sb = new StringBuilder("ab1234567890");
        byte[] val = sb.toString().getBytes();
        int count = 12;
        int n = count - 1;
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            System.out.println("循环的数" + j);
            int k = n - j;
            byte cj = val[j];
            val[j] = val[k];
            val[k] = cj;
        }
        return new String(val);
    }

    private static String reverseMyData(String string) {
        byte[] bytes = string.getBytes();
        int index = string.length() - 1;
        for (int i = (index - 1) >> 1; i >= 0; i--) {
            int k = index - i;
            byte cj = bytes[i];
            bytes[i] = bytes[k];
            bytes[k] = cj;

        }
        return new String(bytes);
    }

    private static String reverseData(String string) {
        char[] chars = string.toCharArray();
//        byte[] bytes = string.getBytes();
        int index = string.length() - 1;
        for (int i = (index - 1) >> 1; i >= 0; i--) {
            int k = index - i;
            char cj = chars[i];
            chars[i] = chars[k];
            chars[k] = cj;

        }
        return new String(chars);
    }

}
