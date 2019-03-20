package com.example.demo.proxy.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author houlei
 * @DESC:动态代理
 * @create 2019-02-18 9:08
 */
public class CaculatorHandler implements InvocationHandler {

    Object object;

    public CaculatorHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invokeResult = method.invoke(object, args);
        doAfter();

        return invokeResult;
    }

    private void doBefore() {
        System.out.println("do this before");
    }

    private void doAfter() {
        System.out.println("do this after");
    }

    public static void main(String[] args) throws Exception{
        CalculatorInterface calculator = new CaculatorImpl();
        CaculatorHandler caculatorHandler = new CaculatorHandler(calculator);
        Class<? extends CalculatorInterface> aClass = calculator.getClass();
        System.out.println(aClass.getName()+"==========");
        Method add1 = aClass.getMethod("add", int.class, int.class);
        Object invoke = add1.invoke(calculator, 1, 2);
        System.out.println("+++++"+invoke);
        CaculatorImpl o = (CaculatorImpl)Class.forName("com.example.demo.proxy.staticproxy.CaculatorImpl").newInstance();
        System.out.println(o.add(1,4));
        CalculatorInterface CalculatorInterfaceInstance = (CalculatorInterface) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), caculatorHandler);
        int add = CalculatorInterfaceInstance.add(1, 2);
        System.out.println(add+"=====");
    }
}
