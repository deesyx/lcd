//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1796 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_Five60 {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK_Five60().new Solution();
        solution.subarraySum(new int[]{1, 1, 1}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sums = new int[nums.length + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            Map<Integer, Integer> m = new HashMap<>();
            int ans = 0;
            m.put(k, 1);
            for (int i = 1; i < sums.length; i++) {
                if (m.containsKey(sums[i])) {
                    ans += m.get(sums[i]);
                }

                int preSum = sums[i] + k;
                m.put(preSum, m.getOrDefault(preSum, 0) + 1);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}