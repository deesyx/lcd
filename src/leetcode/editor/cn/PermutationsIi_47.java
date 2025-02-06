//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1648 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsIi_47 {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi_47().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int[] visited = new int[nums.length];
            Set<List<Integer>> ans = new HashSet<>();
            List<Integer> path = new ArrayList<>();
            dfs(nums,visited,ans,path);

            return new ArrayList<>(ans);
        }

        private void dfs(int[] nums, int[] visited, Set<List<Integer>> ans, List<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                visited[i] = 1;
                path.add(nums[i]);
                dfs(nums, visited, ans, path);
                visited[i] = 0;
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}