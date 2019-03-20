package com.example.demo.common.pattern;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-12 10:21
 */
public class Test {
    public static void main(String[] args) {
        /*try {
            ZhangSan obj = (ZhangSan)new CglibMeipo().getInstance(ZhangSan.class);
            obj.findLove();
            System.out.println("--------------------------------");
            // System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Account instance = (Account)new AccountProxyFactory().getInstance(new AccountImpl());
        instance.queryAccount();


    }
}
