//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 527 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof_剑指Offer48 {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof_剑指Offer48().new Solution();
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