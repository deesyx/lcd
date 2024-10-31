//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 10⁴ 次 reset 和 shuffle 
// 
//
// Related Topics 数组 数学 随机化 洗牌算法 👍 359 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray_384 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] orig;
        private int[] ans;

        // 对于数组中的任一元素x，其出现在任一位置i的可能性为：一个元素m被放入第i个位置的概率P = 前i-1个位置选择元素时没有选中m的概率 * 第i个位置选中m的概率, P = { (n-1)/n * (n-2)/(n-1) * ... * (n-i)/[n-(i-1)]  } * 1/(n-i) = 1/n
        // 将数组分为已打乱和未打乱的前后两部分（初始时两者分别由0、n个元素），每次随机从未打乱部分中选择一个元素加入到已打乱部分中。
        public Solution(int[] nums) {
            orig = nums;
            ans = Arrays.copyOf(nums, nums.length);
        }

        public int[] reset() {
            return orig;
        }

        public int[] shuffle() {
            int n = ans.length;
            for (int i = 0; i < ans.length; i++) {
                int rand = randInt(i, n - 1);
                int t = ans[i];
                ans[i] = ans[rand];
                ans[rand] = t;
            }
            return ans;
        }

        private int randInt(int min, int max) {
            Random random = new Random();
            return random.nextInt(max - min + 1) + min;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}