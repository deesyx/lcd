//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 最多两次 。请你找出所有出现 两次 的整数
//，并以数组形式返回。 
//
// 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间（不包括存储输出所需的空间）的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// nums 中的每个元素出现 一次 或 两次 
// 
//
// Related Topics 数组 哈希表 👍 817 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {
    public static void main(String[] args) {
        Solution solution = new FindAllDuplicatesInAnArray_442().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - 1 != i) {
                    ans.add(nums[i]);
                }
            }

            return ans;
        }

        private void swap(int[] nums, int idx1, int idx2) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}