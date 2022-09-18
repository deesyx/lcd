//给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。 
//
// 找出 A 中的坡的最大宽度，如果不存在，返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：[6,0,8,2,1,5]
//输出：4
//解释：
//最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
// 
//
// 示例 2： 
//
// 输入：[9,8,1,0,1,9,4,0,4,1]
//输出：7
//解释：
//最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 0 <= A[i] <= 50000 
// 
//
// 
// Related Topics 栈 数组 单调栈 👍 179 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class MaximumWidthRamp_Nine62 {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthRamp_Nine62().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxWidthRamp(int[] nums) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                if (s.isEmpty()) {
                    s.push(i);
                } else {
                    int peek = nums[s.peek()];
                    if (nums[i] < peek) {
                        s.push(i);
                    }
                }
            }

            int ans = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                    int pop = s.pop();
                    ans = Math.max(ans, i - pop);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}