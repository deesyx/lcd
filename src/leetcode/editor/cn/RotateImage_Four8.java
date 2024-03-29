//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1555 👎 0


package leetcode.editor.cn;

/**
 * 上下对称：matrix[i][j] -> matrix[n-i-1][j]，（列不变）
 * 左右对称：matrix[i][j] -> matrix[i][n-j-1]，（行不变）
 * 主对角线对称：matrix[i][j] -> matrix[j][i]，（行列互换）
 * 副对角线对称：matrix[i][j] -> matrix[n-j-1][n-i-1] （行列均变，且互换）
 */

public class RotateImage_Four8 {
    public static void main(String[] args) {
        Solution solution = new RotateImage_Four8().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int n;

        public void rotate(int[][] matrix) {
            // 顺时针旋转90
            // matrix[i][j] -> matrix[j][n-i-1]，上下对称+主对角线对称
            n = matrix.length;
            upDownSymmetry(matrix);
            mainDiagSymmetry(matrix);
        }

        // 上下对称
        void upDownSymmetry(int[][] matrix) {
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = t;
                }
            }
        }

        // 左右对称
        void leftRightSymmetry(int[][] matrix) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = t;
                }
            }
        }

        // 主对角线对称
        void mainDiagSymmetry(int[][] matrix) {
            for (int i = 0; i < n - 1; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        // 副对角线对称
        void subdiagSymmetry(int[][] matrix) {
            for (int i = 0; i < n - 1; ++i) {
                for (int j = 0; j < n - i - 1; ++j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][n - i - 1];
                    matrix[n - j - 1][n - i - 1] = t;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}