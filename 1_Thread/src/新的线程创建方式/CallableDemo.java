package 新的线程创建方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
    与使用runnable相比有如下优势：
        1、run方法可以有返回值
        2、方法可以抛出异常
        3、支持泛型的返回值
        4、需要借助FutureTask类，比如获取返回值结果。
 */
public class CallableDemo {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();

        FutureTask futureTask = new FutureTask(callableTest);

        new Thread(futureTask).start();

        try {

            //get方法可以不使用，仅仅是为了得到返回值！！！
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableTest implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
