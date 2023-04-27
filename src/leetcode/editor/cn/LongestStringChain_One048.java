//给出一个单词数组 words ，其中每个单词都由小写英文字母组成。 
//
// 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 
//前身 。 
//
// 
// 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身 
// 
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是
// word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。 
//
// 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。 
//
// 示例 1： 
//
// 
//输入：words = ["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 ["a","ba","bda","bdca"]
// 
//
// 示例 2: 
//
// 
//输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//输出：5
//解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
// 
//
// 示例 3: 
//
// 
//输入：words = ["abcd","dbqca"]
//输出：1
//解释：字链["abcd"]是最长的字链之一。
//["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] 仅由小写英文字母组成。 
// 
//
// Related Topics 数组 哈希表 双指针 字符串 动态规划 👍 255 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class LongestStringChain_One048 {
    public static void main(String[] args) {
        Solution solution = new LongestStringChain_One048().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestStrChain(String[] words) {
            int n = words.length;
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }

            Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());

            int ans = 0;
            for (int i = 1; i < n; i++) {
                int path = 0;
                for (int j = 0; j < i; j++) {
                    if (check(words[j], words[i])) {
                        path = Math.max(path, dp[j]);
                    }
                }
                dp[i] = path + 1;
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        private boolean check(String front, String back) {
            if (back.length() - front.length() != 1) {
                return false;
            }
            int i = 0;
            int j = 0;
            boolean get = false;
            while (i < front.length()) {
                if (front.charAt(i) != back.charAt(j)) {
                    if (get) {
                        return false;
                    }
                    get = true;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}