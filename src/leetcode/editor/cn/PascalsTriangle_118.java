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
//输出:
// [
// [1],
// [1,1],
// [1,2,1],
// [1,3,3,1],
// [1,4,6,4,1]
// ]
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
// Related Topics 数组 动态规划 👍 1269 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle_118().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(List.of(1));
            if (numRows == 1) {
                return ans;
            }

            for (int i = 2; i <= numRows; i++) {
                List<Integer> path = new ArrayList<>();
                List<Integer> lastRow = ans.get(i - 2);
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        path.add(1);
                    } else if (j == i - 1) {
                        path.add(1);
                    } else {
                        path.add(lastRow.get(j - 1) + lastRow.get(j));
                    }
                }
                ans.add(path);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}