//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 136 👎 0


package leetcode.editor.cn;

public class SuccessorLcci_面试题0406 {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci_面试题0406().new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        solution.inorderSuccessor(root, root.left);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode[] ans = new TreeNode[1];
            boolean[] next = new boolean[1];
            dfs(root, p, ans, next);
            return ans[0];
        }

        private void dfs(TreeNode node, TreeNode p, TreeNode[] ans, boolean[] next) {
            if (node == null) {
                return;
            }
            dfs(node.left, p, ans, next);
            if (next[0]) {
                ans[0] = node;
                next[0] = false;
                return;
            }
            if (node == p) {
                next[0] = true;
            }
            dfs(node.right, p, ans, next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
