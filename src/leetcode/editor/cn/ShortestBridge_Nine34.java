//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
//
// 返回必须翻转的 0 的最小数目。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 336 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_Nine34 {
    public static void main(String[] args) {
        Solution solution = new ShortestBridge_Nine34().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> edges = new LinkedList<>();

        public int shortestBridge(int[][] grid) {
            boolean foundIsland = false;
            for (int i = 0; !foundIsland && i < grid.length; i++) {
                for (int j = 0; !foundIsland && j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        foundIsland = true;
                        markIsland(grid, i, j);
                    }
                }
            }

            int ans = 0;
            while (!edges.isEmpty()) {
                ans++;
                int n = edges.size();
                for (int k = 0; !edges.isEmpty() && k < n; k++) {
                    int[] e = edges.poll();
                    for (int[] dir : dirs) {
                        int ni = e[0] + dir[0];
                        int nj = e[1] + dir[1];
                        if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length
                                || grid[ni][nj] == 2) {
                            continue;
                        }
                        if (grid[ni][nj] == 0) {
                            grid[ni][nj] = 2;
                            edges.add(new int[]{ni, nj});
                        } else if (grid[ni][nj] == 1) {
                            return ans;
                        }
                    }
                }
            }

            return ans;
        }

        private void markIsland(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                    || grid[i][j] == 2) {
                return;
            }
            if (grid[i][j] == 0) {
                grid[i][j] = 2;
                edges.add(new int[]{i, j});
                return;
            }
            grid[i][j] = 2;
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                markIsland(grid, ni, nj);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}