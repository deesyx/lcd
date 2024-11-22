//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 👍 1227 👎 0


package leetcode.editor.cn;

public class RepeatedSubstringPattern_459 {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern_459().new Solution();
        solution.repeatedSubstringPattern("aba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            for (int i = 0; i < s.length() - 1; i++) {
                String sub = s.substring(0, i + 1);
                int length = i + 1;
                if (s.length() % length != 0) {
                    continue;
                }

                int n = s.length() / length;
                String repeat = sub.repeat(n);
                if (repeat.equals(s)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}