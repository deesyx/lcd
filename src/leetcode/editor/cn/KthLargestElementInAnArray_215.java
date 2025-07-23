//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2781 👎 0


package leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray_215 {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray_215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            int target = nums.length - k;
            int left = 0;
            int right = nums.length - 1;

            while (true) {
                int j = partion(nums, left, right);
                if (j == target) {
                    return nums[j];
                } else if (j < target) {
                    left = j + 1;
                } else {
                    right = j - 1;
                }
            }
        }

        private int partion(int[] nums, int left, int right) {
            int randomIndex = random.nextInt(right - left + 1) + left;
            int pivot = nums[randomIndex];
            swap(nums, randomIndex, right);
            int p1 = left;
            int p2 = left;
            while (p1 < right) {
                if (nums[p1] < pivot) {
                    swap(nums, p1, p2);
                    p2++;
                }
                p1++;
            }
            swap(nums, p2, right);
            return p2;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}