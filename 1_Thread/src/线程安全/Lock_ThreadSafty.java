package 线程安全;

import java.util.concurrent.locks.ReentrantLock;
/*

 */

public class Lock_ThreadSafty {
    public static void main(String[] args) {
        Ticket1 T = new Ticket1();
        Thread t1 = new Thread(T);
        Thread t2 = new Thread(T);
        Thread t3 = new Thread(T);
        t3.start();
        t1.start();
        t2.start();

    }
}

class Ticket2 implements Runnable {

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            try {
                //
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票！");
                    ticket--;
                } else
                    break;
            }finally {
                //
                lock.unlock();
            }

        }

    }
}
