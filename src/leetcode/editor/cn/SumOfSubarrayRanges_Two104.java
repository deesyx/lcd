//给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。 
//
// 返回 nums 中 所有 子数组范围的 和 。 
//
// 子数组是数组中一个连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0 
//[2]，范围 = 2 - 2 = 0
//[3]，范围 = 3 - 3 = 0
//[1,2]，范围 = 2 - 1 = 1
//[2,3]，范围 = 3 - 2 = 1
//[1,2,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0
//[3]，范围 = 3 - 3 = 0
//[3]，范围 = 3 - 3 = 0
//[1,3]，范围 = 3 - 1 = 2
//[3,3]，范围 = 3 - 3 = 0
//[1,3,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
// 
//
// 示例 3： 
//
// 
//输入：nums = [4,-2,-3,4,1]
//输出：59
//解释：nums 中所有子数组范围的和是 59
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？ 
// Related Topics 栈 数组 单调栈 👍 235 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SumOfSubarrayRanges_Two104 {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayRanges_Two104().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;

        public long subArrayRanges(int[] nums) {
            n = nums.length;
            long[] max = getCnt(nums, false);
            long[] min = getCnt(nums, true);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (max[i] - min[i]) * nums[i];
            }
            return ans;
        }

        long[] getCnt(int[] nums, boolean isMin) {
            int[] left = new int[n];
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && (isMin ? nums[s.peek()] >= nums[i] : nums[s.peek()] <= nums[i])) {
                    s.pop();
                }
                left[i] = s.isEmpty() ? -1 : s.peek();
                s.push(i);
            }
            s.clear();
            int[] right = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (!s.isEmpty() && (isMin ? nums[s.peek()] > nums[i] : nums[s.peek()] < nums[i])) {
                    s.pop();
                }
                right[i] = s.isEmpty() ? n : s.peek();
                s.push(i);
            }

            long[] ans = new long[n];
            for (int i = 0; i < n; i++) {
                ans[i] = (long) (i - left[i]) * (right[i] - i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}