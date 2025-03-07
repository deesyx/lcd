//给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
//
// 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。 
//
// 返回数组 nums 中 非空 且 美丽 的子集数目。 
//
// nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的
//子集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,4,6], k = 2
//输出：4
//解释：数组 nums 中的美丽子集有：[2], [4], [6], [2, 6] 。
//可以证明数组 [2,4,6] 中只存在 4 个美丽子集。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：1
//解释：数组 nums 中的美丽数组有：[1] 。
//可以证明数组 [1] 中只存在 1 个美丽子集。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 18 
// 1 <= nums[i], k <= 1000 
// 
//
// Related Topics 数组 哈希表 数学 动态规划 回溯 组合数学 排序 👍 59 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheNumberOfBeautifulSubsets_2597 {
    public static void main(String[] args) {
        Solution solution = new TheNumberOfBeautifulSubsets_2597().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();

        public int beautifulSubsets(int[] nums, int k) {
            dfs(nums, k, 0);
            return ans - 1;
        }

        private void dfs(int[] nums, int k, int i) {
            if (i == nums.length) {
                ans++;
                return;
            }

            dfs(nums, k, i + 1);// 不放进去

            if (m.getOrDefault(nums[i] - k, 0) == 0 && m.getOrDefault(nums[i] + k, 0) == 0) {
                m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
                dfs(nums, k, i + 1);
                m.put(nums[i], m.getOrDefault(nums[i], 0) - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}