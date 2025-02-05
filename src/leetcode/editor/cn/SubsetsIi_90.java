//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1265 👎 0


package leetcode.editor.cn;

import java.util.*;

public class SubsetsIi_90 {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi_90().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int end = (int) Math.pow(2, n);
            Set<List<Integer>> ans = new HashSet<>();
            for (int i = 0; i < end; i++) {
                List<Integer> path = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & i) != 0) {
                        path.add(nums[j]);
                    }
                }
                ans.add(path);
            }
            return new ArrayList<>(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}