//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 915 👎 0


package leetcode.editor.cn;

public class PowxN_Five0 {
    public static void main(String[] args) {
        Solution solution = new PowxN_Five0().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            return n >= 0 ? dfs(x, n) : 1 / dfs(x, n);
        }

        private double dfs(double x, int n) {
            if (n == 0) {
                return 1;
            }

            double ans = dfs(x, n / 2);
            return n % 2 == 0 ? ans * ans : ans * ans * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
