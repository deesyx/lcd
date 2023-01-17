//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， 
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 数学 计数 👍 48 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray_One814 {
    public static void main(String[] args) {
        Solution solution = new CountNicePairsInAnArray_One814().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNicePairs(int[] nums) {
            int mod = (int) 1e9 + 7;
            Map<Integer, Integer> m = new HashMap<>();
            for (int n : nums) {
                int key = n - rev(n);
                m.put(key, m.getOrDefault(key, 0) + 1);
            }

            long ans = 0;
            for (long value : m.values()) {
                ans = (ans + value * (value - 1) / 2) % mod;
            }
            return (int) ans;
        }

        private int rev(int x) {
            int ans = 0;
            while (x != 0) {
                ans = ans * 10 + x % 10;
                x = x / 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}