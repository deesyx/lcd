//给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,0,1],[1,1,0],[1,1,0]]
//输出：13
//解释：
//有 6 个 1x1 的矩形。
//有 2 个 1x2 的矩形。
//有 3 个 2x1 的矩形。
//有 1 个 2x2 的矩形。
//有 1 个 3x1 的矩形。
//矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
//输出：24
//解释：
//有 8 个 1x1 的子矩形。
//有 5 个 1x2 的子矩形。
//有 2 个 1x3 的子矩形。
//有 4 个 2x1 的子矩形。
//有 2 个 2x2 的子矩形。
//有 2 个 3x1 的子矩形。
//有 1 个 3x2 的子矩形。
//矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 150 
// mat[i][j] 仅包含 0 或 1 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 227 👎 0


package leetcode.editor.cn;

public class CountSubmatricesWithAllOnes_1504 {
    public static void main(String[] args) {
        Solution solution = new CountSubmatricesWithAllOnes_1504().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubmat(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int ans = 0;
            for (int top = 0; top < m; top++) {
                int[] a = new int[n];
                for (int bottom = top; bottom < m; bottom++) {
                    int h = bottom - top + 1;
                    for (int j = 0; j < n; j++) {
                        a[j] += mat[bottom][j];
                    }

                    int path = 0;
                    for (int i = 0; i < n; i++) {
                        if (a[i] != h) {
                            ans += path * (path + 1) / 2;
                            path = 0;
                            continue;
                        }
                        path++;
                    }
                    ans += path * (path + 1) / 2;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}