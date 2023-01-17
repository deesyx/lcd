package leetcode.editor.cn;


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        Integer nextVal = null;
        if (next != null) {
            nextVal = next.val;
        }
        return "ListNode{" +
                "val=" + val +
                ", next=" + nextVal +
                '}';
    }
}

