//给你两棵二叉树： root1 和 root2 。 
//
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
//，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。 
//
// 返回合并后的二叉树。 
//
// 注意: 合并过程必须从两个树的根节点开始。 
//
// 
//
// 示例 1： 
//
// 
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点数目在范围 [0, 2000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1147 👎 0


package leetcode.editor.cn;

public class MergeTwoBinaryTrees_Six17 {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees_Six17().new Solution();
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return dfs(root1, root2);
        }

        private TreeNode dfs(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return null;
            }

            TreeNode node = new TreeNode(0);
            if (node1 != null) {
                node.val += node1.val;
            }
            if (node2 != null) {
                node.val += node2.val;
            }

            TreeNode left = null;
            TreeNode right = null;
            if (node1 != null && node2 != null) {
                left = dfs(node1.left, node2.left);
                right = dfs(node1.right, node2.right);
            } else if (node1 != null && node2 == null) {
                left = node1.left;
                right = node1.right;
            } else if (node1 == null && node2 != null) {
                left = node2.left;
                right = node2.right;
            }

            node.left = left;
            node.right = right;

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}