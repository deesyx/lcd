//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 3274 👎 0


package leetcode.editor.cn;

public class HouseRobber_198 {
    public static void main(String[] args) {
        Solution solution = new HouseRobber_198().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 2,1,1,2
    // dp1=2,1,3,4
    // dp2=0,2,2,3
    class Solution {
        public int rob(int[] nums) {
            int[] dp1 = new int[nums.length];// 当前偷
            int[] dp2 = new int[nums.length];// 当前不偷
            dp1[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                dp1[i] = dp2[i - 1] + nums[i];
                dp2[i] = Math.max(dp1[i - 1], dp2[i - 1]);
            }

            return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}