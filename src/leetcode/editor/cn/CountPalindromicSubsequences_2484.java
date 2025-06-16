//给你数字字符串 s ，请你返回 s 中长度为 5 的 回文子序列 数目。
// 由于答案可能很大，请你将答案对 10⁹ + 7 取余 后返回。
//
// 提示： 
//
// 
// 如果一个字符串从前往后和从后往前读相同，那么它是 回文字符串 。 
// 子序列是一个字符串中删除若干个字符后，不改变字符顺序，剩余字符构成的字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "103301"
//输出：2
//解释：
//总共有 6 长度为 5 的子序列："10330" ，"10331" ，"10301" ，"10301" ，"13301" ，"03301" 。
//它们中有两个（都是 "10301"）是回文的。
// 
//
// 示例 2： 
//
// 输入：s = "0000000"
//输出：21
//解释：所有 21 个长度为 5 的子序列都是 "00000" ，都是回文的。
// 
//
// 示例 3： 
//
// 输入：s = "9999900000"
//输出：2
//解释：仅有的两个回文子序列是 "99999" 和 "00000" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 只包含数字字符。 
// 
//
// Related Topics 字符串 动态规划 👍 47 👎 0


package leetcode.editor.cn;

public class CountPalindromicSubsequences_2484 {
    public static void main(String[] args) {
        Solution solution = new CountPalindromicSubsequences_2484().new Solution();
        solution.countPalindromes("103301");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i][j]表示s[i...j]的回文子序列数目
     */
    class Solution {
        public int countPalindromes(String s) {
            long[][] dp = new long[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;// 选j+选i+选ij
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];// 选j+选i-重复的
                    }
                }
            }

            long ans = 0;
            for (int i = 0; i + 4 < s.length(); i++) {
                ans += dp[i][i + 4];
            }
            return (int) (ans % 1000000007);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}