//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 01背包 👍 1572 👎 0


package leetcode.editor.cn;

public class PartitionEqualSubsetSum_Four16 {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum_Four16().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i][j]表示从nums中选择前0到i个元素使得和为j的个数
     * dp[i][j]=dp[i-1][j](不选i) || dp[i-1][j-nums[i]](选了i) j>=nums[i]
     * dp[i][j]=dp[i-1][j] j<nums[i]
     */
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return false;
            }
            int sum = 0;
            int max = 0;
            for (int i : nums) {
                sum += i;
                max = Math.max(max, i);
            }

            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }

            boolean[][] dp = new boolean[n + 1][target + 1];
            dp[0][0] = true;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= target; j++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }

            return dp[n][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}