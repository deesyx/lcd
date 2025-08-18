//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics 栈 链表 数学 👍 779 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class AddTwoNumbersIi_445 {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi_445().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }

            int flag = 0;
            Stack<Integer> s3 = new Stack<>();
            while (!s1.isEmpty() && !s2.isEmpty()) {
                int t = flag + s1.pop() + s2.pop();
                if (t >= 10) {
                    t -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                s3.push(t);
            }

            while (!s1.isEmpty()) {
                int t = flag + s1.pop();
                if (t >= 10) {
                    t -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                s3.push(t);
            }

            while (!s2.isEmpty()) {
                int t = flag + s2.pop();
                if (t >= 10) {
                    t -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                s3.push(t);
            }

            if (flag != 0) {
                s3.push(flag);
            }

            ListNode dummy = new ListNode();
            ListNode p = dummy;
            while (!s3.isEmpty()) {
                p.next = new ListNode(s3.pop());
                p = p.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}