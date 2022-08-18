//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 哈希表 👍 113 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximumEqualFrequency_One224 {
    public static void main(String[] args) {
        Solution solution = new MaximumEqualFrequency_One224().new Solution();
        solution.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualFreq(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, Integer> freq = new HashMap<>();
            int ans = 0;
            int maxFreq = 0;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                int preCountN = count.getOrDefault(n, 0);
                int curCountN = preCountN + 1;
                if (preCountN > 0) {
                    freq.put(preCountN, freq.get(preCountN) - 1);
                }
                count.put(n, curCountN);
                freq.put(curCountN, freq.getOrDefault(curCountN, 0) + 1);
                maxFreq = Math.max(maxFreq, curCountN);
                int len = i + 1;
                if (maxFreq == 1) ans = len;
                if (maxFreq * freq.getOrDefault(maxFreq, 0) + 1 == len) ans = len;
                if ((maxFreq - 1) * freq.getOrDefault(maxFreq - 1, 0) + maxFreq == len) ans = len;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}