//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 991 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_Five81 {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray_Five81().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int max = nums[0];
            int maxLast = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < max) {// 逆序了
                    maxLast = i;
                } else {
                    max = nums[i];
                }
            }

            int min = nums[nums.length - 1];
            int minLast = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > min) {// 逆序了
                    minLast = i;
                } else {
                    min = nums[i];
                }
            }

            return maxLast - minLast + 1;

//            int[] sortNums = Arrays.copyOf(nums, nums.length);
//            Arrays.sort(sortNums);
//
//            int start = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != sortNums[i]) {
//                    start = i;
//                    break;
//                }
//            }
//
//            int end = -1;
//            for (int i = nums.length - 1; i > start; i--) {
//                if (nums[i] != sortNums[i]) {
//                    end = i;
//                    break;
//                }
//            }
//
//            if (end == -1) {
//                return 0;
//            }
//
//            return end - start + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}