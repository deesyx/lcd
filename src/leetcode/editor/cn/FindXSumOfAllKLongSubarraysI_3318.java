//给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。 
//
// 数组的 x-sum 计算按照以下步骤进行： 
//
// 
// 统计数组中所有元素的出现次数。 
// 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。 
// 计算结果数组的和。 
// 
//
// 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。 
//
// 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
// 
//
// 子数组 是数组内的一个连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2 
// 
//
// 输出：[6,10,12] 
//
// 解释： 
//
// 
// 对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。 
// 对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为
//其数值大于出现其他出现次数相同的元素（3 和 1）。 
// 对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [3,8,7,8,7,5], k = 2, x = 2 
// 
//
// 输出：[11,15,15,15,12] 
//
// 解释： 
//
// 由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 50 
// 1 <= nums[i] <= 50 
// 1 <= x <= k <= nums.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 5 👎 0


package leetcode.editor.cn;

import java.util.*;

public class FindXSumOfAllKLongSubarraysI_3318 {
    public static void main(String[] args) {
        Solution solution = new FindXSumOfAllKLongSubarraysI_3318().new Solution();
        solution.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findXSum(int[] nums, int k, int x) {
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < ans.length; i++) {
                Map<Integer, Integer> m = new HashMap<>();
                for (int j = i; j < i + k; j++) {
                    m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);
                }

                PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
                    if (Objects.equals(o1.getValue(), o2.getValue())) {
                        return o2.getKey() - o1.getKey();
                    } else {
                        return o2.getValue() - o1.getValue();
                    }
                });

                pq.addAll(m.entrySet());

                int n = x;
                while (n > 0) {
                    Map.Entry<Integer, Integer> e1 = pq.poll();
                    if (e1 != null) {
                        ans[i] += e1.getKey() * m.get(e1.getKey());
                    }
                    n--;
                }
            }

            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}