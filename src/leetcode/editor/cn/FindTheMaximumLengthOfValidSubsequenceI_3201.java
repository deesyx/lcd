//给你一个整数数组 nums。
//
// nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列： 
//
// 
// (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x 
//- 1]) % 2 
// 
//
// 返回 nums 的 最长的有效子序列 的长度。 
//
// 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3,4] 
// 
//
// 输出： 4 
//
// 解释： 
//
// 最长的有效子序列是 [1, 2, 3, 4]。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,1,1,2,1,2] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。 
//
// 示例 3： 
//
// 
// 输入： nums = [1,3] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 最长的有效子序列是 [1, 3]。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁷ 
// 
//
// Related Topics 数组 动态规划 👍 13 👎 0


package leetcode.editor.cn;

public class FindTheMaximumLengthOfValidSubsequenceI_3201 {
    public static void main(String[] args) {
        Solution solution = new FindTheMaximumLengthOfValidSubsequenceI_3201().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums) {
            int odd = 0;
            int even = 0;
            int t = 0;
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                int mod = nums[i] % 2;
                if (mod == 0) {
                    even++;
                } else {
                    odd++;
                }
                if (mod != nums[i + 1] % 2) {
                    t++;
                }
            }

            if (nums[n - 1] % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            return Math.max(Math.max(odd, even), t + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}