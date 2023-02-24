package leetcode.editor.cn.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    private ReentrantLock lock = new ReentrantLock();
    private Condition canPut = lock.newCondition();
    private Condition canGet = lock.newCondition();

    private Queue<Integer> q = new LinkedList<>();
    private int size = 10;

    public void put(int x) throws InterruptedException {
        lock.lock();
        while (q.size() == size) {
            canPut.await();
        }
        q.add(x);
        canGet.signalAll();
        lock.unlock();
    }

    public int get() throws InterruptedException {
        lock.lock();
        while (q.size() == 0) {
            canGet.await();
        }
        int poll = q.poll();
        canPut.signalAll();
        lock.unlock();
        return poll;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread produce = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    producerConsumer.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                int x = 0;
                while (x < 20) {
                    Thread.sleep(1000);
                    int get = producerConsumer.get();
                    x++;
                    System.out.println(get);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        produce.start();
        consumer.start();

        produce.join();
        consumer.join();
    }

}
