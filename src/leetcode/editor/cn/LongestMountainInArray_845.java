//把符合下列属性的数组 arr 称为 山脉数组 ： 
//
// 
// arr.length >= 3 
// 存在下标 i（0 < i < arr.length - 1），满足 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1,4,7,3,2,5]
//输出：5
//解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,2,2]
//输出：0
//解释：不存在山脉子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以仅用一趟扫描解决此问题吗？ 
// 你可以用 O(1) 空间解决此问题吗？ 
// 
//
// Related Topics 数组 双指针 动态规划 枚举 👍 304 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class LongestMountainInArray_845 {
    public static void main(String[] args) {
        Solution solution = new LongestMountainInArray_845().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestMountain(int[] arr) {
            if (arr.length == 0) {
                return 0;
            }
            Stack<Integer> s = new Stack<>();
            s.push(arr[0]);

            int idx = 1;
            while (idx < arr.length && arr[idx] > s.peek()) {
                s.push(arr[idx]);
                idx++;
            }

            int ans = s.size();
            if (idx < arr.length && arr[idx] < s.peek()) {
                Stack<Integer> s2 = new Stack<>();
                s2.push(arr[idx]);
                idx++;
                while (idx < arr.length && arr[idx] < s2.peek()) {
                    s2.push(arr[idx]);
                    idx++;
                }
                ans += s2.size();
            }

            if (ans >= 3) {
                return ans;
            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}