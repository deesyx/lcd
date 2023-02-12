//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = [
// "abcde", 
// "fghij", 
// "klmno", 
// "pqrst", 
// "uvwxy", 
// "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
// Related Topics 哈希表 字符串 👍 70 👎 0


package leetcode.editor.cn;

public class AlphabetBoardPath_One138 {
    public static void main(String[] args) {
        Solution solution = new AlphabetBoardPath_One138().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alphabetBoardPath(String target) {
            StringBuilder ans = new StringBuilder();
            int[] start = new int[]{0, 0};
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                int[] end = toIdx(c);
                path(start, end, ans);
                ans.append("!");
                start = end;
            }
            return ans.toString();
        }

        private int[] toIdx(char c) {
            if (c == 'z') {
                return new int[]{5, 0};
            }

            int index = c - 'a';
            int row = index / 5;
            int col = index % 5;

            return new int[]{row, col};
        }

        private void path(int[] start, int[] end, StringBuilder ans) {
            if (end[0] == 5) {
                colMove(start, end, ans);
                rowMove(start, end, ans);
            } else {
                rowMove(start, end, ans);
                colMove(start, end, ans);
            }
        }

        private void rowMove(int[] start, int[] end, StringBuilder ans) {
            int rowStart = start[0];
            int rowEnd = end[0];
            int rowStep = rowEnd - rowStart;
            if (rowStep > 0) {
                ans.append("D".repeat(rowStep));
            } else if (rowStep < 0) {
                ans.append("U".repeat(Math.abs(rowStep)));
            }
        }

        private void colMove(int[] start, int[] end, StringBuilder ans) {
            int colStart = start[1];
            int colEnd = end[1];
            int colStep = colEnd - colStart;
            if (colStep > 0) {
                ans.append("R".repeat(colStep));
            } else if (colStep < 0) {
                ans.append("L".repeat(Math.abs(colStep)));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}