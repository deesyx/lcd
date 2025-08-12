package leetcode.editor.cn.test;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.maxLength(new int[]{1, 2, 3, 3, 2});
        System.out.println(ans);

    }

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 最长山脉的长度
         *
         * @param nums int整型一维数组 每个元素表示一座山的高度
         * @return int整型
         */
        public int maxLength(int[] nums) {
            // write code here
            if (nums.length == 0) {
                return 0;
            }
            Stack<Integer> s = new Stack<>();
            s.push(nums[0]);

            int idx = 1;
            while (idx < nums.length && nums[idx] > s.peek()) {
                s.push(nums[idx]);
                idx++;
            }

            int ans = s.size();
            if (idx < nums.length && nums[idx] < s.peek()) {
                Stack<Integer> s2 = new Stack<>();
                s2.push(nums[idx]);
                idx++;
                while (idx < nums.length && nums[idx] < s2.peek()) {
                    s2.push(nums[idx]);
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

}
