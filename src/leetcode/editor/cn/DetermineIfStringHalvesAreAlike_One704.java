//给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。 
//
// 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含
//有大写和小写字母。 
//
// 如果 a 和 b 相似，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "book"
//输出：true
//解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
// 
//
// 示例 2： 
//
// 
//输入：s = "textbook"
//输出：false
//解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
//注意，元音 o 在 b 中出现两次，记为 2 个。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 1000 
// s.length 是偶数 
// s 由 大写和小写 字母组成 
// 
// Related Topics 字符串 计数 👍 40 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike_One704 {
    public static void main(String[] args) {
        Solution solution = new DetermineIfStringHalvesAreAlike_One704().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean halvesAreAlike(String s) {
            int[] m = new int[123];
            m['a'] = 1;
            m['e'] = 1;
            m['i'] = 1;
            m['o'] = 1;
            m['u'] = 1;
            m['A'] = 1;
            m['E'] = 1;
            m['I'] = 1;
            m['O'] = 1;
            m['U'] = 1;

            int ans = 0;
            int half = s.length() / 2;
            for (int i = 0; i < half; i++) {
                if (m[s.charAt(i)] == 1) ans++;
                if (m[s.charAt(i + half)] == 1) ans--;
            }
            return ans == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}