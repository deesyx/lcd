//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1097 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters_316().new Solution();
        solution.removeDuplicateLetters("cbacdcbc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] m = new int[26];
            for (int i = 0; i < s.length(); i++) {
                m[s.charAt(i) - 'a']++;
            }

            Set<Character> set = new HashSet<>();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                    set.add(c);
                    continue;
                }

                if (set.contains(c)) {
                    m[c - 'a']--;
                    continue;
                }

                while (!stack.isEmpty() && stack.peek() > c && m[stack.peek() - 'a'] > 1) {
                    char pop = stack.pop();
                    set.remove(pop);
                    m[pop - 'a']--;
                }

                stack.push(c);
                set.add(c);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}