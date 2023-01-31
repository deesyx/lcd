//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 1061 👎 0


package leetcode.editor.cn;

public class PalindromicSubstrings_Six47 {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings_Six47().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            int ans = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
                ans++;
            }
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    ans++;
                }
            }

            for (int i = n - 3; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}