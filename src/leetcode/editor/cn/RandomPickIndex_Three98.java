//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。 
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 水塘抽样 哈希表 数学 随机化 👍 194 👎 0


package leetcode.editor.cn;

import java.util.Random;

public class RandomPickIndex_Three98 {
    public static void main(String[] args) {
        Solution solution = new RandomPickIndex_Three98().new Solution(new int[]{1, 2, 3, 3, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 以k/i（i>k）的概率替换蓄水池里面的数
    class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int ans = -1;
            int count = 0;
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                if (ans == -1 && nums[i] == target) {
                    count++;
                    ans = i;
                    continue;
                }

                if (nums[i] == target) {
                    count++;
                    double r = random.nextDouble();
                    if (r * count < 1) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
