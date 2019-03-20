package com.example.demo.proxy.staticproxy;

/**
 * @author houlei
 * @DESC:
 * @create 2019-02-15 15:42
 */
public class CaculatorImpl implements CalculatorInterface {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
