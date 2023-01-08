//给你一个字符串数组 words 和一个字符串 pref 。 
//
// 返回 words 中以 pref 作为 前缀 的字符串的数目。 
//
// 字符串 s 的 前缀 就是 s 的任一前导连续字符串。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["pay","attention","practice","attend"], pref = "at"
//输出：2
//解释：以 "at" 作为前缀的字符串有两个，分别是："attention" 和 "attend" 。
// 
//
// 示例 2： 
//
// 输入：words = ["leetcode","win","loops","success"], pref = "code"
//输出：0
//解释：不存在以 "code" 作为前缀的字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length, pref.length <= 100 
// words[i] 和 pref 由小写英文字母组成 
// 
// Related Topics 数组 字符串 👍 17 👎 0


package leetcode.editor.cn;

public class CountingWordsWithAGivenPrefix_Two185 {
    public static void main(String[] args) {
        Solution solution = new CountingWordsWithAGivenPrefix_Two185().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int count = 0;
        }

        private void add(TrieNode root, String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.count++;
            }
        }

        private int find(TrieNode root, String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return 0;
                }
                node = node.children[c - 'a'];
            }
            return node.count;
        }

        public int prefixCount(String[] words, String pref) {
            TrieNode root = new TrieNode();
            for (String word : words) {
                add(root, word);
            }
            return find(root, pref);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}