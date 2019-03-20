package com.example.demo.common;

import java.util.Observable;
import java.util.Observer;

public  class ObserverDemo {
    public static void main(String[] args) {
        ObserverDemo observerDemo = new ObserverDemo();

        MyObserve myObserve = new MyObserve();
        myObserve.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("张三订阅 "+arg);
            }
        });
        myObserve.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("李四订阅 "+arg);
            }
        });

        myObserve.setChange();
        myObserve.notifyObservers("订阅邮件 hello");

    }

    private static class MyObserve extends Observable {
        public  void setChange(){
            super.setChanged();
        }

    }
}
