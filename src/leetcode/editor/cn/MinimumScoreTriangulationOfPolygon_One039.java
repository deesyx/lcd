//你有一个凸的
// n 边形，其每个顶点都有一个整数值。给定一个整数数组
// values ，其中
// values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。 
//
// 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之
//和。 
//
// 返回 多边形进行三角剖分后可以得到的最低分 。 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：values = [1,2,3]
//输出：6
//解释：多边形已经三角化，唯一三角形的分数为 6。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：values = [3,7,4,5]
//输出：144
//解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：values = [1,3,1,4,1,5]
//输出：13
//解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length 
// 3 <= n <= 50 
// 1 <= values[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 160 👎 0


package leetcode.editor.cn;

public class MinimumScoreTriangulationOfPolygon_One039 {
    public static void main(String[] args) {
        Solution solution = new MinimumScoreTriangulationOfPolygon_One039().new Solution();
        solution.minScoreTriangulation(new int[]{3, 7, 4, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i][j]表示将多边形的顶点i到j进行三角剖分后的最低分数
         * dp[i][j]=0 i+1>=j 当i+1>=j时说明是一条横线，所以
         * dp[i][j]=min(dp[i][k]+dp[k][j]+v[i]*v[k]*v[j]) i+1<j,i<k<j
         */
        public int minScoreTriangulation(int[] values) {
            int n = values.length;
            int[][] dp = new int[n][n];

            for (int i = n - 3; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    int path = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        path = Math.min(path, dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                    }
                    dp[i][j] = path;
                }
            }
            return dp[0][n - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}