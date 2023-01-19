//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
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
// Related Topics 数组 双指针 排序 👍 1492 👎 0


package leetcode.editor.cn;

public class SortColors_Seven5 {
    public static void main(String[] args) {
        Solution solution = new SortColors_Seven5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
//            int[] m = new int[3];
//            for (int n : nums) {
//                m[n]++;
//            }
//
//            int i = 0;
//            for (int j = 0; j < m.length; j++) {
//                for (int k = 0; k < m[j]; k++) {
//                    nums[i++] = j;
//                }
//            }

            int p0 = 0;
            int p1 = 0;
            int p = 0;

            while (p < nums.length) {
                if (nums[p] == 0) {
                    swap(nums, p0, p);
                    if (p0 < p1) {// 把1放在后面了
                        swap(nums, p1, p);
                    }
                    p0++;
                    p1++;
                } else if (nums[p] == 1) {
                    swap(nums, p1, p);
                    p1++;
                }
                p++;
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