//给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。 
//
// 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,0,0,1,0,1], k = 2
//输出：1
//解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,0,0,0,0,0,1,1], k = 3
//输出：5
//解释：通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,1,1,1] 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,0,1], k = 2
//输出：0
//解释：nums 已经有连续 2 个 1 了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 ，要么是 1 。 
// 1 <= k <= sum(nums) 
// 
// Related Topics 贪心 数组 前缀和 滑动窗口 👍 84 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MinimumAdjacentSwapsForKConsecutiveOnes_One703 {
    public static void main(String[] args) {
        Solution solution = new MinimumAdjacentSwapsForKConsecutiveOnes_One703().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 前缀和分析
     *          p0 p1 p2 p3 p4 p5
     *       s0 s1 s2 s3 s4 s5 s6
     * p[left] + ... + p[right] = s[right+1] - s[left]
     */
    class Solution {
        public int minMoves(int[] nums, int k) {
            int n = nums.length;
            int[] pos = new int[n];
            int index = 0;
            // 例如：[1,0,0,1,0,1,1,1,0,1,1] => [0,3,5,6,7,9,10]
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    pos[index++] = i;
                }
            }
            int ans = 0, count = 0, mid = k / 2;
            // 定长滑窗模板:
            // 1.计算第一个长度为k的窗口, k = 5, pos[i] - pos[i - 1] - 1表示相邻1之间0的个数
            // [0,3,5,6,7] => (3-0-1)*1 + (5-3-1)*2 + (6-5-1)*2 + (7-6-1)*1 = 4
            for (int i = 1; i < k; i++) {
                count += (pos[i] - pos[i - 1] - 1) * Math.min(i, k - i); //把0移到左端或者右端，选最近的
            }
            ans = count;
            // 2.窗口按步长滑动 [0,3,5,6,7] => [3,5,6,7,9]
            // [0,3,5,6,7] => (3-0-1)*1 + (5-3-1)*2 + (6-5-1)*2 + (7-6-1)*1 = 4
            // [3,5,6,7,9] =>             (5-3-1)*1 + (6-5-1)*2 + (7-6-1)*2 + (9-7-1)*1 = 2
            // 通过对比发现：count -= (3-0-1)*1 + (5-3-1)*1 + (6-5-1)*0 = 3 - 0 + 5 - 3 + 1 + 1= 5 - 0 + 2
            //             count += (7-6-1)*1 + (9-7-1)*1 = 7 - 6 + 9 - 7 - 1 - 1 = 9 - 6 - 2
            // 类似于差分和前缀和的关系，加减2相互抵消，所以最后结果与窗口内两端点和中位数有关
            for (int i = k; i < index; i++) {
                count -= pos[i - k + mid] - pos[i - k]; // 上个区间中位数 - 上个区间左端点，移出上个区间左端点
                count += pos[i] - pos[i - mid]; // 当前区间右端点 - 当前区间中位数，移入当前区间右端点
                ans = Math.min(ans, count);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}