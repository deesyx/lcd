package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Park {

    int capacity = 100;

    Map<String, Car> m = new HashMap<>();

    class Car {
        int leaveTime = 0;
        String carNumber;

        public Car(int leaveTime, String carNumber) {
            this.leaveTime = leaveTime;
            this.carNumber = carNumber;
        }
    }

    PriorityQueue<Car> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.leaveTime));

    public int waitTime(int curTime) {
        checkAndRemoveCar(curTime);
        if (q.size() < capacity) {
            return 0;
        }

        return q.peek().leaveTime - curTime;
    }

    public void park(int parkTime, String carNumber, int curTime) {
        Car car = new Car(curTime + parkTime, carNumber);
        checkAndRemoveCar(curTime);
        q.offer(car);
    }

    private void checkAndRemoveCar(int curTime) {
        while (!q.isEmpty() && q.peek().leaveTime < curTime) {
            q.poll();
        }
    }

}
