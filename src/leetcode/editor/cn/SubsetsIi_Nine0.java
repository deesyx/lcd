//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
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
// 
// Related Topics 位运算 数组 回溯 👍 984 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsIi_Nine0 {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi_Nine0().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> ans = new HashSet<>();
            ans.add(new ArrayList<>());
            List<Integer> path = new ArrayList<>();
            dfs(nums, 0, ans, path);
            return new ArrayList<>(ans);
        }

        private void dfs(int[] nums, int start, Set<List<Integer>> ans, List<Integer> path) {
            for (int i = start; i < nums.length; i++) {
                path.add(nums[i]);
                ans.add(new ArrayList<>(path));
                dfs(nums, i + 1, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}