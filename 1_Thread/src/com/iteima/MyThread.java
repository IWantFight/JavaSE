package com.iteima;
/*
    1、创建多线程的第一种方式
        1）、创建Thread的子类，并重写run方法。
        2）、创建Thread子类对象，并用该对象调用start方法
      注意：1）、每多创建一个线程，就要重新创建一个Thread子类对象
            2）、不能直接调用run方法。

 */
public class MyThread {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        myThread1.start();
        myThread2.start();
        for (int i = 0;i<100;i++){
            if (i % 2 ==0){
                System.out.println(i+"main");

            }
        }
    }
}
class MyThread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0;i<100;i++){
            if (i % 2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}