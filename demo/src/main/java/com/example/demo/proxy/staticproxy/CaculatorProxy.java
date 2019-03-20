package com.example.demo.proxy.staticproxy;

import java.util.Map;

/**
 * @author houlei
 * @DESC:
 * @create 2019-02-15 15:43
 */
public class CaculatorProxy implements CalculatorInterface {
    private CalculatorInterface calculatorInterface;

    public CaculatorProxy(CalculatorInterface calculatorInterface) {
        this.calculatorInterface = calculatorInterface;
    }

    @Override
    public int add(int a, int b) {
        return calculatorInterface.add(a, b);
    }

    public static void main(String[] args) {
        CaculatorProxy caculatorProxy = new CaculatorProxy(new CaculatorImpl());
        int add = caculatorProxy.add(2, 3);
        System.out.println(add);

    }
}
