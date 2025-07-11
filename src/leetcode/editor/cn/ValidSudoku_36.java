//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 1346 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku_36().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                Set<Character> m = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (m.contains(board[i][j])) {
                        return false;
                    }
                    if (board[i][j] != '.') {
                        m.add(board[i][j]);
                    }
                }
            }

            for (int j = 0; j < 9; j++) {
                Set<Character> m = new HashSet<>();
                for (int i = 0; i < 9; i++) {
                    if (m.contains(board[i][j])) {
                        return false;
                    }
                    if (board[i][j] != '.') {
                        m.add(board[i][j]);
                    }
                }
            }

            int[][] ps = new int[][]{{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7, 4}, {7, 7}};
            int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
            for (int[] p : ps) {
                Set<Character> m = new HashSet<>();
                if (board[p[0]][p[1]] != '.') {
                    m.add(board[p[0]][p[1]]);
                }
                for (int[] dir : dirs) {
                    int i = p[0] + dir[0];
                    int j = p[1] + dir[1];
                    if (m.contains(board[i][j])) {
                        return false;
                    }
                    if (board[i][j] != '.') {
                        m.add(board[i][j]);
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}