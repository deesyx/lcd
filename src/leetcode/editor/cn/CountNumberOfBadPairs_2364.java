//给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一
//个 坏数对 。 
//
// 请你返回 nums 中 坏数对 的总数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,3,3]
//输出：5
//解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
//数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
//数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
//数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
//数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
//总共有 5 个坏数对，所以我们返回 5 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,5]
//输出：0
//解释：没有坏数对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 47 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs_2364 {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfBadPairs_2364().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countBadPairs(int[] nums) {
            Map<Integer, Integer> m = new HashMap<>();
            long ans = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int x = nums[i] - i;
                int c = m.getOrDefault(x, 0);
                ans += c;
                m.put(x, c + 1);
            }
            return (long) (n - 1) * n / 2 - ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}