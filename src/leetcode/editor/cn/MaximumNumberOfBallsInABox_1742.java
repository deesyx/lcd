//你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit
//，即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。 
//
// 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，
//而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。 
//
// 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球
//数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：lowLimit = 1, highLimit = 10
//输出：2
//解释：
//盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
//小球数量：2 1 1 1 1 1 1 1 1 0  0  ...
//编号 1 的盒子放有最多小球，小球数量为 2 。 
//
// 示例 2： 
//
// 
//输入：lowLimit = 5, highLimit = 15
//输出：2
//解释：
//盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
//小球数量：1 1 1 1 2 2 1 1 1 0  0  ...
//编号 5 和 6 的盒子放有最多小球，每个盒子中的小球数量都是 2 。
// 
//
// 示例 3： 
//
// 
//输入：lowLimit = 19, highLimit = 28
//输出：2
//解释：
//盒子编号：1 2 3 4 5 6 7 8 9 10 11 12 ...
//小球数量：0 1 1 1 1 1 1 1 1 2  0  0  ...
//编号 10 的盒子放有最多小球，小球数量为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= lowLimit <= highLimit <= 10⁵ 
// 
//
// Related Topics 哈希表 数学 计数 👍 82 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox_1742 {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfBallsInABox_1742().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int ans = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = lowLimit; i <= highLimit; i++) {
                int sum = sum(i);
                m.put(sum, m.getOrDefault(sum, 0) + 1);
                Integer cur = m.get(sum);
                ans = Math.max(ans, cur);
            }
            return ans;
        }

        private int sum(int num) {
            int ans = 0;
            while (num != 0) {
                ans += num % 10;
                num = num / 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}