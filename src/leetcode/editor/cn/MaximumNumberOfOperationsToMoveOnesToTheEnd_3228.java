//给你一个 二进制字符串 s。 
//
// 你可以对这个字符串执行 任意次 下述操作： 
//
// 
// 选择字符串中的任一下标 i（ i + 1 < s.length ），该下标满足 s[i] == '1' 且 s[i + 1] == '0'。 
// 将字符 s[i] 向 右移 直到它到达字符串的末端或另一个 '1'。例如，对于 s = "010010"，如果我们选择 i = 1，结果字符串将会是 s 
//= "000110"。 
// 
//
// 返回你能执行的 最大 操作次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "1001101" 
// 
//
// 输出： 4 
//
// 解释： 
//
// 可以执行以下操作： 
//
// 
// 选择下标 i = 0。结果字符串为 s = "0011101"。 
// 选择下标 i = 4。结果字符串为 s = "0011011"。 
// 选择下标 i = 3。结果字符串为 s = "0010111"。 
// 选择下标 i = 2。结果字符串为 s = "0001111"。 
// 
//
// 示例 2： 
//
// 
// 输入： s = "00111" 
// 
//
// 输出： 0 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 '0' 或 '1'。 
// 
//
// Related Topics 贪心 字符串 计数 👍 9 👎 0


package leetcode.editor.cn;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd_3228 {
	public static void main(String[] args) {
		Solution solution = new MaximumNumberOfOperationsToMoveOnesToTheEnd_3228().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxOperations(String s) {
			int ans = 0;
			int count1 = 0;
			int i = 0;
			while (i < s.length()) {
				if (s.charAt(i) == '1') {
					count1++;
				} else {
					while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
						i++;
					}
					ans += count1;
				}
				i++;
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}