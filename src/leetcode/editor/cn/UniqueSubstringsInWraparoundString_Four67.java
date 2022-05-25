//把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
// 
//
// 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
//
// 
//
// 示例 1: 
//
// 
//输入: p = "a"
//输出: 1
//解释: 字符串 s 中只有一个"a"子字符。
// 
//
// 示例 2: 
//
// 
//输入: p = "cac"
//输出: 2
//解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 示例 3: 
//
// 
//输入: p = "zab"
//输出: 6
//解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= p.length <= 10⁵ 
// p 由小写英文字母构成 
// 
// Related Topics 字符串 动态规划 👍 264 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class UniqueSubstringsInWraparoundString_Four67 {
    public static void main(String[] args) {
        Solution solution = new UniqueSubstringsInWraparoundString_Four67().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // dp[ch]表示p中以ch为结尾且在s中的最长子串长度
    class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] dp = new int[26];
            int k = 1;
            for (int i = 0; i < p.length(); i++) {
                if (i > 0 && (((p.charAt(i) - 'a') - (p.charAt(i - 1) - 'a') == 1) || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z'))) {
                    k++;
                } else {
                    k = 1;
                }
                dp[p.charAt(i) - 'a'] = Math.max(k, dp[p.charAt(i) - 'a']);
            }
            return Arrays.stream(dp).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
