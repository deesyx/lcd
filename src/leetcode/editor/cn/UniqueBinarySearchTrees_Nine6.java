//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2049 👎 0


package leetcode.editor.cn;

public class UniqueBinarySearchTrees_Nine6 {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees_Nine6().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
         * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
         * <p>
         * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
         * f(i) = G(i-1)*G(n-i)
         * <p>
         * 综合两个公式可以得到 卡特兰数 公式
         * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
         */
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            // 问题规模由小逐渐变大，k逐渐变为n
            for (int k = 2; k <= n; k++) {
                for (int i = 1; i <= k; i++) {
                    dp[k] += dp[i - 1] * dp[k - i];// 左节点i-1个，右节点n-i个
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}