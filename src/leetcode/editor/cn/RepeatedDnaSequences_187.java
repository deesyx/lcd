//DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。 
//
// 
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i]=='A'、'C'、'G' or 'T' 
// 
//
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 591 👎 0


package leetcode.editor.cn;

import java.util.*;

public class RepeatedDnaSequences_187 {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences_187().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() < 10) {
                return new ArrayList<>();
            }

            List<String> ans = new ArrayList<>();
            Map<String, Integer> m = new HashMap<>();
            for (int i = 0; i + 10 <= s.length(); i++) {
                String path = s.substring(i, i + 10);
                if (m.containsKey(path)) {
                    int count = m.get(path);
                    if (count == 1) {
                        ans.add(path);
                    }
                    m.put(path, count + 1);
                } else {
                    m.put(path, 1);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}