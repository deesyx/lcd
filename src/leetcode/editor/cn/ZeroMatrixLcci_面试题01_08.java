//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 哈希表 矩阵 👍 119 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrixLcci_面试题01_08 {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci_面试题01_08().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> zeroRows = new HashSet<>();
            Set<Integer> zeroCols = new HashSet<>();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRows.add(i);
                        zeroCols.add(j);
                    }
                }
            }

            for (int zeroRow : zeroRows) {
                Arrays.fill(matrix[zeroRow], 0);
            }
            for (int zeroCol : zeroCols) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][zeroCol] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}