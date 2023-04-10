//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
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
//
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
//
// Related Topics 数学 字符串 模拟 👍 78 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NUPfPr_剑指OfferII101 {
    public static void main(String[] args) {
        Solution solution = new NUPfPr_剑指OfferII101().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * dp[i][j]表示从nums中选择前0到i个元素使得和为j的个数
         * dp[i][j]=dp[i-1][j](不选i) || dp[i-1][j-nums[i]](选了i) j>=nums[i]
         * dp[i][j]=dp[i-1][j] j<nums[i]
         */
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int max = 0;
            for (int n : nums) {
                sum += n;
                max = Math.max(max, n);
            }

            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }

            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][target + 1];

            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= target; j++) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n][target];
        }

        private boolean dfs(int[] nums, int start, int target) {
            if (start >= nums.length) {
                return false;
            }
            if (target == 0) {
                return true;
            }
            if (target < 0) {
                return false;
            }

            for (int i = start; i < nums.length; i++) {
                boolean ans = dfs(nums, i + 1, target - nums[i]);
                if (ans) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}