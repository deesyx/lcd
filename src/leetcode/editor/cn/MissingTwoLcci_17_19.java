//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
// Related Topics 位运算 数组 哈希表 👍 143 👎 0


package leetcode.editor.cn;

public class MissingTwoLcci_17_19 {
    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci_17_19().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            int xorSum = 0;
            int n = nums.length + 2;
            for (int num : nums) {
                xorSum ^= num;
            }
            for (int i = 1; i <= n; i++) {
                xorSum ^= i;
            }

            int lsb = 0;
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & xorSum) != 0) {
                    lsb = 1 << i;
                    break;
                }
            }

            int ans1 = 0;
            int ans2 = 0;
            for (int num : nums) {
                if ((num & lsb) != 0) {
                    ans1 ^= num;
                } else {
                    ans2 ^= num;
                }
            }

            for (int i = 0; i <= n; i++) {
                if ((i & lsb) != 0) {
                    ans1 ^= i;
                } else {
                    ans2 ^= i;
                }
            }

            return new int[]{ans1, ans2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}