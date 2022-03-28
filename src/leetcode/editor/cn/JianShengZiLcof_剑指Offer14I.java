//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 397 👎 0


package leetcode.editor.cn;

public class JianShengZiLcof_剑指Offer14I {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof_剑指Offer14I().new Solution();
        solution.cuttingRope(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dp[i]表示绳子的长度是i时的最大乘积
        // dp[i]=max(j*(i-j),j*dp[i-j]) j*(i-j)将i拆分成j和i-j的和，且i-j不再拆分成多个正整数；j*dp[i-j]将i拆分成j和i-j的和，且i-j继续拆分成多个正整数
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int curMax = 0;
                for (int j = 1; j < i; j++) {
                    curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = curMax;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
