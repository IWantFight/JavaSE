package com.iteima;

import com.sun.tools.javac.Main;

/*
    该类用来说明线程的同步问题
    1、同步代码块
        synchronized(对象){
            //需要被同步的代码块
        }
    2、synchronized可以放在方法声明中，表示整个方法为同步方法
        public synchronized void show(String name){
            ...
        }
    3、
 */
public class TicketDemo {
        public static void main(String[] args) {
        Thread t1 = new Thread(new Ticket());
        t1.setName("线程1");
        Thread t2 = new Thread(new Ticket());
        t2.setName("线程2");
        Thread t3 = new Thread(new Ticket());
        t3.setName("线程3");
        synchronized (t1){
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
class Ticket implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            try {
                if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"售卖了第"
                        +ticket+"张票");
                ticket--;
                Thread.sleep(100);
                } else
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

