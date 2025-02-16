//给你一个 m x n 的矩阵 M 和一个操作数组 op 。矩阵初始化时所有的单元格都为 0 。ops[i] = [ai, bi] 意味着当所有的 0 <=
//x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。 
//
// 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: m = 3, n = 3，ops = [[2,2],[3,3]]
//输出: 4
//解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
// 
//
// 示例 2: 
//
// 
//输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2]
//,[3,3],[3,3],[3,3]]
//输出: 4
// 
//
// 示例 3: 
//
// 
//输入: m = 3, n = 3, ops = []
//输出: 9
// 
//
// 
//
// 提示: 
//
// 
// 
//
// 
// 1 <= m, n <= 4 * 10⁴ 
// 0 <= ops.length <= 10⁴ 
// ops[i].length == 2 
// 1 <= ai <= m 
// 1 <= bi <= n 
// 
//
// Related Topics 数组 数学 👍 216 👎 0


package leetcode.editor.cn;

public class RangeAdditionIi_598 {
    public static void main(String[] args) {
        Solution solution = new RangeAdditionIi_598().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int[] ans = new int[2];
            ans[0] = m;
            ans[1] = n;

            for (int[] op : ops) {
                int a = op[0];
                int b = op[1];

                if (a < ans[0]) {
                    ans[0] = a;
                }

                if (b < ans[1]) {
                    ans[1] = b;
                }
            }

            return ans[0]*ans[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}