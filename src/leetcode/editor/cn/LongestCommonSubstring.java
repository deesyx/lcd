package leetcode.editor.cn;

public class LongestCommonSubstring {

    public static void main(String[] args) {

    }

    /**
     * dp[i][j]表示s1[0...i]和s2[0...j]的最长公共子串长度
     * dp[i][j] = dp[i - 1][j - 1] + 1 if s1[i] == s2[j]
     * dp[i][j] = 0 if s1[i] != s2[j]
     */
    private int longestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int ans = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
