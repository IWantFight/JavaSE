package excise.生产者消费问题;

import javax.print.attribute.standard.PrinterURI;

/**
 *
 * 需求：生产与消费
 *
 * 但是我的问题是：怎么是消费者1、2轮流消费！！！
 *
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread t1 = new Consumer(clerk);
        Thread t2 = new Consumer(clerk);
        Thread t3 = new producer(clerk);

        t1.setName("消费者1");
        t2.setName("消费者2");
        t3.setName("生产者1");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Clerk{

    private int producerNumber;

    public synchronized void produce() {
        if (producerNumber < 20){
            producerNumber++;
            System.out.println(Thread.currentThread().getName()+"生产了第"+producerNumber+"个产品");
            notifyAll();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (producerNumber > 0){
            System.out.println(Thread.currentThread().getName()+"消费了第"+producerNumber+"个产品");
            producerNumber--;
            notifyAll();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class producer extends Thread{
    private Clerk clerk;

    public producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者正在生产产品。。。");
        while (true){
            clerk.produce();
        }

    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"正在消费产品。。。");
        while (true){
            clerk.consume();
        }
    }

}

