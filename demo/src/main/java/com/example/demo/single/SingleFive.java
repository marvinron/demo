package com.example.demo.single;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-11 10:45
 */
public class SingleFive {
        private static SingleFive singleFive;
        private SingleFive(){}
        private static class InnerInstance{
            private static final SingleFive SINGLE_FIVE = new SingleFive();
        }

        public static SingleFive getInstance(){
            return InnerInstance.SINGLE_FIVE;
        }
}
