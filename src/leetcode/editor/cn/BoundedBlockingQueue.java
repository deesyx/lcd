package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private LinkedList<Integer> q = new LinkedList<>();
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition canAdd = lock.newCondition();
    private Condition canRemove = lock.newCondition();

    // Construct method: Set the length of the queue
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // Add data in relative columns
    public void enqueue(int element) {
        lock.lock();
        try {
            while (size() >= capacity) canAdd.await();
            q.addFirst(element);
            canRemove.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    // Get the data in the queue head
    public int dequeue() {
        lock.lock();
        try {
            while (q.isEmpty()) canRemove.await();
            int last = q.removeLast();
            canAdd.signalAll();
            return last;
        } catch (InterruptedException e) {
            return 0;
        } finally {
            lock.unlock();
        }
    }

    // Get the size of the queue
    public int size() {
        return q.size();
    }
}
