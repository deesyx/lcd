//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4634 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_One5 {
    public static void main(String[] args) {
        Solution solution = new ThreeSum_One5().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int i = 0;
            while (i < nums.length) {
                int num = nums[i];
                List<List<Integer>> paths = twoSum(nums, i + 1, -num);
                for (List<Integer> path : paths) {
                    path.add(num);
                    ans.add(path);
                }

                while (i < nums.length && nums[i] == num) i++;
            }

            return ans;
        }

        private List<List<Integer>> twoSum(int[] nums, int start, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                int sum = leftValue + rightValue;
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    List<Integer> path = new ArrayList<>();
                    path.add(leftValue);
                    path.add(rightValue);
                    ans.add(path);
                    while (left < right && nums[left] == leftValue) left++;
                    while (left < right && nums[right] == rightValue) right--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
