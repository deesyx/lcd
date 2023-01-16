//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 750 👎 0


package leetcode.editor.cn;

public class SearchA2dMatrix_Seven4 {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix_Seven4().new Solution();
        solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int left = 0;
            int right = m - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (check(mid, matrix, target)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (matrix[left][n - 1] > matrix[m - 1][n - 1]) {
                return false;
            }

            int row = left;
            left = 0;
            right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (check2(mid, matrix, row, target)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return matrix[row][left] == target;
        }

        private boolean check(int mid, int[][] matrix, int target) {
            return matrix[mid][matrix[0].length - 1] >= target;
        }

        private boolean check2(int mid, int[][] matrix, int row, int target) {
            return matrix[row][mid] >= target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}