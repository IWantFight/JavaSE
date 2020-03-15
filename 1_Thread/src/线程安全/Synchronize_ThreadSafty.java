package 线程安全;

/*
在java中，我们通过同步机制来解决线程安全问题。
    1、同步代码块
        Synchronized(同步监视器){//同步监视器俗称锁，任何一个类的对象都可以作为一把锁
            //需要同步的代码（即操作共享数据的方法）
        }
    2、同步方法
        与同步代码块一样，该方法将同步代码块抽象为一个方法，在方法中加上synchronize关键字即可。只不过
        不需要显式声明监视器。
        对于非静态的同步方法，监视器是this
        对于静态的同步方法，监视器是类本身。
            与实现runnable接口不同，监视器为this。对于继承方法，由于有多个对象，所以还需要在方法中加上
            static关键字，保证监视器唯一。监视器为类.class。
 */
public class Synchronize_ThreadSafty {
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

class Ticket1 implements Runnable {

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票！");
                    ticket--;
                } else
                    break;
            }
        }
    }
}
