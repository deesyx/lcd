//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// 👍 592 👎 0


package leetcode.editor.cn;

public class MinimumAbsoluteDifferenceInBst_530 {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst_530().new Solution();
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

        private int ans = Integer.MAX_VALUE;
        private Integer prev = null;

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }

            dfs(node.left);

            if (prev == null) {
                prev = node.val;
            } else {
                int cur = Math.abs(prev - node.val);
                ans = Math.min(ans, cur);
                prev = node.val;
            }

            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}