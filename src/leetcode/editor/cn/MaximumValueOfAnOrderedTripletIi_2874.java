//给你一个下标从 0 开始的整数数组 nums 。
//
// 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 
//。 
//
// 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [12,6,1,2,7]
//输出：77
//解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
//可以证明不存在值大于 77 的有序下标三元组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,10,3,4,19]
//输出：133
//解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
//可以证明不存在值大于 133 的有序下标三元组。 
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：0
//解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 👍 42 👎 0


package leetcode.editor.cn;

public class MaximumValueOfAnOrderedTripletIi_2874 {
    public static void main(String[] args) {
        Solution solution = new MaximumValueOfAnOrderedTripletIi_2874().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            int[] sufMax = new int[n + 1];
            for (int i = n - 1; i > 1; i--) {
                sufMax[i] = Math.max(sufMax[i + 1], nums[i]);
            }

            long ans = 0;
            int preMax = nums[0];
            for (int i = 1; i < n - 1; i++) {
                ans = Math.max(ans, (long) (preMax - nums[i]) * sufMax[i + 1]);
                preMax = Math.max(preMax, nums[i]);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}