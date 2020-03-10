package 死锁问题;


/*
该代码是典型的死锁问题。第一个线程中锁是s1，休眠了，需要s2进入第二个同步代码块
第二个线程锁是s2，休眠了，需要s1进入第二个同步代码块。
    即不同的线程分别占用对方需要的资源，等待对方先放弃自己需要的资源。导致所有的线程出现阻塞状态。
 */
public class Demo1 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append(1);
                    s2.append("a");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append(2);
                        s2.append("b");
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append(3);
                    s2.append("c");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append(4);
                        s2.append("d");
                    }
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();
    }
}
