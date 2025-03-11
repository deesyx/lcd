//给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
//
//
// 
// 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k] 
//
// 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件 
// 0，如果上述条件全部不满足 
// 
//
// 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：2
//解释：对于每个符合范围 1 <= i <= 1 的下标 i :
//- nums[1] 的美丽值等于 2
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6,4]
//输出：1
//解释：对于每个符合范围 1 <= i <= 2 的下标 i :
//- nums[1] 的美丽值等于 1
//- nums[2] 的美丽值等于 0
// 
//
// 示例 3： 
//
// 输入：nums = [3,2,1]
//输出：0
//解释：对于每个符合范围 1 <= i <= 1 的下标 i :
//- nums[1] 的美丽值等于 0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 👍 25 👎 0


package leetcode.editor.cn;

public class SumOfBeautyInTheArray_2012 {
    public static void main(String[] args) {
        Solution solution = new SumOfBeautyInTheArray_2012().new Solution();
        solution.sumOfBeauties(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfBeauties(int[] nums) {
            int[] suffMin = new int[nums.length];
            suffMin[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
            }

            int preMax = nums[0];
            int ans = 0;
            for (int i = 1; i <= nums.length - 2; i++) {
                if (nums[i] > preMax && nums[i] < suffMin[i + 1]) {
                    ans += 2;
                } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                    ans++;
                }

                preMax = Math.max(preMax, nums[i]);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}