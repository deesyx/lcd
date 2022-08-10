//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
// Related Topics 数学 字符串 模拟 👍 140 👎 0


package leetcode.editor.cn;

public class SolveTheEquation_Six40 {
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation_Six40().new Solution();
        solution.solveEquation("2x+3x-6x=x+2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            int factor = 0;
            int val = 0;
            int i = 0;
            int signFactor = 1;
            int signVal = -1;
            int operator = 1;
            while (i < equation.length()) {
                if (Character.isDigit(equation.charAt(i))) {
                    int num = 0;
                    while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                        num = num * 10 + (equation.charAt(i) - '0');
                        i++;
                    }
                    if (i < equation.length() && equation.charAt(i) == 'x') {
                        factor += operator * signFactor * num;
                        i++;
                    } else {
                        val += operator * signVal * num;
                    }
                } else if (equation.charAt(i) == 'x') {
                    factor += operator * signFactor;
                    i++;
                } else if (equation.charAt(i) == '+') {
                    operator = 1;
                    i++;
                } else if (equation.charAt(i) == '-') {
                    operator = -1;
                    i++;
                } else if (equation.charAt(i) == '=') {
                    signFactor = -1;
                    signVal = 1;
                    operator = 1;
                    i++;
                }
            }

            if (factor == 0) {
                if (val == 0) {
                    return "Infinite solutions";
                } else {
                    return "No solution";
                }
            }

            return String.format("x=%d", val / factor);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}