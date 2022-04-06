//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 👍 174 👎 0


package leetcode.editor.cn;

public class HeWeiSdeLiangGeShuZiLcof_剑指Offer57 {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLiangGeShuZiLcof_剑指Offer57().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int p1 = 0;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum == target) {
                    return new int[]{nums[p1], nums[p2]};
                } else if (sum < target) {
                    p1++;
                } else {
                    p2--;
                }
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
