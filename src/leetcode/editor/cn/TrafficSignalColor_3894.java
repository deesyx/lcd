//给你一个整数 timer，表示交通信号灯上的剩余时间（以秒为单位）。 
//
// 信号灯遵循以下规则： 
//
// 
// 如果 timer == 0，信号灯为 "Green" 
// 如果 timer == 30，信号灯为 "Orange" 
// 如果 30 < timer <= 90，信号灯为 "Red" 
// 
//
// 返回信号灯的当前状态。如果均不满足上述条件，返回 "Invalid"。 
//
// 
//
// 示例 1： 
//
// 
// 输入： timer = 60 
// 
//
// 输出： "Red" 
//
// 解释： 
//
// 因为 timer = 60，且 30 < timer <= 90，所以答案是 "Red"。 
//
// 示例 2： 
//
// 
// 输入： timer = 5 
// 
//
// 输出： "Invalid" 
//
// 解释： 
//
// 因为 timer = 5，不满足任何给定的条件，所以答案是 "Invalid"。 
//
// 
//
// 提示： 
//
// 
// 0 <= timer <= 1000 
// 
//
// 👍 0 👎 0


package leetcode.editor.cn;

public class TrafficSignalColor_3894 {
    public static void main(String[] args) {
        Solution solution = new TrafficSignalColor_3894().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String trafficSignal(int timer) {
            if(timer == 0){
                return "Green";
            }
            if(timer == 30){
                return "Orange";
            }
            if(timer > 30 && timer <= 90){
                return "Red";
            }
            return "Invalid";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}