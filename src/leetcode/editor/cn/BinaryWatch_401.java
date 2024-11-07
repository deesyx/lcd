//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "4:51" 。 
// 
//
// 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
//
// Related Topics 位运算 回溯 👍 436 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch_401().new Solution();
        solution.readBinaryWatch(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> ans = new ArrayList<>();
            int[] nums = new int[10];
            dfs(ans, nums, 0, turnedOn);
            return ans;
        }

        private void dfs(List<String> ans, int[] nums, int cur, int turnedOn) {
            if (turnedOn == 0) {
                int hour = getHour(nums);
                if (hour > 11) {
                    return;
                }
                int minute = getMinute(nums);
                if (minute > 59) {
                    return;
                }

                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(":");
                if (minute < 10) {
                    sb.append("0");
                }
                sb.append(minute);
                ans.add(sb.toString());
                return;
            }

            if(cur>=10){
                return;
            }

            nums[cur] = 1;
            dfs(ans, nums, cur + 1, turnedOn - 1);
            nums[cur] = 0;
            dfs(ans, nums, cur + 1, turnedOn);
        }

        private int getHour(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 4; i++) {
                ans += Math.pow(2, 3 - i) * nums[i];
            }
            return ans;
        }

        private int getMinute(int[] nums) {
            int ans = 0;
            for (int i = 4; i < nums.length; i++) {
                int j = i - 4;
                ans += Math.pow(2, 5 - j) * nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}