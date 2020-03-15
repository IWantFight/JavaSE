package 新的线程创建方式;

import java.util.concurrent.*;

class RunnbaleDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2  == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class CallableDemo1 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++)
        {
            if (i % 2  != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //适用于callable
        service.submit(new CallableDemo1());
        //适用于runnable
        service.execute(new RunnbaleDemo());
        FutureTask futureTask = new FutureTask(new CallableDemo1());
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();


    }
}
