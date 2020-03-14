package com.iteima;

import com.sun.source.tree.WhileLoopTree;

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
public class TicketDemo2 {
    public static void main(String[] args) {
        new Ticket2().start();
        new Ticket2().start();
        new Ticket2().start();
    }
}

class Ticket2 extends Thread{

    /*
    采用Thread类继承的方法，必须加static修饰Ticket,否则创建了三个Ticket2的对象，就会产生
    三个不同的int Ticket;
    但是如果采用Runnable接口的方式就不必采用static修饰，因为三个线程对象都是new Thread(),
    只不过传递进去的参数不一样。
     */

    private static int Ticket = 100;

    @Override
    public void run() {
        while (Ticket>0){
            System.out.println(Thread.currentThread().getName()+"卖了第"+(101-Ticket)+"张票");
            Ticket--;
        }
    }
}

