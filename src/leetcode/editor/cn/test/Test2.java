package leetcode.editor.cn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solve(ListNode head) {
        ListNode p = head;
        Map<Integer, Integer> m = new HashMap<>();
        while (p != null) {
            m.put(p.val, m.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }

        int max = 0;
        int maxVal = -1;
        for (Map.Entry<Integer, Integer> kv : m.entrySet()) {
            Integer val = kv.getKey();
            Integer count = kv.getValue();
            if (count > max) {
                max = count;
                maxVal = val;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        p = head;
        while (p != null) {
            ListNode next = p.next;
            if (p.val == maxVal) {
                node.next = p;
                p.next = null;
                node = node.next;
            }
            p = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
