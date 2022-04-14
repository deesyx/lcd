//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1539 👎 0


package leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_One05 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal_One05().new Solution();
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
        private int index = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(preorder, inorder, 0, preorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {
            if (index >= preorder.length) {
                return null;
            }
            if (inorderStart > inorderEnd) {
                return null;
            }

            int rootValue = preorder[index++];
            int rootIndexInorder = find(inorder, inorderStart, inorderEnd, rootValue);
            TreeNode root = new TreeNode(rootValue);
            TreeNode left = dfs(preorder, inorder, inorderStart, rootIndexInorder - 1);
            TreeNode right = dfs(preorder, inorder, rootIndexInorder + 1, inorderEnd);
            root.left = left;
            root.right = right;
            return root;
        }

        private int find(int[] inorder, int inorderStart, int inorderEnd, int target) {
            for (int i = inorderStart; i <= inorderEnd; i++) {
                if (inorder[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
