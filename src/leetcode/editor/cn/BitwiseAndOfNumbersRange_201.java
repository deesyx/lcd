//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 557 👎 0


package leetcode.editor.cn;

public class BitwiseAndOfNumbersRange_201 {
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange_201().new Solution();
        solution.rangeBitwiseAnd(2147483646, 2147483647);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int m = left ^ right;
            int idx = 31;
            for (; idx >= 0; idx--) {
                if (((1 << idx) & m) != 0) {
                    break;
                }
            }

            for (int i = 0; i <= idx; i++) {
                left = left & (~(1 << i));
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}