//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1953 👎 0


package leetcode.editor.cn;

import java.util.concurrent.ConcurrentHashMap;

public class JumpGameIi_Four5 {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi_Four5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];

            for (int i = 1; i < nums.length; i++) {
                dp[i] = -1;
            }

            for (int i = 1; i < nums.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dp[j] == -1) {
                        continue;
                    }

                    if (j + nums[j] >= i) {
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }

            return dp[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}