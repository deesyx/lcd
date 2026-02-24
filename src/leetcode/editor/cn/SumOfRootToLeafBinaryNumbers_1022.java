//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。 
//
// 
// 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
// 2*0+0=0
// 2*0+1=1
// 2*1+1=3
// 2*3+0=6
// 2*6+1=13
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 1000] 范围内 
// Node.val 仅为 0 或 1 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 270 👎 0


package leetcode.editor.cn;

public class SumOfRootToLeafBinaryNumbers_1022 {
	public static void main(String[] args) {
		Solution solution = new SumOfRootToLeafBinaryNumbers_1022().new Solution();
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

		public int sumRootToLeaf(TreeNode root) {
			dfs(root, 0);
			return ans;
		}

		private void dfs(TreeNode node, int tmp) {
			if (node == null) {
				return;
			}

			tmp = 2 * tmp + node.val;

			if (node.left == null && node.right == null) {
				ans += tmp;
				return;
			}

			dfs(node.left, tmp);
			dfs(node.right, tmp);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}