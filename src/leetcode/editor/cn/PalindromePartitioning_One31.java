//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1351 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_One31 {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning_One31().new Solution();
        solution.partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i][j]表示s[i..j]为回文
         * if s[i]==s[j] dp[i][j]=dp[i+1][j-1] else dp[i][j]=false
         */
        public List<List<String>> partition(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                }
            }

            for (int i = n - 3; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }

            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            dfs(n, dp, ans, path, 0, s);
            return ans;
        }

        private void dfs(int n, boolean[][] dp, List<List<String>> ans, List<String> path, int i, String s) {
            if (i == n) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j < n; j++) {
                if (!dp[i][j]) {
                    continue;
                }

                path.add(s.substring(i, j + 1));
                dfs(n, dp, ans, path, j + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}