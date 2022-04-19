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
// Related Topics 字符串 动态规划 👍 776 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubsequence_Five16 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence_Five16().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // dp[i][j]=dp[i+1][j-1]+2 s[i]==s[j]
    // dp[i][j]=max(dp[i+1][j],dp[i][j-1]) s[i]!=s[j]
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];
            int ans = 1;
            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = 1;
                if (i + 1 < dp.length) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        dp[i][i + 1] = 2;
                        ans = 2;
                    } else {
                        dp[i][i + 1] = 1;
                    }
                }
            }

            for (int i = dp.length - 1; i >= 0; i--) {
                for (int j = i + 2; j < dp.length; j++) {
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
