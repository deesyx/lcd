//有效单词 需要满足以下几个条件：
//
// 
// 至少 包含 3 个字符。 
// 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。） 
// 至少 包含一个 元音字母 。 
// 至少 包含一个 辅音字母 。 
// 
//
// 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。 
//
// 注意： 
//
// 
// 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。 
// 英文中的 辅音字母 是指那些除元音字母之外的字母。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：word = "234Adas" 
// 
//
// 输出：true 
//
// 解释： 
//
// 这个单词满足所有条件。 
//
// 示例 2： 
//
// 
// 输入：word = "b3" 
// 
//
// 输出：false 
//
// 解释： 
//
// 这个单词的长度少于 3 且没有包含元音字母。 
//
// 示例 3： 
//
// 
// 输入：word = "a3$e" 
// 
//
// 输出：false 
//
// 解释： 
//
// 这个单词包含了 '$' 字符且没有包含辅音字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 20 
// word 由英文大写和小写字母、数字、'@'、'#' 和 '$' 组成。 
// 
//
// Related Topics 字符串 👍 10 👎 0


package leetcode.editor.cn;

public class ValidWord_3136 {
    public static void main(String[] args) {
        Solution solution = new ValidWord_3136().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String word) {
            if (word.length() < 3) {
                return false;
            }

            int countYuan = 0;
            int countFu = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    if (c >= '0' && c <= '9') {
                        continue;
                    }

                    char lower = Character.toLowerCase(c);
                    if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                        countYuan++;
                    } else {
                        countFu++;
                    }
                } else {
                    return false;
                }
            }

            return countYuan > 0 && countFu > 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}