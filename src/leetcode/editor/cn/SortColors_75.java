//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1960 👎 0


package leetcode.editor.cn;

public class SortColors_75 {
    public static void main(String[] args) {
        Solution solution = new SortColors_75().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int start = 0;
            start = move(nums, start, 0);
            start = move(nums, start, 1);
            start = move(nums, start, 2);
        }

        private int move(int[] nums, int start, int target) {
            int i = start;
            int j = start;
            while (j < nums.length) {
                if (nums[j] == target) {
                    swap(nums, i, j);
                    i++;
                }
                j++;
            }
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}