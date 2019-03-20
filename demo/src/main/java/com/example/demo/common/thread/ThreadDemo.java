package com.example.demo.common.thread;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 10:37
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Study study = new Study();
        Thread thread = new Thread(study);
        thread.start();
        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                thread.interrupt();
            }
            System.out.println("thread -----"+i);
        }

    }

    static class Study implements Runnable {
        private  boolean flag = true;

        public void stop() {
            flag = false;
        }

        @Override
        public void run() {
            while (flag) {
                System.out.println("study thread ....");
            }

        }
    }
}
