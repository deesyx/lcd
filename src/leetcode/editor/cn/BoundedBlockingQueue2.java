package leetcode.editor.cn;

import java.util.LinkedList;

public class BoundedBlockingQueue2 {

    private LinkedList<Integer> q = new LinkedList<>();
    private int capacity;

    // Construct method: Set the length of the queue
    public BoundedBlockingQueue2(int capacity) {
        this.capacity = capacity;
    }

    // Add data in relative columns
    public void enqueue(int element) {
        synchronized (this) {
            try {
                while (size() >= capacity) this.wait();
                q.addFirst(element);
                this.notifyAll();
            } catch (InterruptedException e) {
            }
        }
    }

    // Get the data in the queue head
    public int dequeue() {
        synchronized (this) {
            try {
                while (q.isEmpty()) this.wait();
                int last = q.removeLast();
                this.notifyAll();
                return last;
            } catch (InterruptedException e) {
                return 0;
            }
        }
    }

    // Get the size of the queue
    public int size() {
        return q.size();
    }
}
