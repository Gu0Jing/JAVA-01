import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ExitMain {
    static int res = 0;
//    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start=System.currentTimeMillis();

        //1、通过FutureTask.get()获取返回值后退出
//        FutureTask<Integer> task = new FutureTask<>(ExitMain::sum);
//        new Thread(task).start();
//        res = task.get();

        //2、通过Thread.sleep()
        // 主线程睡眠时间大于子线程执行时间
//        Thread thread = new Thread(() -> res = sum());
//        thread.start();
//        Thread.sleep(3000);

        //3、通过thread.join()
//        Thread thread = new Thread(() -> res = sum());
//        thread.start();
//        thread.join();

        //4、通过公共变量判断
//        AtomicInteger res = new AtomicInteger();
//        Thread thread = new Thread(() -> res.set(sum()));
//        thread.start();
//        while (true) {
//            if (res.get() > 0) {
//                break;
//            }
//        }

        //5、加锁阻塞主线程直到被子线程唤醒
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                res = sum();
                lock.notifyAll();
            }
        });
        thread.start();
        synchronized (lock) {
            lock.wait();
        }

        System.out.println("计算结果为:" + res);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private static int sum() {
        int fibo = fibo(36);
        System.out.println("子线程执行完毕");
        return fibo;
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
