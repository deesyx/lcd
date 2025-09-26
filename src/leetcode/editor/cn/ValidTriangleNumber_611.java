//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,3,4]
//输出: 4 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 662 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class ValidTriangleNumber_611 {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber_611().new Solution();
        solution.triangleNumber(new int[]{1, 1, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int target = nums[i] + nums[j];
                    int idx = find(nums, target, j + 1, nums.length - 1);
                    if (idx < nums.length && nums[idx] < target) {
                        int size = idx - (j + 1) + 1;
                        ans += size;
                    }
                }
            }
            return ans;
        }

        private int find(int[] nums, int target, int start, int end) {
            int left = start;
            int right = end;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}