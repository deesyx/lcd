//给你一个整数数组 nums 。 
//
// 返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,4,3,3,2] 
// 
//
// 输出：2 
//
// 解释： 
//
// nums 中严格递增的子数组有[1]、[2]、[3]、[3]、[4] 以及 [1,4] 。 
//
// nums 中严格递减的子数组有[1]、[2]、[3]、[3]、[4]、[3,2] 以及 [4,3] 。 
//
// 因此，返回 2 。 
//
// 示例 2： 
//
// 
// 输入：nums = [3,3,3,3] 
// 
//
// 输出：1 
//
// 解释： 
//
// nums 中严格递增的子数组有 [3]、[3]、[3] 以及 [3] 。 
//
// nums 中严格递减的子数组有 [3]、[3]、[3] 以及 [3] 。 
//
// 因此，返回 1 。 
//
// 示例 3： 
//
// 
// 输入：nums = [3,2,1] 
// 
//
// 输出：3 
//
// 解释： 
//
// nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。 
//
// nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。 
//
// 因此，返回 3 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 1 <= nums[i] <= 50 
// 
//
// Related Topics 数组 👍 10 👎 0


package leetcode.editor.cn;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_3105 {
    public static void main(String[] args) {
        Solution solution = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_3105().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int count = 1;
            int maxIncrease = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] >= nums[i + 1]) {
                    maxIncrease = Math.max(maxIncrease, count);
                    count = 1;
                    continue;
                }
                count++;
            }
            maxIncrease = Math.max(maxIncrease, count);

            count = 1;
            int maxDecrease = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] <= nums[i + 1]) {
                    maxDecrease = Math.max(maxDecrease, count);
                    count = 1;
                    continue;
                }
                count++;
            }
            maxDecrease = Math.max(maxDecrease, count);

            return Math.max(maxIncrease, maxDecrease);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}