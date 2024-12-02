//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// 👍 3228 👎 0


package leetcode.editor.cn;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix_14().new Solution();
        solution.longestCommonPrefix(new String[]{"a"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        class TrieNode {
            int count = 1;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root = new TrieNode();

        public String longestCommonPrefix(String[] strs) {
            for (String str : strs) {
                build(str);
            }

            StringBuilder sb = new StringBuilder();
            dfs(sb, root, strs.length);

            return sb.toString();
        }

        private void build(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                } else {
                    node.children[c - 'a'].count++;
                }
                node = node.children[c - 'a'];
            }
        }

        private void dfs(StringBuilder sb, TrieNode node, int target) {
            TrieNode[] childs = node.children;
            for (int i = 0; i < childs.length; i++) {
                TrieNode child = childs[i];
                if (child != null && child.count == target) {
                    sb.append((char) ('a' + i));
                    dfs(sb, child, target);
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}