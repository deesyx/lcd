//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 380 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK_Eight62 {
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK_Eight62().new Solution();
        System.out.println(solution.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            long[] sums = new long[nums.length + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            LinkedList<Integer> q = new LinkedList<>();// 保存sums的下标
            int len = Integer.MAX_VALUE;
            for (int i = 0; i < sums.length; i++) {
                while (!q.isEmpty() && sums[q.peekLast()] >= sums[i]) {
                    // 保证由sums和q组成的sumsQ是单调增的序列
                    // sums[targetIndex]-sums[q.peekLast()] < sums[targetIndex]-sums[i] targetIndex使得sums[targetIndex]>=k
                    q.pollLast();
                }
                while (!q.isEmpty() && sums[i] - sums[q.peekFirst()] >= k) {
                    len = Math.min(len, i - q.pollFirst());
                }
                q.addLast(i);
            }
            return len == Integer.MAX_VALUE ? -1 : len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
