//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 228 👎 0


package leetcode.editor.cn;

import java.util.*;

public class FindLargestValueInEachTreeRow_Five15 {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow_Five15().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int size = q.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    max = Math.max(node.val, max);
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
                ans.add(max);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
