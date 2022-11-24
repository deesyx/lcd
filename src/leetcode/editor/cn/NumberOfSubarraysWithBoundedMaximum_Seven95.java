//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
// Related Topics 数组 双指针 👍 263 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class NumberOfSubarraysWithBoundedMaximum_Seven95 {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubarraysWithBoundedMaximum_Seven95().new Solution();
        solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            // 单调栈
            // [frontIndex, frontMatchIndex...cur...backMatchIndex, backIndex]
            // nums[frontMatchIndex]<nums[cur], nums[cur]>nums[backMatchIndex]
            // nums[frontIndex]>=nums[cur], nums[cur]<=nums[backIndex]
            // cur贡献值=(cur-frontMatchIndex+1)*(backMatchIndex-cur+1) 前面的个数*后面的个数
            // 边界frontIndex=-1, backIndex=nums.length
            Stack<Integer> s = new Stack<>();
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (s.isEmpty()) {
                    s.push(i);
                    continue;
                }

                int cur = nums[i];
                while (!s.isEmpty() && cur >= nums[s.peek()]) {
                    if (nums[s.peek()] > right || nums[s.peek()] < left) {
                        s.pop();
                    } else {
                        int pop = s.pop();
                        int frontIndex = -1;
                        if (!s.isEmpty()) {
                            frontIndex = s.peek();
                        }
                        ans += (pop - frontIndex) * (i - pop);
                    }
                }
                s.push(i);
            }

            int backIndex = nums.length;
            while (!s.isEmpty()) {
                int pop = s.pop();
                if (nums[pop] > right || nums[pop] < left) {
                    continue;
                }
                int frontIndex = -1;
                if (!s.isEmpty()) {
                    frontIndex = s.peek();
                }
                ans += (pop - frontIndex) * (backIndex - pop);
            }
            return ans;

//            return f(nums, right) - f(nums, left - 1);
        }

        private int f(int[] nums, int x) {
            int count = 0;
            int t = 0;
            for (int n : nums) {
                if (n <= x) {
                    t++;
                } else {
                    t = 0;
                }
                count += t;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}