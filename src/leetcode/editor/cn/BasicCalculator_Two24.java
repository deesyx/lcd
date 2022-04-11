//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
// Related Topics 栈 递归 数学 字符串 👍 743 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator_Two24 {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator_Two24().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Character, Integer> m = new HashMap<>();

        public int calculate(String s) {
            if (s == null || s.length() == 0) return 0;
            m.put('*', 2);
            m.put('/', 2);
            m.put('+', 1);
            m.put('-', 1);
            s = '0' + s;

            Stack<Integer> nums = new Stack<>();   //数字栈
            Stack<Character> ops = new Stack<>();   //操作符栈
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                    continue;
                }
                if (Character.isDigit(c)) {            //字符串转化数字
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        int n = s.charAt(i) - '0';
                        num = num * 10 + n;
                        i++;
                    }
                    nums.push(num);            //数字直接存入栈中
                } else if (c == '(') {        //左括号直接存入
                    ops.push(c);
                    i++;
                } else if (c == ')') {        //遇到右括号
                    while (ops.peek() != '(') {        //对栈顶两数字进行运算
                        int num = operation(ops.pop(), nums.pop(), nums.pop());
                        nums.push(num);
                    }
                    ops.pop();
                    i++;
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {   //遇到操作符
                    // 栈顶操作符优先级大于等于当前操作符优先级的话先进行计算，因为优先级高的先算或优先级相等的话从左到右算
                    while (!ops.isEmpty() && ops.peek() != '(' && stackPeekPriorityHigherThanCurrent(ops.peek(), c)) {
                        int num = operation(ops.pop(), nums.pop(), nums.pop());
                        nums.push(num);
                    }
                    // 算完之后再保存当前操作符
                    ops.push(c);
                    i++;
                }
            }
            while (!ops.isEmpty()) {    //取出栈顶的数字进行操作
                // 全是同级运算
                int num = operation(ops.pop(), nums.pop(), nums.pop());
                nums.push(num);
            }
            return nums.pop();
        }

        private int operation(char op, int b, int a) {
            switch (op) {
                case '+':
                    return a + b;   //加法
                case '-':
                    return a - b;   //减法
                case '*':
                    return a * b;   //乘法
                case '/':
                    return a / b;   //除法
            }
            return 0;
        }

        private boolean stackPeekPriorityHigherThanCurrent(char stackPeek, char cur) {
            return m.get(stackPeek) >= m.get(cur);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
