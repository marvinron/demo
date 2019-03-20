package com.example.demo.common.thread;

import java.util.concurrent.Future;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-15 14:20
 */
public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                '}';
    }

    public double getPrice(String product){
        return caculatePrice(product);
    }

    private double caculatePrice(String product) {
        delay();
        return 10*product.charAt(0);

    }

    private void delay() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Future<Double> getSync(){
        return null;

    }
}
