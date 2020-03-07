package com.iteima;

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