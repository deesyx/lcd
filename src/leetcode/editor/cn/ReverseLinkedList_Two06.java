//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2885 👎 0


package leetcode.editor.cn;

public class ReverseLinkedList_Two06 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList_Two06().new Solution();
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
        private ListNode ans = new ListNode();

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode p1 = head.next;
            if (p1 == null) {
                return head;
            }

            ListNode p2 = head;

//            while (p1 != null) {
//                ListNode p3 = p1.next;
//                p1.next = p2;
//                if (p2.next == p1) {// 特殊处理开头
//                    p2.next = null;
//                }
//                p2 = p1;
//                p1 = p3;
//            }
//            return p2;
            dfs(p1, p2);
            return this.ans;
        }

        private void dfs(ListNode p1, ListNode p2) {
            if (p1 == null) {
                ans = p2;
                return;
            }
            ListNode p3 = p1.next;
            p1.next = p2;
            if (p2.next == p1) {// 特殊处理开头
                p2.next = null;
            }
            dfs(p3, p1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}