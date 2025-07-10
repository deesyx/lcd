//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 3093 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber_17().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList<>();
            }
            Map<Character, char[]> m = new HashMap<>();
            m.put('2', new char[]{'a', 'b', 'c'});
            m.put('3', new char[]{'d', 'e', 'f'});
            m.put('4', new char[]{'g', 'h', 'i'});
            m.put('5', new char[]{'j', 'k', 'l'});
            m.put('6', new char[]{'m', 'n', 'o'});
            m.put('7', new char[]{'p', 'q', 'r', 's'});
            m.put('8', new char[]{'t', 'u', 'v'});
            m.put('9', new char[]{'w', 'x', 'y', 'z'});

            List<String> ans = new ArrayList<>();
            dfs(digits, 0, new StringBuilder(), ans, m);
            return ans;

        }

        private void dfs(String digits, int index, StringBuilder path, List<String> ans, Map<Character, char[]> m) {
            if (index == digits.length()) {
                ans.add(path.toString());
                return;
            }
            char d = digits.charAt(index);
            char[] chars = m.get(d);
            for (char c : chars) {
                path.append(c);
                dfs(digits, index + 1, path, ans, m);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}