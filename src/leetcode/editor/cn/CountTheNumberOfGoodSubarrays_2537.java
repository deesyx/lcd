//给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
//
// 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。 
//
// 子数组 是原数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,1,1,1], k = 10
//输出：1
//解释：唯一的好子数组是这个数组本身。
// 
//
// 示例 2： 
//
// 输入：nums = [3,1,4,3,2,2,4], k = 2
//输出：4
//解释：总共有 4 个不同的好子数组：
//- [3,1,4,3,2,2] 有 2 对。
//- [3,1,4,3,2,2,4] 有 3 对。
//- [1,4,3,2,2,4] 有 2 对。
//- [4,3,2,2,4] 有 2 对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 76 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays_2537 {
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfGoodSubarrays_2537().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countGood(int[] nums, int k) {
            int ans = 0;
            int left = 0;
            int right = 0;
            Map<Integer, Integer> m = new HashMap<>();
            int pairs = 0;
            while (right < nums.length) {
                int in = nums[right++];
                Integer pairCount = m.getOrDefault(in, 0);
                pairs += pairCount;
                m.put(in, pairCount + 1);
                while (pairs >= k) {
                    int out = nums[left++];
                    Integer pairCount2 = m.get(out);
                    pairs -= pairCount2 - 1;
                    m.put(out, pairCount2 - 1);
                }
                ans += left;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}