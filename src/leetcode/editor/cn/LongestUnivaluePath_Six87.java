//给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是 [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 660 👎 0


package leetcode.editor.cn;

public class LongestUnivaluePath_Six87 {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath_Six87().new Solution();
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

        private int ans = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = dfs(node.left);
            int right = dfs(node.right);
            int leftAns = 0;
            int rightAns = 0;
            if (node.left != null && node.left.val == node.val) {
                leftAns = left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                rightAns = right + 1;
            }
            ans = Math.max(ans, leftAns + rightAns);
            return Math.max(leftAns, rightAns);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}