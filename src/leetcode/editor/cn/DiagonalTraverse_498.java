//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 0,0 0,1 1,0 2,0 1,1 0,2 1,2 2,1 2,2
// (-1,1) (1,-1)
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 524 👎 0


package leetcode.editor.cn;

public class DiagonalTraverse_498 {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse_498().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] ans = new int[m * n];

            int idx = 0;
            for (int k = 0; k <= m + n - 2; k++) {
                int minJ = Math.max(0, k - m + 1);
                int maxJ = Math.min(n - 1, k);
                if (k % 2 == 0) {
                    for (int j = minJ; j <= maxJ; j++) {
                        ans[idx++] = mat[k - j][j];
                    }
                } else {
                    for (int j = maxJ; j >= minJ; j--) {
                        ans[idx++] = mat[k - j][j];
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}