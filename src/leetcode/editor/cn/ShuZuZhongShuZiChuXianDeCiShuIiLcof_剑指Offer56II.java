//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 319 👎 0


package leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof_剑指Offer56II {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof_剑指Offer56II().new Solution();
        solution.singleNumber(new int[]{3, 5, 3, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] sums = new int[32];
            for (int i = 0; i < 32; i++) {
                int tmp = 1 << i;
                for (int num : nums) {
                    if ((num & tmp) != 0) {
                        sums[31 - i]++;
                    }
                }
                sums[31 - i] = sums[31 - i] % 3;
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (sums[i] != 0) {
                    ans = ans * 2 + 1;
                } else {
                    ans = ans * 2;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
