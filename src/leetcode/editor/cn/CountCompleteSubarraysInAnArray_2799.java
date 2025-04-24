//给你一个由 正 整数组成的数组 nums 。
//
// 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ： 
//
// 
// 子数组中 不同 元素的数目等于整个数组不同元素的数目。 
// 
//
// 返回数组中 完全子数组 的数目。 
//
// 子数组 是数组中的一个连续非空序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,1,2,2]
//输出：4
//解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,5,5]
//输出：10
//解释：数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2000 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 59 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray_2799 {
    public static void main(String[] args) {
        Solution solution = new CountCompleteSubarraysInAnArray_2799().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> m = new HashSet<>();
            for (int n : nums) {
                m.add(n);
            }
            int cnt = m.size();

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> s = new HashSet<>();
                s.add(nums[i]);
                if (s.size() == cnt) {
                    ans++;
                }
                int j = i + 1;
                while (j < nums.length) {
                    int in = nums[j];
                    s.add(in);
                    if (s.size() < cnt) {
                        j++;
                    } else {
                        ans++;
                        j++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}