//给你一个字符串 s，找到 s 中最长的回文子串。 
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
// Related Topics 字符串 动态规划 👍 5087 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring_Five {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring_Five().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // dp[i][j]==true表示s[i..j]是一个回文
    // dp[i][j]=true dp[i+1][j-1]==true && s[i]==s[j]
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
                if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                    dp[i][i + 1] = true;
                }
            }

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 2; j < s.length(); j++) {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                }
            }

            int ansi = 0;
            int ansj = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (dp[i][j] && j - i > ansj - ansi) {
                        ansi = i;
                        ansj = j;
                    }
                }
            }
            return s.substring(ansi, ansj + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
