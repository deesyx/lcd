//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// Related Topics 数学 字符串 模拟 👍 96 👎 0


package leetcode.editor.cn;

import java.lang.module.FindException;

public class FractionAdditionAndSubtraction_Five92 {
    public static void main(String[] args) {
        Solution solution = new FractionAdditionAndSubtraction_Five92().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String expression) {
            long denominator = 0;
            long numerator = 1;
            int i = 0;
            int n = expression.length();
            while (i < n) {
                long denominator1 = 0;
                int sign = 1;
                if (expression.charAt(i) == '-') {
                    sign = -1;
                    i++;
                }
                if (expression.charAt(i) == '+') {
                    sign = 1;
                    i++;
                }
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    denominator1 = denominator1 * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                denominator1 = denominator1 * sign;
                i++;// 除号

                long numerator1 = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    numerator1 = numerator1 * 10 + (expression.charAt(i) - '0');
                    i++;
                }

                denominator = denominator * numerator1 + denominator1 * numerator;
                numerator = numerator * numerator1;
            }

            if (denominator == 0) {
                return "0/1";
            }

            long gcd = gcd(Math.abs(denominator), numerator);
            long ansd = denominator / gcd;
            long ansn = numerator / gcd;
            return ansd + "/" + ansn;
        }

        private long gcd(long a, long b) {
            long reminder = a % b;
            while (reminder != 0) {
                a = b;
                b = reminder;
                reminder = a % b;
            }
            return b;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}