package 线程通信;

/*
    wait:一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
        但是此方法与notify、notifyAll等方法一样，只能出现在同步代码块或者同步方法中。
        三个方法的调用者必须使同步代码块或者同步方法中的监视器。
        由上一句可以推出，=》notify与wait都是定义在object类中，方便任何一个对象都可以充当同步监视器。

*/
public class ThreadCommunication {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    private static int number = 1;

    @Override
    public void run() {
        while (true) {
            //这里千万切记，如果是Thread子类继承的方式，使用this是不行的！！
            //另外出现IllegalMonitorState错误时，表示同步监视器this与notify、wait的调用对象不一致。
            synchronized (this) {
                notify();
                if (number <= 100) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "输出了" + number);

                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}
