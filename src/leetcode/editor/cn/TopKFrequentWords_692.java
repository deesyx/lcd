//给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。 
//
// 
//
// 示例 1： 
//
// 
//输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 
//k = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i] <= 10 
// words[i] 由小写英文字母组成。 
// k 的取值范围是 [1, 不同 words[i] 的数量] 
// 
//
// 
//
// 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
//
// Related Topics 字典树 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 615 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentWords_692 {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords_692().new Solution();
        solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int count = 0;
            String word;
        }

        private TrieNode root = new TrieNode();

        public List<String> topKFrequent(String[] words, int k) {
            for (String word : words) {
                add(word);
            }

            List<TrieNode> q = new ArrayList<>();

            find(root, q);

            List<String> ans = q.stream().sorted((a, b) -> {
                if (a.count != b.count) {
                    return b.count - a.count;
                } else {
                    return a.word.compareTo(b.word);
                }
            }).map(it -> it.word).collect(Collectors.toList());

            return ans.subList(0, k);
        }

        private void add(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.count++;
            node.word = word;
        }

        private void find(TrieNode node, List<TrieNode> q) {
            if (node == null) {
                return;
            }

            if (node.count > 0) {
                q.add(node);
            }

            for (TrieNode child : node.children) {
                if (child == null) {
                    continue;
                }
                find(child, q);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}