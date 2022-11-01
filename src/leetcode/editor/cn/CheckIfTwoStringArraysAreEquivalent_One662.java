//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 
//
// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true 
//
// 示例 2： 
//
// 
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10³ 
// 1 <= word1[i].length, word2[i].length <= 10³ 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³ 
// word1[i] 和 word2[i] 由小写字母组成 
// 
// Related Topics 数组 字符串 👍 51 👎 0


package leetcode.editor.cn;

public class CheckIfTwoStringArraysAreEquivalent_One662 {
    public static void main(String[] args) {
        Solution solution = new CheckIfTwoStringArraysAreEquivalent_One662().new Solution();
        solution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean init;

        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int[] cur = new int[]{0, 0};
            for (int i = 0; i < word1.length; i++) {
                for (int j = 0; j < word1[i].length(); j++) {
                    char c1 = word1[i].charAt(j);
                    next(cur, word2);
                    if (cur[0] == -1) {
                        return false;
                    }
                    char c2 = word2[cur[0]].charAt(cur[1]);
                    if (c1 != c2) {
                        return false;
                    }
                }
            }
            next(cur, word2);
            return cur[0] == -1;
        }

        private void next(int[] idx, String[] word2) {
            if (!this.init) {
                this.init = true;
                return;
            }
            int nj = idx[1] + 1;
            if (nj < word2[idx[0]].length()) {
                idx[1] = nj;
            } else {
                int ni = idx[0] + 1;
                if (ni < word2.length) {
                    idx[0] = ni;
                    idx[1] = 0;
                } else {
                    idx[0] = -1;
                    idx[1] = -1;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}