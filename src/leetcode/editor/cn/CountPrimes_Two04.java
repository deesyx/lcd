//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 925 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class CountPrimes_Two04 {
    public static void main(String[] args) {
        Solution solution = new CountPrimes_Two04().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                if (isPrime[i]) {
                    ans++;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) { // 从i*i开始标记，因为2i，3i一定是2或3的倍数，被标记过了
                            isPrime[j] = false;
                        }
                    }
                }
            }
            return ans;
        }

        private boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}