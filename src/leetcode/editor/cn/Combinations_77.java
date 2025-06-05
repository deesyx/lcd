//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1772 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public static void main(String[] args) {
        Solution solution = new Combinations_77().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, n, k, ans, path);
            return ans;
        }

        private void dfs(int num, int n, int k, List<List<Integer>> ans, List<Integer> path) {
            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
            }

            for (int i = num + 1; i <= n; i++) {
                path.add(i);
                dfs(i, n, k, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}