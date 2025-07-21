//一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
//
// 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。 
//
// 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "leeetcode"
//输出："leetcode"
//解释：
//从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
//没有连续三个相同字符，所以返回 "leetcode" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaabaaaa"
//输出："aabaa"
//解释：
//从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
//从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
//没有连续三个相同字符，所以返回 "aabaa" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "aab"
//输出："aab"
//解释：没有连续三个相同字符，所以返回 "aab" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 字符串 👍 38 👎 0


package leetcode.editor.cn;

public class DeleteCharactersToMakeFancyString_1957 {
    public static void main(String[] args) {
        Solution solution = new DeleteCharactersToMakeFancyString_1957().new Solution();
        solution.makeFancyString("abbcccddddeeeee");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder(s);
            int i = 0;
            while (i < sb.length()) {
                int j = i;
                int count = 0;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    count++;
                    j++;
                }
                if (count >= 3) {
                    sb.delete(i + 2, j);
                    i = i + 2;
                } else {
                    i = i + count;
                }

            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}