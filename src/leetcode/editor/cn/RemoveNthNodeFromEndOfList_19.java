//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 3133 👎 0


package leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList_19 {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList_19().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p1 = head;
            while (n > 0) {
                p1 = p1.next;
                n--;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode p2 = head;
            ListNode p3 = dummy;

            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
                p3 = p3.next;
            }

            p3.next = p2.next;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}