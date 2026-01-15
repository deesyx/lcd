//给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 10, t = 2 
// 
//
// 输出：10 
//
// 解释： 
//
// 10 的数位乘积为 0 ，可以被 2 整除，所以它是大于等于 10 且满足题目要求的最小整数。 
//
// 示例 2： 
//
// 
// 输入：n = 15, t = 3 
// 
//
// 输出：16 
//
// 解释： 
//
// 16 的数位乘积为 6 ，可以被 3 整除，所以它是大于等于 15 且满足题目要求的最小整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 1 <= t <= 10 
// 
//
// Related Topics 数学 枚举 👍 4 👎 0


package leetcode.editor.cn;

public class SmallestDivisibleDigitProductI_3345 {
	public static void main(String[] args) {
		Solution solution = new SmallestDivisibleDigitProductI_3345().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int smallestNumber(int n, int t) {
			for (int i = n; i < n + 100; i++) {
				if (getJi(i) % t == 0) {
					return i;
				}
			}
			return -1;
		}

		private int getJi(int n) {
			int ji = 1;
			while (n > 0) {
				ji *= n % 10;
				n /= 10;
			}
			return ji;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}