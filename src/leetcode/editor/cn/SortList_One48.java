//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1874 👎 0


package leetcode.editor.cn;

public class SortList_One48 {
    public static void main(String[] args) {
        Solution solution = new SortList_One48().new Solution();
        ListNode head = new ListNode(2);
        ListNode p = head;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(3);

        solution.sortList(head);
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
        public ListNode sortList(ListNode head) {
            int length = 0;
            ListNode p = head;
            while (p != null) {
                length++;
                p = p.next;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;

            for (int i = 1; i < length; i = i * 2) {
                ListNode pre = dummy;
                ListNode cur = dummy.next;

                while (cur != null) {
                    ListNode left = cur;
                    ListNode right = getNextHead(left, i);
                    cur = getNextHead(right, i);
                    pre.next = merge(left, right);
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                }
            }
            return dummy.next;

//            return dfs(head, null);
        }

        private ListNode getNextHead(ListNode curHead, int step) {
            if (curHead == null) {
                return null;
            }
            ListNode dummy = new ListNode();
            dummy.next = curHead;
            ListNode pre = dummy;
            ListNode p = dummy.next;
            while (p != null && step > 0) {
                pre = p;
                p = p.next;
                step--;
            }
            pre.next = null;
            return p;
        }

        // 递归
        private ListNode dfs(ListNode start, ListNode end) {
            if (start == null) {
                return null;
            }
            if (start.next == end) {
                start.next = null; // 当节点个数等于1时，断开当前节点与下一个节点的连接，这样merge的时候就可以通过p1 != null && p2 != null来判断了
                return start;
            }
            ListNode p1 = start;
            ListNode p2 = start;
            while (p1 != end) {
                p1 = p1.next;
                p2 = p2.next;
                if (p1 != end) {
                    p1 = p1.next;
                }
            }
            ListNode left = dfs(start, p2);
            ListNode right = dfs(p2, end);
            ListNode dummy = new ListNode();
            p1 = left;
            p2 = right;
            ListNode p = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode();
            ListNode p1 = left;
            ListNode p2 = right;
            ListNode p = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}