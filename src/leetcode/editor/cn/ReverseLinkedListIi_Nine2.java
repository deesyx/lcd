//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1455 👎 0


package leetcode.editor.cn;

public class ReverseLinkedListIi_Nine2 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi_Nine2().new Solution();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(4);
        next = next.next;
        next.next = new ListNode(5);
        solution.reverseBetween(head, 2, 4);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (right - left + 1 <= 1) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode preStart = dummy;
            left--;
            right--;
            ListNode start = head;
            while (start != null && left > 0) {
                preStart = start;
                start = start.next;
                left--;
            }
            ListNode end = head;
            while (end != null && right > 0) {
                end = end.next;
                right--;
            }
            if (start == null || end == null) {
                return head;
            }
            end = end.next;

            ListNode p1 = start.next;
            ListNode p2 = start;
            while (p1 != end) {
                ListNode p3 = p1.next;
                p1.next = p2;
                if (p2.next == p1) {
                    p2.next = null;
                }
                p2 = p1;
                p1 = p3;
            }
            start.next = end;
            preStart.next = p2;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}