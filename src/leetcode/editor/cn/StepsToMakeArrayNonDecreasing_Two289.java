//给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < 
//i < nums.length 。 
//
// 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
//输出：3
//解释：执行下述几个步骤：
//- 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
//- 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
//- 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
//[5,7,11,11] 是一个非递减数组，因此，返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,7,7,13]
//输出：0
//解释：nums 已经是一个非递减数组，因此，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 115 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StepsToMakeArrayNonDecreasing_Two289 {
    public static void main(String[] args) {
        Solution solution = new StepsToMakeArrayNonDecreasing_Two289().new Solution();
        solution.totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalSteps(int[] nums) {
            int ans = 0;
            Stack<int[]> st = new Stack<>();
            for (int n : nums) {
                int maxT = 0;
                while (!st.isEmpty() && st.peek()[0] <= n) {
                    maxT = Math.max(maxT, st.pop()[1]);
                }
                maxT = st.isEmpty() ? 0 : maxT + 1;
                ans = Math.max(ans, maxT);
                st.push(new int[]{n, maxT});
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}