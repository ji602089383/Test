package com;

/**
 * @author jicai 2023-01-31
 */
public class SynTest {

    public static void main(String[] args) {
        Object o = new Object();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("第一个线程");
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (!isInterrupted()) {
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("第二个线程");
                    while (!isInterrupted()) {
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }

}
