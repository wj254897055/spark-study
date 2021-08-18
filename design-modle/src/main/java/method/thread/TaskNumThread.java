package method.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskNumThread {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1000, 1000, 60, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 1000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(1000);
        int corePoolSize = executor.getCorePoolSize();
        int maximumPoolSize = executor.getMaximumPoolSize();
        int poolSize = executor.getPoolSize();
        long completedTaskCount = executor.getCompletedTaskCount();
        int size = executor.getQueue().size();
        System.out.println("");
    }
}
