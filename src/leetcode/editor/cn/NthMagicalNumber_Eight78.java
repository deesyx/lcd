//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
// Related Topics 数学 二分查找 👍 161 👎 0


package leetcode.editor.cn;

public class NthMagicalNumber_Eight78 {
    public static void main(String[] args) {
        Solution solution = new NthMagicalNumber_Eight78().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthMagicalNumber(int n, int a, int b) {
            int mod = (int) 1e9 + 7;
            int c = lcm(a, b);
            long left = 0;
            long right = (long) 1e18;
            while (left < right) {
                long mid = left + right >> 1;
                if (mid / a + mid / b - mid / c >= n) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return (int) (left % mod);
        }

        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}