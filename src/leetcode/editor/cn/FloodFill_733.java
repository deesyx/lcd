//有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。你也被给予三个整数 sr , sc 和
//color 。你应该从像素 image[sr][sc] 开始对图像进行上色 填充 。 
//
// 为了完成 上色工作： 
//
// 
// 从初始像素开始，将其颜色改为 color。 
// 对初始坐标的 上下左右四个方向上 相邻且与初始像素的原始颜色同色的像素点执行相同操作。 
// 通过检查与初始像素的原始颜色相同的相邻像素并修改其颜色来继续 重复 此过程。 
// 当 没有 其它原始颜色的相邻像素时 停止 操作。 
// 
//
// 最后返回经过上色渲染 修改 后的图像 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入：image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, color = 2
// 
//
// 
// 输出：[[2,2,2],[2,2,0],[2,0,1]]
// 
//
// 
// 解释：在图像的正中间，坐标 
// (sr,sc)=(1,1) （即红色像素）,在路径上所有符合条件的像素点的颜色都被更改成相同的新颜色（即蓝色像素）。
// 
//
// 
// 注意，右下角的像素 
// 没有 更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
// 
//
// 
// 
// 
//
// 示例 2: 
//
// 
// 输入：image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
// 
//
// 
// 输出：[[0,0,0],[0,0,0]]
// 
//
// 
// 解释：初始像素已经用 0 着色，这与目标颜色相同。因此，不会对图像进行任何更改。
// 
//
// 
//
// 提示: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], color < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
//
// 👍 507 👎 0


package leetcode.editor.cn;

public class FloodFill_733 {
    public static void main(String[] args) {
        Solution solution = new FloodFill_733().new Solution();
        solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int orig = image[sr][sc];
            if (orig == color) {
                return image;
            }

            int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            dfs(image, sr, sc, orig, color, dirs);

            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int orig, int color, int[][] dirs) {
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length) {
                return;
            }
            if (image[sr][sc] != orig) {
                return;
            }

            image[sr][sc] = color;
            for (int[] dir : dirs) {
                int i = sr + dir[0];
                int j = sc + dir[1];
                dfs(image, i, j, orig, color, dirs);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}