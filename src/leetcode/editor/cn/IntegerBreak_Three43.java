//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 763 👎 0


package leetcode.editor.cn;

public class IntegerBreak_Three43{
    public static void main(String[] args){
        Solution solution = new IntegerBreak_Three43().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        // dp[i]表示绳子的长度是i时的最大乘积
        // dp[i]=max(j*(i-j),j*dp[i-j]) j*(i-j)将i拆分成j和i-j的和，且i-j不再拆分成多个正整数；j*dp[i-j]将i拆分成j和i-j的和，且i-j继续拆分成多个正整数
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
