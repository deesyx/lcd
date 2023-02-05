//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1532 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii_Four37 {
    public static void main(String[] args) {
        Solution solution = new PathSumIii_Four37().new Solution();
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
        private Map<Long, Integer> m = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            m.put(0L, 1);
            dfs(root, targetSum, 0);
//            dfs(root, targetSum);
            return ans;
        }

        private void dfs(TreeNode node, long targetSum, long curSum) {
            if (node == null) {
                return;
            }

            long sum = curSum + node.val;// p0+p1+p2
            long diff = sum - targetSum;// targetSum=sumi-sumj，存在px+...+py=targetSum
            if (m.containsKey(diff)) {
                ans += m.get(diff);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
            dfs(node.left, targetSum, sum);
            dfs(node.right, targetSum, sum);
            m.put(sum, m.getOrDefault(sum, 0) - 1);
        }

//        private void dfs(TreeNode node, int targetSum) {
//            if (node == null) {
//                return;
//            }
//
//            dfs2(node, targetSum, 0);
//            dfs(node.left, targetSum);
//            dfs(node.right, targetSum);
//        }
//
//        private void dfs2(TreeNode node, int targetSum, long curSum) {
//            if (node == null) {
//                return;
//            }
//
//            if (targetSum == curSum + node.val) {
//                ans++;
//            }
//
//            dfs2(node.left, targetSum, curSum + node.val);
//            dfs2(node.right, targetSum, curSum + node.val);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}