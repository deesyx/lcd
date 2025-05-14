//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为 平衡 二叉搜索树。
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 942 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree_109 {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree_109().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> nums = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                nums.add(p.val);
                p = p.next;
            }

            return dfs(nums, 0, nums.size() - 1);
        }

        private TreeNode dfs(List<Integer> nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums.get(mid));
            root.left = dfs(nums, left, mid - 1);
            root.right = dfs(nums, mid + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}