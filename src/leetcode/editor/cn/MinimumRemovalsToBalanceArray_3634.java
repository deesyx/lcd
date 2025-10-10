//给你一个整数数组 nums 和一个整数 k。
//
// 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。 
//
// 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。 
//
// 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。 
//
// 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。 
//
// 
//
// 示例 1: 
//
// 
// 输入：nums = [2,1,5], k = 2 
// 
//
// 输出：1 
//
// 解释： 
//
// 
// 移除 nums[2] = 5 得到 nums = [2, 1]。 
// 现在 max = 2, min = 1，且 max <= min * k，因为 2 <= 1 * 2。因此，答案是 1。 
// 
//
// 示例 2: 
//
// 
// 输入：nums = [1,6,2,9], k = 3 
// 
//
// 输出：2 
//
// 解释： 
//
// 
// 移除 nums[0] = 1 和 nums[3] = 9 得到 nums = [6, 2]。 
// 现在 max = 6, min = 2，且 max <= min * k，因为 6 <= 2 * 3。因此，答案是 2。 
// 
//
// 示例 3: 
//
// 
// 输入：nums = [4,6], k = 2 
// 
//
// 输出：0 
//
// 解释： 
//
// 
// 由于 nums 已经平衡，因为 6 <= 4 * 2，所以不需要移除任何元素。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 数组 排序 滑动窗口 👍 13 👎 0


package leetcode.editor.cn;

public class MinimumRemovalsToBalanceArray_3634 {
    public static void main(String[] args) {
        Solution solution = new MinimumRemovalsToBalanceArray_3634().new Solution();
        
        // 测试示例1
        int[] nums1 = {2, 1, 5};
        int k1 = 2;
        int result1 = solution.minRemoval(nums1, k1);
        System.out.println("示例1: nums = [2,1,5], k = 2, 结果: " + result1 + " (期望: 1)");
        
        // 测试示例2
        int[] nums2 = {1, 6, 2, 9};
        int k2 = 3;
        int result2 = solution.minRemoval(nums2, k2);
        System.out.println("示例2: nums = [1,6,2,9], k = 3, 结果: " + result2 + " (期望: 2)");
        
        // 测试示例3
        int[] nums3 = {4, 6};
        int k3 = 2;
        int result3 = solution.minRemoval(nums3, k3);
        System.out.println("示例3: nums = [4,6], k = 2, 结果: " + result3 + " (期望: 0)");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRemoval(int[] nums, int k) {
            // 对数组排序
            java.util.Arrays.sort(nums);
            
            int n = nums.length;
            int maxLen = 1; // 最长满足条件的子数组长度，至少为1（单元素数组平衡）
            
            // 使用滑动窗口找最长子数组
            int left = 0;
            for (int right = 0; right < n; right++) {
                // 如果当前窗口不满足条件，移动左边界
                while (left <= right && (long)nums[right] > (long)nums[left] * k) {
                    left++;
                }
                
                // 更新最长子数组长度
                if (left <= right) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
            
            // 返回需要移除的最少元素数量
            return n - maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}