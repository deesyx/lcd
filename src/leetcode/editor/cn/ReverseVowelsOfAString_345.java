//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "IceCreAm" 
// 
//
// 输出："AceCreIm" 
//
// 解释： 
//
// s 中的元音是 ['I', 'e', 'e', 'A']。反转这些元音，s 变为 "AceCreIm". 
//
// 示例 2： 
//
// 
// 输入：s = "leetcode" 
// 
//
// 输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 362 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString_345 {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString_345().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            Set<Character> m = new HashSet<>();
            m.add('a');
            m.add('e');
            m.add('i');
            m.add('o');
            m.add('u');
            m.add('A');
            m.add('E');
            m.add('I');
            m.add('O');
            m.add('U');
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                if (m.contains(chars[i]) && m.contains(chars[j])) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                } else {
                    if (!m.contains(chars[i])) {
                        i++;
                    }
                    if (!m.contains(chars[j])) {
                        j--;
                    }
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}