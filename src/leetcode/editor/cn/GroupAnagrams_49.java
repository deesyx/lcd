//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2295 👎 0


package leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams_49().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node {
            String str;
            int[] m = new int[26];

            public Node(String str) {
                this.str = str;
                for (int i = 0; i < str.length(); i++) {
                    m[str.charAt(i) - 'a']++;
                }
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(m);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return Arrays.equals(m, node.m);
            }
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Node, List<String>> m = new HashMap<>();
            for (String str : strs) {
                Node node = new Node(str);
                if (!m.containsKey(node)) {
                    m.put(node, new ArrayList<>());
                }
                List<String> list = m.get(node);
                list.add(str);
            }

            return new ArrayList<>(m.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}