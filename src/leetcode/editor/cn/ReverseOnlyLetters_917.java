//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
//
// Related Topics 双指针 字符串 👍 223 👎 0


package leetcode.editor.cn;

public class ReverseOnlyLetters_917 {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters_917().new Solution();
        solution.reverseOnlyLetters("ab-cd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                while (i < j && !Character.isLetter(chars[i])) {
                    i++;
                }
                while (i < j && !Character.isLetter(chars[j])) {
                    j--;
                }
                if (i == j) {
                    break;
                }
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}