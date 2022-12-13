//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
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
// Related Topics 数组 哈希表 字符串 排序 👍 1330 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams_Four9 {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams_Four9().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Data {
        String str;

        public Data(String str) {
            this.str = str;
        }

        private String order() {
            char[] chars = this.str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data other = (Data) obj;
            return this.order().equals(other.order());
        }

        @Override
        public int hashCode() {
            return this.order().hashCode();
        }
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
//            return Arrays.stream(strs).map(Data::new)
//                    .collect(Collectors.groupingBy(it -> it))
//                    .values().stream().map(it -> it.stream().map(d -> d.str).collect(Collectors.toList())).collect(Collectors.toList());

            return new ArrayList<>(Arrays.stream(strs)
                    .collect(Collectors.groupingBy(it -> {
                        char[] chars = it.toCharArray();
                        Arrays.sort(chars);
                        return new String(chars);
                    })).values());

//            Map<String, List<String>> ans = new HashMap<>();
//            for (String str : strs) {
//                int[] m = new int[26];
//                for (char c : str.toCharArray()) {
//                    m[c - 'a']++;
//                }
//                StringBuilder key = new StringBuilder();
//                for (int i = 0; i < 26; i++) {
//                    if (m[i] == 0) {
//                        continue;
//                    }
//                    key.append(String.format("%d%s", m[i], 'a' + i));
//                }
//                String keyStr = key.toString();
//                if (ans.containsKey(keyStr)) {
//                    ans.get(keyStr).add(str);
//                } else {
//                    ArrayList<String> list = new ArrayList<>();
//                    list.add(str);
//                    ans.put(keyStr, list);
//                }
//            }
//            return new ArrayList<>(ans.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}