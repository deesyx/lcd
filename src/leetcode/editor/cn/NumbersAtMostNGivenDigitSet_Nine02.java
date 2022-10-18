//给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。
// 例如，如果 digits = ['1','3',
//'5']，我们可以写数字，如 '13', '551', 和 '1351315'。 
//
// 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = ["1","3","5","7"], n = 100
//输出：20
//解释：
//可写出的 20 个数字是：
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// 示例 2： 
//
// 
//输入：digits = ["1","4","9"], n = 1000000000
//输出：29523
//解释：
//我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//81 个四位数字，243 个五位数字，729 个六位数字，
//2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//总共，可以使用D中的数字写出 29523 个整数。 
//
// 示例 3: 
//
// 
//输入：digits = ["7"], n = 8
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] 是从 '1' 到 '9' 的数 
// digits 中的所有值都 不同 
// digits 按 非递减顺序 排列 
// 1 <= n <= 10⁹ 
// 
// Related Topics 数组 数学 字符串 二分查找 动态规划 数位DP 👍 179 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class NumbersAtMostNGivenDigitSet_Nine02 {
    public static void main(String[] args) {
        Solution solution = new NumbersAtMostNGivenDigitSet_Nine02().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 将 n 转换成字符串 s，定义 f(i,limitByN,lastIndexHasInput), f(i,limitByN,lastIndexHasInput) 表示构造从左往右第 i 位及其之后数位的合法方案数，其中：
     * <p>
     * limitByN 表示当前是否受到了 n 的约束。若为真，则第 i 位填入的数字至多为 s[i]，否则至多为 9。例如 n=234，如果前面填了 23，那么最后一位至多填 4；如果前面填的不是 23，那么最后一位至多填 9。如果在受到约束的情况下填了 s[i]，那么后续填入的数字仍会受到 n 的约束。
     * lastIndexHasInput 表示 i 前面的数位是否填了数字。若为假，则当前位可以跳过（不填数字），或者要填入的数字至少为 1；若为真，则必须填数字，且要填入的数字从 0 开始。这样我们可以控制构造出的是一位数/两位数/三位数等等。对于本题而言，要填入的数字可直接从 digits 中选择。
     */
    class Solution {
        private String[] digits;
        private char nChars[];
        private int dp[];

        public int atMostNGivenDigitSet(String[] digits, int n) {
            this.digits = digits;
            nChars = Integer.toString(n).toCharArray();
            dp = new int[nChars.length];
            Arrays.fill(dp, -1); // dp[i] = -1 表示 i 这个状态还没被计算出来
            return f(0, true, false);
        }

        private int f(int i, boolean limitByN, boolean lastIndexHasInput) {
            if (i == nChars.length) return lastIndexHasInput ? 1 : 0; // 如果填了数字，则为 1 种合法方案
            if (!limitByN && lastIndexHasInput && dp[i] >= 0) return dp[i]; // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
            int res = 0;
            if (!lastIndexHasInput) // 前面不填数字，那么可以跳过当前数位，也不填数字
                // limitByN 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
                // lastIndexHasInput 仍然为 false，因为没有填任何数字
                res = f(i + 1, false, false);
            char up = limitByN ? nChars[i] : '9'; // 根据是否受到约束，决定可以填的数字的上限
            // 注意：对于一般的题目而言，如果此时 lastIndexHasInput 为 false，则必须从 1 开始枚举，由于本题 digits 没有 0，所以无需处理这种情况
            for (String d : digits) { // 枚举要填入的数字 d
                if (d.charAt(0) > up) break; // d 超过上限，由于 digits 是有序的，后面的 d 都会超过上限，故退出循环
                // limitByN：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
                // lastIndexHasInput 为 true，因为填了数字
                res += f(i + 1, limitByN && d.charAt(0) == up, true);
            }
            if (!limitByN && lastIndexHasInput) dp[i] = res; // 在不受到任何约束的情况下，记录结果
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}