//给你两个正整数 low 和 high 。
//
// 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。 
//
// 返回在 [low, high] 范围内的 对称整数的数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：low = 1, high = 100
//输出：9
//解释：在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
// 
//
// 示例 2： 
//
// 
//输入：low = 1200, high = 1230
//输出：4
//解释：在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= low <= high <= 10⁴ 
// 
//
// Related Topics 数学 枚举 👍 23 👎 0


package leetcode.editor.cn;

public class CountSymmetricIntegers_2843 {
    public static void main(String[] args) {
        Solution solution = new CountSymmetricIntegers_2843().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSymmetricIntegers(int low, int high) {
            int ans = 0;
            for (int i = low; i <= high; i++) {
                if (isSymmetricInteger(i)) {
                    ans++;
                }
            }

            return ans;
        }

        private boolean isSymmetricInteger(int num) {
            String str = String.valueOf(num);
            if (str.length() % 2 != 0) {
                return false;
            }

            int length = str.length();
            int half = length / 2;
            int leftSum = 0;
            for (int i = 0; i < half; i++) {
                leftSum += str.charAt(i) - '0';
            }
            int rightSum = 0;
            for (int i = half; i < length; i++) {
                rightSum += str.charAt(i) - '0';
            }
            return leftSum == rightSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}