//给你一个正整数 n。 
//
// 如果一个二进制字符串 x 的所有长度为 2 的子字符串中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。 
//
// 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 3 
// 
//
// 输出： ["010","011","101","110","111"] 
//
// 解释： 
//
// 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。 
//
// 示例 2： 
//
// 
// 输入： n = 1 
// 
//
// 输出： ["0","1"] 
//
// 解释： 
//
// 长度为 1 的有效字符串有："0" 和 "1"。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 18 
// 
//
// Related Topics 位运算 递归 字符串 👍 13 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros_3211 {
    public static void main(String[] args) {
        Solution solution = new GenerateBinaryStringsWithoutAdjacentZeros_3211().new Solution();
        solution.validStrings(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] dirs = new int[]{0, 1};

        public List<String> validStrings(int n) {
            List<String> ans = new ArrayList<>();
            dfs(n, ans, new StringBuilder(), false);
            return ans;
        }

        private void dfs(int n, List<String> ans, StringBuilder path, boolean last0) {
            if (path.length() == n) {
                ans.add(path.toString());
                return;
            }

            for (int dir : dirs) {
                if (dir == 0 && last0) {
                    continue;
                }

                path.append(dir);
                dfs(n, ans, path, dir == 0);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}