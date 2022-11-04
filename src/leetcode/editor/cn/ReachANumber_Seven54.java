//在一根无限长的数轴上，你站在0的位置。终点在target的位置。 
//
// 你可以做一些数量的移动 numMoves : 
//
// 
// 每次你可以选择向左或向右移动。 
// 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。 
// 
//
// 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
// 
//
// 示例 2: 
//
// 
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
// 
//
// 
//
// 提示: 
//
// 
// -10⁹ <= target <= 10⁹ 
// target != 0 
// 
// Related Topics 数学 二分查找 👍 282 👎 0


package leetcode.editor.cn;

public class ReachANumber_Seven54 {
    public static void main(String[] args) {
        Solution solution = new ReachANumber_Seven54().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachNumber(int target) {
            int step = 1;
            int num = 0;
            int t = Math.abs(target);
            while (num < t || (num - t) % 2 != 0) {
                num += step++;
            }
            return step - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}