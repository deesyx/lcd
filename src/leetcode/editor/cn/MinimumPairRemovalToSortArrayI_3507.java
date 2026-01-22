//给你一个数组 nums，你可以执行以下操作任意次数： 
//
// 
// 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。 
// 用它们的和替换这对元素。 
// 
//
// 返回将数组变为 非递减 所需的 最小操作次数 。 
//
// 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [5,2,3,1] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 
// 元素对 (3,1) 的和最小，为 4。替换后 nums = [5,2,4]。 
// 元素对 (2,4) 的和为 6。替换后 nums = [5,6]。 
// 
//
// 数组 nums 在两次操作后变为非递减。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,2] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 数组 nums 已经是非递减的。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// -1000 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 链表 双向链表 有序集合 模拟 堆（优先队列） 👍 9 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

public class MinimumPairRemovalToSortArrayI_3507 {
	public static void main(String[] args) {
		Solution solution = new MinimumPairRemovalToSortArrayI_3507().new Solution();
		System.out.println(solution.minimumPairRemoval(new int[]{5, 2, 3, 1}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minimumPairRemoval(int[] nums) {
			LinkedList<Integer> q = new LinkedList<>();
			for (int n : nums) {
				q.add(n);
			}

			int ans = 0;
			while (q.size() > 1) {
				boolean order = true;
				int idx = 0;
				int minSum = Integer.MAX_VALUE;
				for (int i = 0; i < q.size() - 1; i++) {
					if (q.get(i) > q.get(i + 1)) {
						order = false;
					}

					int sum = q.get(i) + q.get(i + 1);
					if (sum < minSum) {
						minSum = sum;
						idx = i;
					}
				}

				if (order) {
					return ans;
				}
				q.remove(idx + 1);
				q.remove(idx);
				q.add(idx, minSum);
				ans++;
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}