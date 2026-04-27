//给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "bcbbbcba" 
// 
//
// 输出： 4 
//
// 解释： 
//
// 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。 
//
// 示例 2： 
//
// 
// 输入： s = "aaaa" 
// 
//
// 输出： 2 
//
// 解释： 
//
// 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。 
//
// 
//
// 提示： 
//
// 
// 
// 2 <= s.length <= 100 
// 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 45 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences_3090 {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthSubstringWithTwoOccurrences_3090().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLengthSubstring(String s) {
            int left = 0;
            int right = 0;
            int ans = 0;
            Map<Character, Integer> m = new HashMap<>();
            while (right < s.length()) {
                char in = s.charAt(right);
                while (m.containsKey(in) && m.get(in) >= 2) {
                    char out = s.charAt(left++);
                    m.put(out, m.get(out) - 1);
                }
                int length = right - left + 1;
                ans = Math.max(ans, length);
                m.put(in, m.getOrDefault(in, 0) + 1);
                right++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}