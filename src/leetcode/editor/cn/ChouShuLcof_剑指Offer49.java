//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 420 👎 0


package leetcode.editor.cn;

public class ChouShuLcof_剑指Offer49 {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof_剑指Offer49().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1;
            int p3 = 1;
            int p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = 2 * dp[p2];
                int num3 = 3 * dp[p3];
                int num5 = 5 * dp[p5];

                dp[i] = Math.min(num2, Math.min(num3, num5));
                if (dp[i] == num2) {
                    p2++;
                }
                if (dp[i] == num3) {
                    p3++;// 如果num2==num3，那么跳过
                }
                if (dp[i] == num5) {
                    p5++;
                }
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}