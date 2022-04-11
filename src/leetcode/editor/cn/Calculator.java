package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    public static class Solution {
        /**
         * @param s: the expression string
         * @return: the answer
         */

        private Map<Character, Integer> m = new HashMap<>();

        public int calculate(String s) {
            // Write your code here
            if (s == null || s.length() == 0) return 0;
            m.put('*', 2);
            m.put('/', 2);
            m.put('+', 1);
            m.put('-', 1);

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
                // 从右到左计算
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
}
