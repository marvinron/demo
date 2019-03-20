package com.example.demo.single;



public class SingleTwo {
    private static final SingleTwo SINGLE_TWO = new SingleTwo();
    private SingleTwo(){}
    public static SingleTwo getInstance(){
        return SINGLE_TWO;
    }
}
