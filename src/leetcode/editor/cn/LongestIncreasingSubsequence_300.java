//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 4002 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence_300().new Solution();
        solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i]表示以s[i]为结尾的最长递增子序列长度
     * dp[i]=max(dp[0],..dp[j])+1 s[j]<s[i] && j<i
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                int path = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        path = Math.max(path, dp[j]);
                        dp[i] = path + 1;
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}