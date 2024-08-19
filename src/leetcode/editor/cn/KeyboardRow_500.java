//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 263 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow_500 {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow_500().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            Map<Character, Integer> m = new HashMap<>();
            dict("qwertyuiop", m, 1);
            dict("asdfghjkl", m, 2);
            dict("zxcvbnm", m, 3);

            List<String> ans = new ArrayList<>();
            for (String word : words) {
                char c = word.charAt(0);
                int level = m.get(c);
                boolean match = true;
                for (int i = 1; i < word.length(); i++) {
                    if (level != m.get(word.charAt(i))) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    ans.add(word);
                }
            }

            return ans.toArray(new String[0]);
        }

        private void dict(String s, Map<Character, Integer> m, int level) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                m.put(c, level);
                m.put(Character.toUpperCase(c), level);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}