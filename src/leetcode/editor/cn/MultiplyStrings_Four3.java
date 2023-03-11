//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1162 👎 0


package leetcode.editor.cn;

public class MultiplyStrings_Four3 {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings_Four3().new Solution();
        for (int i = 9; i >= 1; i--) {
            System.out.println(987654321L * i);
        }
        solution.multiply("123456789", "987654321");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            String shorter;
            String longer;
            if (num1.length() <= num2.length()) {
                shorter = num1;
                longer = num2;
            } else {
                shorter = num2;
                longer = num1;
            }

            if (shorter.charAt(0) == '0') {
                return "0";
            }

            String ans = "0";
            int length = shorter.length();
            for (int i = length - 1; i >= 0; i--) {
                int n = shorter.charAt(i) - '0';
                StringBuilder t = mul(longer, n);
                t.append("0".repeat(length - 1 - i));
                ans = add(ans, t.toString());
            }
            return ans;
        }

        private StringBuilder mul(String num, int n) {
            StringBuilder ans = new StringBuilder();
            int flag = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                int k = num.charAt(i) - '0';
                int t = n * k + flag;
                if (t >= 10) {
                    flag = t / 10;
                    t = t % 10;
                } else {
                    flag = 0;
                }
                ans.append(t);
            }
            if (flag > 0) {
                ans.append(flag);
            }
            return ans.reverse();
        }

        private String add(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            StringBuilder ans = new StringBuilder();
            int flag = 0;
            while (i >= 0 && j >= 0) {
                int v1 = num1.charAt(i--) - '0';
                int v2 = num2.charAt(j--) - '0';

                int t = v1 + v2 + flag;
                if (t >= 10) {
                    t -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                ans.append(t);
            }

            while (i >= 0) {
                int v = num1.charAt(i--) - '0';
                int t = v + flag;
                if (t >= 10) {
                    t -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                ans.append(t);
            }

            while (j >= 0) {
                int v = num2.charAt(j--) - '0';
                int t = v + flag;
                if (t >= 10) {
                    t -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                ans.append(t);
            }

            if (flag != 0) {
                ans.append(flag);
            }

            return ans.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}