//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 975 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram_242().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> m = new HashMap<>();
            for (char c : s.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }

            for (char c : t.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) - 1);
                if (m.get(c) < 0) {
                    return false;
                }
                if (m.get(c) == 0) {
                    m.remove(c);
                }
            }

            return m.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}