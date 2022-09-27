////给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
////
//// 示例 1： 
////
//// 输入: s1 = "abc", s2 = "bca"
////输出: true 
//// 
////
//// 示例 2： 
////
//// 输入: s1 = "abc", s2 = "bad"
////输出: false
//// 
////
//// 说明： 
////
//// 
//// 0 <= len(s1) <= 100 
//// 0 <= len(s2) <= 100 
//// 
//// Related Topics 哈希表 字符串 排序 👍 110 👎 0
//


package leetcode.editor.cn;

import java.util.Arrays;

public class CheckPermutationLcci_面试题01_02 {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci_面试题01_02().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }

            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            Arrays.sort(c1);
            Arrays.sort(c2);

            for (int i = 0; i < s1.length(); i++) {
                if (c1[i] != c2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}