//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 116 👎 0


package leetcode.editor.cn;

public class DeepestLeavesSum_One302 {
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum_One302().new Solution();
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

        private int maxDeep = -1;
        private int ans = 0;

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode node, int curDeep) {
            if (node == null) {
                return;
            }
            curDeep++;
            if (node.left == null && node.right == null) {
                if (curDeep == maxDeep) {
                    ans += node.val;
                } else if (curDeep > maxDeep) {
                    maxDeep = curDeep;
                    ans = node.val;
                }
            } else {
                dfs(node.left, curDeep);
                dfs(node.right, curDeep);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}