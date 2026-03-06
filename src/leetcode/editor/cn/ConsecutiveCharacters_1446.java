//给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。 
//
// 请你返回字符串 s 的 能量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "leetcode"
//输出：2
//解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abbcccddddeeeeedcba"
//输出：5
//解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
//
// Related Topics 字符串 👍 151 👎 0


package leetcode.editor.cn;

public class ConsecutiveCharacters_1446 {
    public static void main(String[] args) {
        Solution solution = new ConsecutiveCharacters_1446().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPower(String s) {
            int count = 0;
            int ans = 1;
            char last = ' ';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (last == ' ') {
                    last = c;
                    count = 1;
                    continue;
                }

                if (last == c) {
                    count++;
                } else {
                    last = c;
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}