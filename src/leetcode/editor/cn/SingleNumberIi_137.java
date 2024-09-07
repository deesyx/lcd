//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// Related Topics 位运算 数组 👍 1239 👎 0


package leetcode.editor.cn;

public class SingleNumberIi_137 {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi_137().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] count = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    int val = 1 << i;
                    if ((val & num) != 0) {
                        count[i]++;
                    }
                }
            }

            for (int i = 0; i < 32; i++) {
                count[i] = count[i] % 3;
            }

            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (count[i] == 0) {
                    continue;
                }
                ans = ans | (1 << i);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}