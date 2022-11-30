//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 487 👎 0


package leetcode.editor.cn;

public class MaxConsecutiveOnesIii_One004 {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii_One004().new Solution();
        solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;
            int right = 0;
            int count = 0;
            int used = 0;
            int ans = 0;
            while (right < nums.length) {
                int in = nums[right++];
                if (in == 1) {
                    count++;
                    ans = Math.max(ans, count);
                } else if (used < k) {
                    used++;
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    while (used >= k) {
                        int out = nums[left++];
                        if (out == 1) {
                            count--;
                        } else {
                            count--;
                            used--;
                        }
                    }
                    used++;
                    count++;
                    ans = Math.max(ans, count);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}