//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// Related Topics 数组 双指针 排序 👍 277 👎 0


package leetcode.editor.cn;

public class SortArrayByParity_Nine05 {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity_Nine05().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int p1 = 0;
            int p2 = 0;
            while (p1 < nums.length) {
                if (nums[p1] % 2 == 0) {
                    int t = nums[p2];
                    nums[p2] = nums[p1];
                    nums[p1] = t;
                    p2++;
                }
                p1++;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
