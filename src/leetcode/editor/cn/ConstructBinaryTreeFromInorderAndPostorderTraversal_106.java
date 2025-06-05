//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1342 👎 0


package leetcode.editor.cn;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal_106().new Solution();
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

        int[] inorder;
        int[] postorder;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;

            return dfs(0, inorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode dfs(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
            if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
                return null;
            }

            int rootValue = postorder[postorderEnd];
            int rootInorderIndex = findInorderIndex(inorderStart, inorderEnd, rootValue);
            int leftSize = rootInorderIndex - inorderStart;
            TreeNode root = new TreeNode(rootValue);
            root.left = dfs(inorderStart, rootInorderIndex - 1, postorderStart, postorderStart + leftSize - 1);
            root.right = dfs(rootInorderIndex + 1, inorderEnd, postorderStart + leftSize, postorderEnd - 1);
            return root;
        }

        private int findInorderIndex(int inorderStart, int inorderEnd, int target) {
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