//给你一个正整数 n。请判断 n 是否可以被以下两值之和 整除： 
//
// 
// n 的 数字和（即其各个位数之和）。 
// n 的 数字积（即其各个位数之积）。 
// 
//
// 如果 n 能被该和整除，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 99 
// 
//
// 输出： true 
//
// 解释： 
//
// 因为 99 可以被其数字和 (9 + 9 = 18) 与数字积 (9 * 9 = 81) 之和 (18 + 81 = 99) 整除，因此输出为 true。
// 
//
// 示例 2： 
//
// 
// 输入： n = 23 
// 
//
// 输出： false 
//
// 解释： 
//
// 因为 23 无法被其数字和 (2 + 3 = 5) 与数字积 (2 * 3 = 6) 之和 (5 + 6 = 11) 整除，因此输出为 false。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁶ 
// 
//
// Related Topics 数学 👍 0 👎 0


package leetcode.editor.cn;

public class CheckDivisibilityByDigitSumAndProduct_3622 {
    public static void main(String[] args) {
        Solution solution = new CheckDivisibilityByDigitSumAndProduct_3622().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkDivisibility(int n) {
            int digitSum = getDigitSum(n);
            int digitProduct = getDigitProduct(n);
            int sum = digitSum + digitProduct;
            return n % sum == 0;
        }

        private int getDigitSum(int n) {
            int sum = 0;
            String s = String.valueOf(n);
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            return sum;
        }

        private int getDigitProduct(int n) {
            int product = 1;
            String s = String.valueOf(n);
            for (int i = 0; i < s.length(); i++) {
                product *= s.charAt(i) - '0';
            }
            return product;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}