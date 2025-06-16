//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1341 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubsequence_516 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence_516().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i][j]表示s[i...j]的最长回文子序列长度
     * dp[i][j] = dp[i + 1][j - 1] + 2 if s[i] == s[j]
     * dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) if s[i] != s[j]
     */
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            int ans = 1;
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}