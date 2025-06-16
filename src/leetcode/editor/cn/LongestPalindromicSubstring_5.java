//给你一个字符串 s，找到 s 中最长的 回文 子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7726 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring_5().new Solution();
        solution.longestPalindrome("cbbd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i][j]表示s[i...j]是否是回文串
     * dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
     */
    class Solution {
        public String longestPalindrome(String s) {
            int[][] dp = new int[s.length()][s.length()];
            int max = 1;
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                    max = 2;
                }
            }

            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 2; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] != 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (dp[i][j] == max) {
                        return s.substring(i, j + 1);
                    }
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}