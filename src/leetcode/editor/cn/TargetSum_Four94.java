//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1490 👎 0


package leetcode.editor.cn;

public class TargetSum_Four94 {
    public static void main(String[] args) {
        Solution solution = new TargetSum_Four94().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] dirs = new int[]{1, -1};
        private int path = 0;
        private int ans = 0;

        public int findTargetSumWays(int[] nums, int target) {
            // dp[i][j]表示从nums中选择前0到i个元素使得和为j的个数
            // dp[i][j]=dp[i-1][j-nums[i](选择+)]+dp[i-1][j+nums[i](选择-)]

            int sum = 0;
            for (int n : nums) sum += n;
            if (Math.abs(target) > sum) return 0;

            // 假如sum=1，范围为[-1,1]，右移(因为下标j不能为负数)，-1，0，1 -> 0，1，2
            int[][] dp = new int[nums.length + 1][2 * sum + 1];
            dp[0][0 + sum] = 1;
            for (int i = 1; i <= nums.length; i++) {
                int cur = nums[i - 1];
                for (int j = 0; j <= 2 * sum; j++) {
                    if (j - cur >= 0) {
                        dp[i][j] += dp[i - 1][j - cur];
                    }
                    if (j + cur <= 2 * sum) {
                        dp[i][j] += dp[i - 1][j + cur];
                    }
                }
            }

            return dp[nums.length][target + sum];

//            dfs(nums, target, 0);
//            return ans;
        }

        private void dfs(int[] nums, int target, int i) {
            if (i >= nums.length) {
                if (path == target) {
                    ans++;
                }
                return;
            }

            for (int dir : dirs) {
                int cur = dir * nums[i];
                path += cur;
                dfs(nums, target, i + 1);
                path -= cur;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}