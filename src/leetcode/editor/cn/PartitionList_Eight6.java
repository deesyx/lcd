//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 698 👎 0


package leetcode.editor.cn;

public class PartitionList_Eight6 {
    public static void main(String[] args) {
        Solution solution = new PartitionList_Eight6().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode p1 = head;
            ListNode p2 = dummy;

            while (p1 != null && p1.val < x) {
                p2 = p1;
                p1 = p1.next;
            }
            if (p1 == null) {
                return head;
            }

            ListNode bound = p2;
            while (p1 != null) {
                if (p1.val >= x) {
                    p2 = p1;
                    p1 = p1.next;
                    continue;
                }

                ListNode p3 = p1;
                p1 = p1.next;
                p2.next = p1;

                p3.next = bound.next;
                bound.next = p3;
                bound = p3;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}