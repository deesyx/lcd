//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 👍 128 👎 0


package leetcode.editor.cn;

public class LongestUncommonSubsequenceIi_Five22 {
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi_Five22().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            int ans = -1;
            for (int i = 0; i < strs.length; i++) {
                boolean check = true;
                for (int j = 0; j < strs.length; j++) {
                    if (i != j && isSub(strs[i], strs[j])) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    ans = Math.max(strs[i].length(), ans);
                }
            }
            return ans;
        }

        private boolean isSub(String sub, String parent) {
            if (parent.length() < sub.length()) {
                return false;
            }
            int i = 0;
            int j = 0;
            while (i < sub.length() && j < parent.length()) {
                if (sub.charAt(i) == parent.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == sub.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
