//给你一个整数数组 nums 和一个 正整数 k 。
//
// 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。 
//
// 子数组是数组中的一个连续元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,3,3], k = 2
//输出：6
//解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 
//。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,2,1], k = 3
//输出：0
//解释：没有子数组包含元素 4 至少 3 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 数组 滑动窗口 👍 66 👎 0


package leetcode.editor.cn;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962 {
    public static void main(String[] args) {
        Solution solution = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums, int k) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }

            int left = 0;
            int right = 0;
            long ans = 0;
            long count = 0;
            while (right < nums.length) {
                int in = nums[right++];
                if (in == max) {
                    count++;
                }

                while (count == k) {
                    int out = nums[left++];
                    if (out == max) {
                        count--;
                    }
                }

                ans += left;// 当右端点固定在 right 时，左端点在 0,1,2,…,left−1 的所有子数组都是满足要求的
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}