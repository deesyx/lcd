//给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [1,0,0,0,1,0,0,1], k = 2
//输出：true
//解释：每个 1 都至少相隔 2 个元素。 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [1,0,0,1,0,1], k = 2
//输出：false
//解释：第二个 1 和第三个 1 之间只隔了 1 个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= k <= nums.length 
// nums[i] 的值为 0 或 1 
// 
//
// Related Topics 数组 👍 40 👎 0


package leetcode.editor.cn;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway_1437 {
	public static void main(String[] args) {
		Solution solution = new CheckIfAll1sAreAtLeastLengthKPlacesAway_1437().new Solution();
		solution.kLengthApart(new int[]{1, 0, 0, 1}, 2);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean kLengthApart(int[] nums, int k) {
			int i = 0;
			while (i < nums.length) {
				if (nums[i] == 0) {
					i++;
				} else {
					int count = 0;
					i++;
					while (i < nums.length && nums[i] == 0) {
						count++;
						i++;
					}
					if (i < nums.length && count < k) {
						return false;
					}
				}
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}