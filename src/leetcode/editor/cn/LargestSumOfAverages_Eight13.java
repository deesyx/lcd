//给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。 
//
// 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。 
//
// 返回我们所能得到的最大 分数 是多少。答案误差在 10⁻⁶ 内被视为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [9,1,2,3,9], k = 3
//输出: 20.00000
//解释: 
//nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20. 
//我们也可以把 nums 分成[9, 1], [2], [3, 9]. 
//这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 4
//输出: 20.50000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 数组 动态规划 前缀和 👍 292 👎 0


package leetcode.editor.cn;

public class LargestSumOfAverages_Eight13 {
    public static void main(String[] args) {
        Solution solution = new LargestSumOfAverages_Eight13().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // dp[i][j] 表示 nums 在区间 [0, i-1] 被切分成 j 个子数组的最大平均值和
    class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            int n = nums.length;
            double[] sums = new double[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            double[][] dp = new double[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][1] = sums[i] / i;
            }

            for (int j = 2; j <= k; j++) {
                for (int i = j; i <= n; i++) { // i>=j
                    for (int x = j - 1; x < i; x++) { // 将区间 [0, i - 1]分成 [0, x - 1]和 [x, i - 1]两个部分
                        // dp[x][j - 1]:j-1份的最大分数
                        // (sums[i] - sums[x]) / (i - x):最后一份提供的分数
                        dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (sums[i] - sums[x]) / (i - x));
                    }
                }
            }
            return dp[n][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}