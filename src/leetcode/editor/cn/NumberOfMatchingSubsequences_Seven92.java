//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
// Related Topics 字典树 哈希表 字符串 排序 👍 257 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class NumberOfMatchingSubsequences_Seven92 {
    public static void main(String[] args) {
        Solution solution = new NumberOfMatchingSubsequences_Seven92().new Solution();
        solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numMatchingSubseq(String s, String[] words) {
            Deque<String>[] d = new Deque[26];
            for (int i = 0; i < 26; i++) {
                d[i] = new ArrayDeque<>();
            }

            for (String word : words) {
                d[word.charAt(0) - 'a'].offer(word);
            }

            int ans = 0;
            for (char c : s.toCharArray()) {
                Deque<String> ws = d[c - 'a'];
                int size = ws.size();
                for (int i = 0; i < size; i++) {
                    String w = ws.pop();
                    if (w.length() == 1) {
                        ans++;
                    } else {
                        d[w.charAt(1) - 'a'].offer(w.substring(1));
                    }
                }
            }
            return ans;
        }

        private boolean isSubSeq(String s, String t) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            return j == t.length();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}