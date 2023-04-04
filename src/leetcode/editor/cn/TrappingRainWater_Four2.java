//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4240 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater_Four2 {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater_Four2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> s = new Stack<>();

            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                if (s.isEmpty()) {
                    s.push(i);
                    continue;
                }

                int cur = height[i];
                if (cur <= height[s.peek()]) {
                    s.push(i);
                } else {
                    while (!s.isEmpty() && cur > height[s.peek()]) {
                        int topIdx = s.pop();
                        if (s.isEmpty()) {
                            break;
                        }

                        int left = s.peek();
                        int right = i;
                        int h = Math.min(height[left], height[right]) - height[topIdx];
                        int w = right - left - 1;
                        ans += h * w;
                    }
                    s.push(i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}