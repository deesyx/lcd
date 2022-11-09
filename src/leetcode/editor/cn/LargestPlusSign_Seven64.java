//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
// Related Topics 数组 动态规划 👍 150 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class LargestPlusSign_Seven64 {
    public static void main(String[] args) {
        Solution solution = new LargestPlusSign_Seven64().new Solution();
        solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] grid = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(grid[i], 1);
            }
            for (int[] m : mines) {
                grid[m[0] + 1][m[1] + 1] = 0;
            }

            int[][] down = new int[n + 2][n + 2];
            int[][] right = new int[n + 2][n + 2];
            int[][] up = new int[n + 2][n + 2];
            int[][] left = new int[n + 2][n + 2];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i][j] == 1) {
                        down[i][j] = down[i - 1][j] + 1;
                        right[i][j] = right[i][j - 1] + 1;
                    }
                }
            }

            for (int i = n; i >= 1; i--) {
                for (int j = n; j >= 1; j--) {
                    if (grid[i][j] == 1) {
                        up[i][j] = up[i + 1][j] + 1;
                        left[i][j] = left[i][j + 1] + 1;
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ans = Math.max(ans, Math.min(Math.min(up[i][j], down[i][j]), Math.min(right[i][j], left[i][j])));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}