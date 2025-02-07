//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1378 👎 0


package leetcode.editor.cn;

public class SpiralMatrixIi_59 {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi_59().new Solution();
        solution.generateMatrix(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            int dirIdx = 0;
            int i = 0;
            int j = 0;
            int idx = 1;

            while (idx <= n * n) {
                ans[i][j] = idx;
                idx++;

                for (int k = 0; k <= 3; k++) {
                    dirIdx = (dirIdx + k) % 4;
                    int[] dir = dirs[dirIdx];
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n || ans[x][y] != 0) {
                        continue;
                    }
                    i = x;
                    j = y;
                    break;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}