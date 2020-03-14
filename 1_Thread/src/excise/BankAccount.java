package excise;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Cunsomer c = new Cunsomer(acct);
        Thread c1 = new Thread(c);
        Thread c2 = new Thread(c);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();

    }
}

class Account {
    private double balance;
    Object obj = new Object();
    ReentrantLock rtlock = new ReentrantLock();
    public Account(double balance) {
        this.balance = balance;
    }
    //存钱操作

    public void addMoney(int number) {
        rtlock.lock();
        if (number > 0) {
            balance += number;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为" + balance);
        }
        rtlock.unlock();
    }
}

class Cunsomer implements Runnable {
    private Account acct;

    public Cunsomer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        //存钱
        for (int i = 0; i < 3; i++) {
            acct.addMoney(1000);
        }
    }
}