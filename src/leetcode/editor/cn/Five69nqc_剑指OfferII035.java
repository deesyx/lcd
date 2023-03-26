//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
//
// Related Topics 数组 数学 字符串 排序 👍 41 👎 0


package leetcode.editor.cn;

import java.util.List;
import java.util.stream.Collectors;

public class Five69nqc_剑指OfferII035 {
    public static void main(String[] args) {
        Solution solution = new Five69nqc_剑指OfferII035().new Solution();
        solution.findMinDifference(List.of("23:59", "00:00"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] m = new int[1440 * 2];
            for (String s : timePoints) {
                int minute = toMinute(s);
                m[minute]++;
                m[minute + 1440]++;
            }

            int ans = 1440;
            int last = -1;
            for (int i = 0; i < m.length; i++) {
                if (m[i] == 0) {
                    continue;
                }

                if (m[i] > 1) {
                    return 0;
                }

                if (last == -1) {
                    last = i;
                    continue;
                } else {
                    ans = Math.min(ans, i - last);
                    last = i;
                }
            }

            return ans;
        }

        private int toMinute(String s) {
            String[] words = s.split(":");
            return Integer.parseInt(words[0]) * 60 + Integer.parseInt(words[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}