package leetcode.editor.cn.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class Jerry {

    /**
     * 0  1  2  3  4  5
     * [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
     * 2k+1
     * 3k+1
     * 3=2*1+1  2
     * 4=3*1+1  3
     * 7=2*3+1  4
     * 9=2*4+1  5
     * 10=3*3+1 6  3 3k+1 7的2k+1  2  4
     * 13=3*4+1 7  4 3k+1 7的2k+1  3  4
     * 15=2*7+1 8  7 2k+1 9的2k+1  4  5
     * 19=2*9+1 9  7 3k+1 9的2k+1  4  5
     * 21=2*10+1 10  7 3k+1 10的2k+1  4  6
     * 22=3*7+1  11  7 3k+1 13的2k+1  4  7
     */
    public static void main(String[] args) {
        System.out.println(find2(5));
    }

    private static int find(int n) {
        if (n == 1) {
            return 1;
        }

        TreeSet<Integer> dp = new TreeSet<>();
        int prev = 1;
        dp.add(prev);
        int count = 1;
        while (count < n) {
            dp.add(prev * 2 + 1);// O(logn)
            dp.add(prev * 3 + 1);
            prev = dp.higher(prev);
            count++;
        }

        return prev;// o(nlogn)
    }

    private static int find2(int n) {
        if (n == 1) {
            return 1;
        }

        List<Integer> dp = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        dp.add(1);
        for (int i = 1; i < n; i++) {
            dp.add(Math.min(dp.get(p1) * 2 + 1, dp.get(p2) * 3 + 1));
            if (dp.get(i) == dp.get(p1) * 2 + 1) {
                p1++;
            } else {
                p2++;
            }
        }

        return dp.get(n - 1);
    }
}
