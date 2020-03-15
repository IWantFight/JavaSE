package 线程通信;
/*
    sleep与wait相同点：
        都可以让当前线程进入阻塞状态
      不同点：
        两个方法声明的位置不一样，sleep在Thread中声明的静态方法，object中声明方法wait
        调用的范围不同，sleep可以在任意场景下调用。wait必须使用在同步方法或者同步代码块中
        如果两个方法都是用在同步方法或者代码块中，sleep不会释放同步监视器，而wait会释放。
 */
public class SleepAndWait {
    public static void main(String[] args) {

    }
}
