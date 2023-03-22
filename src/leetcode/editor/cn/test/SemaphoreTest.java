package leetcode.editor.cn.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        // 20个线程刚好处理20个请求
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        // 五个信号量
        final Semaphore semaphore = new Semaphore(5);

        // 模拟20个请求
        for (int i = 0; i < 20; i++) {
            System.out.println("current request: " + i);
            final int index = i;
            Runnable runnable = () -> {
                try {
                    // 获取许可
                    semaphore.acquire();
                    System.out.println("Accessing: " + index);
                    Thread.sleep(20000L);
                    // 访问完后，释放
                    semaphore.release();
                    System.out.println("-----------------" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            // 拿不到信号量的会阻塞等待
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
