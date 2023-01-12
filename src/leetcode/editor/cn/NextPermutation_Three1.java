//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 2029 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation_Three1 {
    public static void main(String[] args) {
        Solution solution = new NextPermutation_Three1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
         * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return;
            }

            int i = n - 2;
            while (i >= 0) {
                // 从后向前找第一个顺序对，这时nums[i]就是最靠右的较小数，[i+1,n-1]全是逆序对，也就是降序
                if (nums[i] < nums[i + 1]) {
                    break;
                }
                i--;
            }
            if (i == -1) {
                reverse(nums, 0, n - 1);
                return;
            }

            int j = n - 1;
            while (j > i) {
                // 从后向前找第一个比nums[i]大的数，这时nums[j]就是最靠小的较大数，因为[i+1,n-1]是降序
                if (nums[i] < nums[j]) {
                    break;
                }
                j--;
            }

            swap(nums, i, j);
            // 交换i，j后，[i+1,n-1]也必然也是降序
            reverse(nums, i + 1, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        private void swap(int[] nums, int a, int b) {
            int t = nums[a];
            nums[a] = nums[b];
            nums[b] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}