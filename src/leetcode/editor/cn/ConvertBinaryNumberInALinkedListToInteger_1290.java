//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
// 请你返回该链表所表示数字的 十进制值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
// 
//
// 示例 2： 
//
// 输入：head = [0]
//输出：0
// 
//
// 示例 3： 
//
// 输入：head = [1]
//输出：1
// 
//
// 示例 4： 
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
// 
//
// 示例 5： 
//
// 输入：head = [0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 链表不为空。 
// 链表的结点总数不超过 30。 
// 每个结点的值不是 0 就是 1。 
// 
//
// Related Topics 链表 数学 👍 186 👎 0


package leetcode.editor.cn;

public class ConvertBinaryNumberInALinkedListToInteger_1290 {
    public static void main(String[] args) {
        Solution solution = new ConvertBinaryNumberInALinkedListToInteger_1290().new Solution();
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
        public int getDecimalValue(ListNode head) {
            int count = 0;
            ListNode p = head;
            while (p != null) {
                count++;
                p = p.next;
            }

            p = head;
            int ans = 0;
            count--;
            while (p != null) {
                int val = p.val;
                if (val == 1) {
                    ans += (int) Math.pow(2, count);
                }
                count--;
                p = p.next;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}