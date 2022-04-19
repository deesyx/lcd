//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 672 👎 0


package leetcode.editor.cn;

public class MaximumLengthOfRepeatedSubarray_Seven18 {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray_Seven18().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // dp[i][j]表示s1[0..i]与s2[0..j]公共子数组长度
    // dp[i][j]=dp[i-1][j-1]+1 s1[i]==s2[j]
    // dp[i][j]=0 s1[i]!=s2[j]，因为子数组要连续，如果不相等说明连续被打断，也就长度为0
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int ans = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
