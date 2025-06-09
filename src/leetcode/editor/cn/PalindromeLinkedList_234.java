//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 2070 👎 0


package leetcode.editor.cn;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList_234().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
                if (p1 != null) {
                    p1 = p1.next;
                }
            }
            if (p1 == p2) {
                return true;
            }

            ListNode halfHead = p2;
            p1 = head;
            while (p1.next != halfHead) {
                p1 = p1.next;
            }
            p1.next = null;

            halfHead = reverse(halfHead);

            p1 = head;
            p2 = halfHead;

            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }

                p1 = p1.next;
                p2 = p2.next;
            }

            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = p1.next;

            p1.next = null;

            while (p2 != null) {
                ListNode p3 = p2.next;
                p2.next = p1;

                p1 = p2;
                p2 = p3;
            }

            return p1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}