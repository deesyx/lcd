//丑数 就是只包含质因数 2、3 和 5 的 正 整数。
//
// 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：true
//解释：6 = 2 × 3 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：true
//解释：1 没有质因数。 
//
// 示例 3： 
//
// 
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 487 👎 0


package leetcode.editor.cn;

public class UglyNumber_263 {
    public static void main(String[] args) {
        Solution solution = new UglyNumber_263().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }

            if (n == 1) {
                return true;
            }

            while (n % 3 == 0) {
                n /= 3;
            }

            while (n % 5 == 0) {
                n /= 5;
            }

            return (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}