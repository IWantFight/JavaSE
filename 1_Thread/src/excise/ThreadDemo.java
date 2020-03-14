package excise;

import java.security.PrivateKey;

/*
    创建两个分线程，分别遍历100以内的奇偶数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();

    }
}

//思路1：分别创建两个Thread的自类，分别写上不同的run方法
class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + ":" + i);
            }
            if (i % 20 == 0){
                yield();//方法中调用方法，省略的都是yeild.
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(getName() + ":" + i);
            }
        }
    }
}