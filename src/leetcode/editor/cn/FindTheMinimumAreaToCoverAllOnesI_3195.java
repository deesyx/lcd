//给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
//
// 返回这个矩形可能的 最小 面积。 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[0,1,0],[1,0,1]] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 
//
// 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。 
//
// 示例 2： 
//
// 
// 输入： grid = [[0,0],[1,0]] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
//
// 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 1000 
// grid[i][j] 是 0 或 1。 
// 输入保证 grid 中至少有一个 1 。 
// 
//
// Related Topics 数组 矩阵 👍 6 👎 0


package leetcode.editor.cn;

public class FindTheMinimumAreaToCoverAllOnesI_3195 {
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumAreaToCoverAllOnesI_3195().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumArea(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int minHeight = Integer.MAX_VALUE;
            int maxHeight = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        minHeight = Math.min(minHeight, i);
                        maxHeight = Math.max(maxHeight, i);
                        break;
                    }
                }
            }

            int minWeight = Integer.MAX_VALUE;
            int maxWeight = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 1) {
                        minWeight = Math.min(minWeight, j);
                        maxWeight = Math.max(maxWeight, j);
                        break;
                    }
                }
            }

            return (maxHeight - minHeight + 1) * (maxWeight - minWeight + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}