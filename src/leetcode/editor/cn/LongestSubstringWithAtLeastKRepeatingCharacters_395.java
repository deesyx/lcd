//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 如果不存在这样的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 924 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters_395().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int ans = 0;
            for (int t = 1; t <= 26; t++) {
                int[] m = new int[26];
                int tot = 0;
                int less = 0;

                int left = 0;
                int right = 0;
                while (right < s.length()) {
                    char in = s.charAt(right);
                    m[in - 'a']++;

                    if (m[in - 'a'] == 1) {
                        tot++;
                        less++;
                    }

                    if (m[in - 'a'] == k) {
                        less--;
                    }

                    while (tot > t) {
                        // 缩
                        char out = s.charAt(left++);
                        m[out - 'a']--;
                        if (m[out - 'a'] == k - 1) {
                            less++;
                        }
                        if (m[out - 'a'] == 0) {
                            tot--;
                            less--;
                        }
                    }

                    if (less == 0) {
                        ans = Math.max(ans, right - left + 1);
                    }

                    right++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}