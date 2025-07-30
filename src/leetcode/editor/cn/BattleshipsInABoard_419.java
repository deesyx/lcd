//给你一个大小为 m x n 的矩阵 board 表示棋盘，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在棋盘 board 上放置的
// 舰队 的数量。 
//
// 舰队 只能水平或者垂直放置在 board 上。换句话说，舰队只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状放置，其中 k 可以
//是任意大小。两个舰队之间至少有一个水平或垂直的空格分隔 （即没有相邻的舰队）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
//
// Related Topics 深度优先搜索 数组 矩阵 👍 314 👎 0


package leetcode.editor.cn;

public class BattleshipsInABoard_419 {
    public static void main(String[] args) {
        Solution solution = new BattleshipsInABoard_419().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int countBattleships(char[][] board) {
            int ans = 0;
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'X' && !visited[i][j]) {
                        ans++;
                        dfs(board, visited, i, j);
                    }
                }
            }
            return ans;
        }

        private void dfs(char[][] board, boolean[][] visited, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X' || visited[i][j]) {
                return;
            }

            visited[i][j] = true;

            for (int[] dir : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                dfs(board, visited, nr, nc);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}