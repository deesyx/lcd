//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 977 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_One18 {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle_One18().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> dp = new ArrayList<>();
            dp.add(new ArrayList<>() {{
                add(1);
            }});
            if (numRows == 1) {
                return dp;
            }

            for (int i = 1; i < numRows; i++) {
                List<Integer> path = new ArrayList<>() {{
                    add(1);
                }};
                List<Integer> lastRow = dp.get(i - 1);
                for (int j = 1; j < i; j++) {
                    path.add(lastRow.get(j) + lastRow.get(j - 1));
                }
                path.add(1);
                dp.add(path);
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}