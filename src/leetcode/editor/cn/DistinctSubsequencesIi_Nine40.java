//给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。 
//
// 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：7
//解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
// 
//
// 示例 2： 
//
// 
//输入：s = "aba"
//输出：6
//解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
// 
//
// 示例 3： 
//
// 
//输入：s = "aaa"
//输出：3
//解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// 
// Related Topics 字符串 动态规划 👍 232 👎 0


package leetcode.editor.cn;

public class DistinctSubsequencesIi_Nine40 {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequencesIi_Nine40().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // dp[i] = dp[i - 1] + newCount - repeatCount
    // newCount = dp[i - 1]
    // repeatCount = s[i]上一次出现时新增值
    // https://leetcode.cn/problems/distinct-subsequences-ii/solution/bu-tong-by-capital-worker-vga3/
    class Solution {
        public int distinctSubseqII(String s) {
            int mod = (int) 1e9 + 7;
            int[] preCount = new int[26];
            int dp = 1;// 空串
            for (int i = 0; i < s.length(); i++) {
                int nextDp = ((dp + dp) % mod - preCount[s.charAt(i) - 'a'] + mod) % mod;
                preCount[s.charAt(i) - 'a'] = dp;
                dp = nextDp;
            }
            return dp - 1;//减去空串
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}