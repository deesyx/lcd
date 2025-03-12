//给你一个字符串 word 和一个 非负 整数 k。
//
// 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：word = "aeioqq", k = 1 
// 
//
// 输出：0 
//
// 解释： 
//
// 不存在包含所有元音字母的子字符串。 
//
// 示例 2： 
//
// 
// 输入：word = "aeiou", k = 0 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一一个包含所有元音字母且不含辅音字母的子字符串是 word[0..4]，即 "aeiou"。 
//
// 示例 3： 
//
// 
// 输入：word = "ieaouqqieaouqq", k = 1 
// 
//
// 输出：3 
//
// 解释： 
//
// 包含所有元音字母并且恰好含有一个辅音字母的子字符串有： 
//
// 
// word[0..5]，即 "ieaouq"。 
// word[6..11]，即 "qieaou"。 
// word[7..12]，即 "ieaouq"。 
// 
//
// 
//
// 提示： 
//
// 
// 5 <= word.length <= 250 
// word 仅由小写英文字母组成。 
// 0 <= k <= word.length - 5 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 11 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsI_3305 {
    public static void main(String[] args) {
        Solution solution = new CountOfSubstringsContainingEveryVowelAndKConsonantsI_3305().new Solution();
        solution.countOfSubstrings("iqeaouqi", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countOfSubstrings(String word, int k) {
            int ans = 0;
            for (int i = 0; i < word.length(); i++) {
                Set<Character> yuan = new HashSet<>();
                int fu = 0;
                for (int j = i; j < word.length(); j++) {
                    if (isYuan(word.charAt(j))) {
                        yuan.add(word.charAt(j));
                    } else {
                        fu++;
                    }
                    if (yuan.size() == 5 && fu == k) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean isYuan(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

        private int countYuan(Map<Character, Integer> yuan) {
            int ans = 0;
            for (Map.Entry<Character, Integer> kv : yuan.entrySet()) {
                if (kv.getValue() <= 0) {
                    return 0;
                }
                ans += kv.getValue();
            }
            if (yuan.size() < 5) {
                return 0;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}