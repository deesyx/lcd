//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，
//返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出
//[null, 0]
//解释
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 7 
// 1 <= pref.length, suff.length <= 7 
// words[i]、pref 和 suff 仅由小写英文字母组成 
// 最多对函数 f 执行 10⁴ 次调用 
// 
// Related Topics 设计 字典树 字符串 👍 136 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrefixAndSuffixSearch_Seven45 {
    public static void main(String[] args) {
//        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
//        wordFilter.f("a", "e");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordFilter {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<Integer> idxs = new ArrayList<>();
        }

        public void add(TrieNode node, String word, int index, boolean isTurn) {
            node.idxs.add(index);
            int n = word.length();
            for (int i = isTurn ? n - 1 : 0; i >= 0 && i < n; i += isTurn ? -1 : 1) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.idxs.add(index);
            }
        }

        public List<Integer> find(TrieNode node, String s, boolean isTurn) {
            int n = s.length();
            for (int i = isTurn ? n - 1 : 0; i >= 0 && i < n; i += isTurn ? -1 : 1) {
                char c = s.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return Collections.emptyList();
                }
                node = node.children[c - 'a'];
            }
            return node.idxs;
        }

        private TrieNode t1 = new TrieNode();
        private TrieNode t2 = new TrieNode();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                add(t1, words[i], i, false);
                add(t2, words[i], i, true);
            }
        }

        public int f(String pref, String suff) {
            List<Integer> ans1 = find(t1, pref, false);
            if (ans1.isEmpty()) {
                return -1;
            }
            List<Integer> ans2 = find(t2, suff, true);
            if (ans2.isEmpty()) {
                return -1;
            }

            int n = ans1.size();
            int m = ans2.size();
            for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
                if (ans1.get(i) > ans2.get(j)) {
                    i--;
                } else if (ans2.get(j) > ans1.get(i)) {
                    j--;
                } else {
                    return ans1.get(i);
                }
            }
            return -1;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
//leetcode submit region end(Prohibit modification and deletion)

}