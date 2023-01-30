////给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: s = "abcabcbb"
////输出: 3 
////解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//// 
////
//// 示例 2: 
////
//// 
////输入: s = "bbbbb"
////输出: 1
////解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//// 
////
//// 示例 3: 
////
//// 
////输入: s = "pwwkew"
////输出: 3
////解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//// 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= s.length <= 5 * 10⁴ 
//// s 由英文字母、数字、符号和空格组成 
//// 
//// Related Topics 哈希表 字符串 滑动窗口 👍 7406 👎 0
//


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_Three {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters_Three().new Solution();
        solution.lengthOfLongestSubstring("abcabc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> m = new HashSet<>();
            int left = 0;
            int right = 0;
            int count = 0;
            while (right < s.length()) {
                char in = s.charAt(right++);
                if (!m.contains(in)) {
                    m.add(in);
                    count = Math.max(count, right - left);
                } else {
                    while (s.charAt(left) != in) {
                        m.remove(s.charAt(left));
                        left++;
                    }
                    left++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
