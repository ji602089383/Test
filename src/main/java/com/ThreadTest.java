package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jicai 2023-01-28
 */
public class ThreadTest {

    /**
     * 测试线程的中断功能
     */
//    public static void main(String[] args) throws InterruptedException {
//        AtomicBoolean contorlLoop = new AtomicBoolean(true);
//
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                while (contorlLoop.get()){
//                    if(!currentThread().isInterrupted()){
//                        System.out.println("内部循环 中断状态： " + currentThread().isInterrupted());
//                    }
//                }
//                System.out.println("结束循环");
//                try {
//                    System.out.println( "内部执行睡眠前检测到的中断状态：" + isInterrupted());
//                    sleep(2000L);
//                    System.out.println("over");
//                } catch (InterruptedException e) {
//                    System.out.println("over eeee " + isInterrupted());
//                }
//            }
//        };
//        thread.start();
//        System.out.println("最开始的中断状态:" + thread.isInterrupted());
//        thread.interrupt();
//        System.out.println("外部执行完中断后 检测到的中断状态:" + thread.isInterrupted());
//        System.out.println("主线程开始睡眠");
//        Thread.sleep(1000L);
//        System.out.println("主线程睡眠结束");
//        System.out.println("外部控制 终止内部循环 开始");
//        contorlLoop.set(false);
//        System.out.println("外部控制 终止内部循环 结束");
//    }

//    /**
//     * 测试线程的wait notify
//     */
//    public static void main(String[] args) {
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("内部run");
//                synchronized (this){
//                    try {
//                        sleep(1000); // 使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("内部加锁成功");
//                    this.notify();
//                    System.out.println("内部释放锁");
//                }
//            }
//        };
//        synchronized (thread){
//            System.out.println("外部拿到锁");
//            thread.start();
//            try {
//                Thread.sleep(1000L);
//                System.out.println("执行线程等待开始");
//                thread.wait();
//                System.out.println("执行线程等待结束");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 线程内部配合中断。
     */
//    public static void main(String[] args) {
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                while (!isInterrupted()){
//                    try {
//                        sleep(1000L);
//                        System.out.println("内部 未被打断");
//                    } catch (InterruptedException e) {
////                        System.out.println("内部 被打断 抛出异常 " + e.toString());
//                        interrupt();
//                        System.out.println("再次中断" + isInterrupted());
//                    }
//                }
//            }
//        };
//        thread.start();
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("外部开始打断");
//        thread.interrupt();
//    }


    /**
     * 线程内外对象锁 造成的阻塞 而且 synchronized是不可中断的
     */
//    public static void main(String[] args) throws InterruptedException {
//        Integer iN = 1;
//
//        Thread[] threads = new Thread[3];
//        threads[0] = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("线程1开始运行");
//                while (!isInterrupted()){
//                    synchronized (iN){
//                        System.out.println("线程1进入锁, 开始等待");
//                        try {
//                            iN.wait();
//                            System.out.println("线程1进入锁， 等待结束");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("线程1释放锁");
//                }
//            }
//        };
//        threads[1] = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("线程2开始运行");
//                while (!isInterrupted()){
//                    synchronized (iN){
//                        System.out.println("线程2进入锁, 开始等待");
//                        try {
//                            iN.wait();
//                            System.out.println("线程2进入锁， 等待结束");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("线程2释放锁");
//                }
//            }
//        };;
//
//        threads[2] = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("线程3开始运行");
//                while (!isInterrupted()){
//                    synchronized (iN){
//                        System.out.println("线程3进入锁, 开始等待");
//                        try {
//                            iN.wait();
//                            System.out.println("线程3进入锁， 等待结束");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("线程3释放锁");
//                }
//            }
//        };
//        threads[0].start();
//        threads[1].start();
//        threads[2].start();
//
//        // 延时500ms查看数组的线程状态，此时都为等待状态。
//        try {
//            Thread.sleep(1000);
//            for (int i = 0; i < threads.length; i++) {
//                System.out.println("第一次 线程状态 "  + i  + " " +  threads[i].getState());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
////        Thread.sleep(2000L);
////        synchronized (iN){
////            iN.notifyAll();
////        }
//
//       Thread outThread = new Thread() {
//            @Override
//            public void run() {
//                synchronized (iN) {
//                    // 延时800ms唤醒锁的其他线程但没有释放锁
//                    try {
//                        sleep(800);
//                        System.out.println("释放线程， 进入锁");
//                        iN.notifyAll();
//                    } catch (InterruptedException e) {
//                    }
//                    System.out.println("释放线程， 释放完毕， 进入无线循环");
//                    while (!isInterrupted()) {
//                    }
//                }
//            };
//        };
//        outThread.start();
//
//        // 延时500ms查看数组的线程状态，此时都为等待状态。
//        try {
//            Thread.sleep(2000);
//            for (int i = 0; i < threads.length; i++) {
//                System.out.println("第三次 线程状态 "  + i  + " " +  threads[i].getState());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        // 在唤醒线程之后中断线程。
//        try {
//            Thread.sleep(500);
//            System.out.println("控制线程中断开始");
//            for (int i = 0; i < threads.length; i++) {
//                threads[i].interrupt();
//            }
//            System.out.println("控制线程中断结束");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // 中断后查看线程数组的线程状态，此时仍然都为等待锁的BLOCKED状态，而不是中断后的顺利终止程序。
//        try {
//            Thread.sleep(500);
//            for (int i = 0; i < threads.length; i++) {
//                System.out.println("第四次 线程状态 "  + i  + " " +  threads[i].getState());
//            }
//            System.out.println();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //查看中断状态
//        try {
//            Thread.sleep(500);
//            for (int i = 0; i < threads.length; i++) {
//                System.out.println("线程中断状态 "  + i  + " " +  threads[i].isInterrupted());
//            }
//            System.out.println();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("外部线程的中断 开始");
//        outThread.interrupt();
//        System.out.println("外部线程的中断 结束");
//    }
}
