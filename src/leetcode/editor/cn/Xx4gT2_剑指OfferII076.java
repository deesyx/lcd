//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 60 👎 0


package leetcode.editor.cn;

public class Xx4gT2_剑指OfferII076 {
    public static void main(String[] args) {
        Solution solution = new Xx4gT2_剑指OfferII076().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int target;

        public int findKthLargest(int[] nums, int k) {
            this.target = nums.length - k;
            quickSort(nums, 0, nums.length - 1);
            return nums[this.target];

        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(nums, left, right);
                if (pivotIndex == target) {
                    return;
                }

                if (pivotIndex < target) {
                    quickSort(nums, pivotIndex + 1, right);
                } else {
                    quickSort(nums, left, pivotIndex - 1);
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            swap(nums, left, right);
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

        private void swap(int[] nums, int a, int b) {
            int t = nums[a];
            nums[a] = nums[b];
            nums[b] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}