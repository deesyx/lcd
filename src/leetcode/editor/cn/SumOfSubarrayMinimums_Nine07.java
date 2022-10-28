//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
// Related Topics 栈 数组 动态规划 单调栈 👍 513 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class SumOfSubarrayMinimums_Nine07 {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums_Nine07().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int mod = (int) (1e9 + 7);
            Stack<Integer> s = new Stack<>();
            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (s.isEmpty() || arr[s.peek()] <= arr[i]) {
                    s.push(i);
                    continue;
                }

                while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                    int cur = s.pop();
                    int start;
                    if (!s.isEmpty()) {
                        start = s.peek();
                    } else {
                        start = -1;
                    }
                    ans = (ans + (long) (cur - (start + 1) + 1) * (i - 1 - cur + 1) * arr[cur]) % mod;
                }
                s.push(i);
            }

            while (!s.isEmpty()) {
                int cur = s.pop();
                int start;
                if (!s.isEmpty()) {
                    start = s.peek();
                } else {
                    start = -1;
                }
                ans = (ans + (long) (cur - (start + 1) + 1) * (arr.length - 1 - cur + 1) * arr[cur]) % mod;
            }

            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}