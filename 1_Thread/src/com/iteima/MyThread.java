package com.iteima;

/*
1、创建多线程的第一种方式
    1）、创建Thread的子类，并重写run方法。
    2）、创建Thread子类对象，并用该对象调用start方法
  *Thread类构造器
        1）、Thread();
        2)、Thread(String name);指定新线程的名字
        3）、Thread(Runnable target);实现runnable接口中的run方法
        4)、Thread(Runnable target，String name)

2、创建多线程的第二种方式-实现runnable接口
    1）、定义子类实现Runnable接口
    2）、重写Runnable接口中的run方法
    3)、通过Thread含参构造器创造线程对象
    4）、将Runnable接口中的子类对象作为实际参数传递给Thread类的构造器中。
    5）、调用Thread的start方法，开启线程

3、Thread类的相关方法：
    start、run、String getName()、setName()、static Thread currentThread()
    static void yeild(释放当前线程的执行权)、join(在线程a中使用b线程调用join方法，
    那么在b线程结束之前，a线程都不会被执行)
    static void sleep(long millis)
    boolean isAlive();

注意：1）、每多创建一个线程，就要重新创建一个Thread子类对象.单个对象多次
    调用start方法会抛出异常。
    2）、不能直接调用run方法。
多线程应用场景：
    1）、程序同时执行多个任务
    2）、程序要实现一些等待的任务。如读写、输入、网络操作
    3）、后台运行程序

 */
public class MyThread {
    public static void main(String[] args) {
        Thread myThread1 = new MyThread1();
        Thread myThread2 = new Thread(new MyThread2());
        myThread1.start();
        myThread2.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "main");
            }
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "Thread:" + i);
            }
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //mainrunnable:8
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "runnable:" + i);
            }
            //Thread.currentThread().getName()的输出对象是main。
        }
    }
}