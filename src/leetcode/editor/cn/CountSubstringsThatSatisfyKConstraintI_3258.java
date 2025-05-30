//给你一个 二进制 字符串 s 和一个整数 k。
//
// 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束： 
//
// 
// 字符串中 0 的数量最多为 k。 
// 字符串中 1 的数量最多为 k。 
// 
//
// 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "10101", k = 1 
// 
//
// 输出：12 
//
// 解释： 
//
// s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。 
//
// 示例 2： 
//
// 
// 输入：s = "1010101", k = 2 
// 
//
// 输出：25 
//
// 解释： 
//
// s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。 
//
// 示例 3： 
//
// 
// 输入：s = "11111", k = 1 
// 
//
// 输出：15 
//
// 解释： 
//
// s 的所有子字符串都满足 k 约束。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// 1 <= k <= s.length 
// s[i] 是 '0' 或 '1'。 
// 
//
// 👍 11 👎 0


package leetcode.editor.cn;

public class CountSubstringsThatSatisfyKConstraintI_3258 {
    public static void main(String[] args) {
        Solution solution = new CountSubstringsThatSatisfyKConstraintI_3258().new Solution();
        solution.countKConstraintSubstrings("10101", 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKConstraintSubstrings(String s, int k) {
            int count0 = 0;
            int count1 = 0;

            int l = 0;
            int r = 0;
            int ans = 0;
            while (r < s.length()) {
                char in = s.charAt(r);
                if (in == '0') {
                    count0++;
                } else {
                    count1++;
                }

                while (count0 > k && count1 > k) {
                    char out = s.charAt(l++);
                    if (out == '0') {
                        count0--;
                    } else {
                        count1--;
                    }
                }

                ans += r - l + 1;
                r++;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}