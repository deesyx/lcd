//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 419 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow_Four17 {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow_Four17().new Solution();
        solution.pacificAtlantic(new int[][]{{1, 1}, {1, 1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int r = heights.length;
            int c = heights[0].length;
            int[][] visited = new int[r][c];

            for (int i = 0; i < r; i++) {
                dfs(heights, visited, i, 0, 1);
            }
            for (int j = 0; j < c; j++) {
                dfs(heights, visited, 0, j, 1);
            }

            for (int i = 0; i < r; i++) {
                dfs(heights, visited, i, c - 1, 2);
            }
            for (int j = 0; j < c; j++) {
                dfs(heights, visited, r - 1, j, 2);
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (visited[i][j] == 3) {
                        ans.add(List.of(i, j));
                    }
                }
            }
            return ans;
        }

        private void dfs(int[][] heights, int[][] visited, int i, int j, int flag) {
            if (visited[i][j] >= flag) {
                return;
            }
            if (visited[i][j] == 0) {
                visited[i][j] = flag;
            } else {
                visited[i][j] = 3;
            }

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < heights.length && nj >= 0 && nj < heights[0].length) {
                    if (heights[ni][nj] >= heights[i][j]) {
                        dfs(heights, visited, ni, nj, flag);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
