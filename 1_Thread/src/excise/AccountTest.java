package excise;

import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        Accont1 acct1 = new Accont1();
        Thread t1 = new Customer(acct1);
        Thread t2 = new Customer(acct1);
        t1.start();
        t2.start();
    }
}

class Accont1 {
    private double balance;
    ReentrantLock reLock = new ReentrantLock();

    public void addMoney(int number) {
        try {
            reLock.lock();
            if (number > 0) {
                balance += number;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为" + balance);
            }
        } finally {
            reLock.unlock();
        }

    }
}

class Customer extends Thread {
    Accont1 acc1 = new Accont1();

    public Customer(Accont1 acc1) {
        this.acc1 = acc1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc1.addMoney(1000);
        }
    }
}
