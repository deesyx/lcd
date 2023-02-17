//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// Related Topics 栈 数学 字符串 👍 659 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorIi_Two27 {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi_Two27().new Solution();
        solution.calculate("3+2*2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Stack<Character> ops = new Stack<>();
        private Stack<Integer> nums = new Stack<>();

        Map<Character, Integer> m = new HashMap<>();

        public int calculate(String s) {
            m.put('*', 2);
            m.put('/', 2);
            m.put('+', 1);
            m.put('-', 1);

            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                }

                if (isNum(s.charAt(i))) {
                    int num = 0;
                    while (i < s.length() && isNum(s.charAt(i))) {
                        num = num * 10 + toInt(s.charAt(i));
                        i++;
                    }
                    nums.push(num);
                    continue;
                }

                char curOp = s.charAt(i);
                while (!ops.isEmpty() && m.get(ops.peek()) >= m.get(curOp)) {
                    nums.push(eval());
                }
                ops.push(curOp);
                i++;
            }

            while (!ops.isEmpty()) {
                nums.push(eval());
            }
            return nums.pop();
        }

        private int eval() {
            int b = nums.pop();
            int a = nums.pop();
            char op = ops.pop();
            if (op == '-') {
                return a - b;
            }
            if (op == '+') {
                return a + b;
            }
            if (op == '/') {
                return a / b;
            }
            return a * b;
        }

        private boolean isNum(char c) {
            return c >= '0' && c <= '9';
        }

        private int toInt(char c) {
            return c - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}