package com.example.demo.common;




/*class T1 {
    String s() { return "1"; }
}
class T2 extends T1 {
    String s() { return "2"; }
}
class T3 extends T2 {
    String s() { return "3"; }
    void test() {
        System.out.println("s()=\t\t"          + s());//3
        System.out.println("s.super()=\t"      + super.s());//2
        System.out.println("((T2)this).s()=\t" + ((T2)this).s());//3
        System.out.println("((T1)this).s()=\t" + ((T1)this).s());//3
    }
}
class Test2 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.test();
    }
}*/

import java.util.ArrayList;
import java.util.List;

abstract class C<T> {
    abstract T id(T x);
}
class D extends C<String> {
    @Override
    String id(String x){return x; }


}

class TestDemo{
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        C c = new D();
        c.id(new Object());
    }
}
