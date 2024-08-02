//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//
//> 输入：`cards = [1,2,8,9], cnt = 3`
//>
//> 输出：`18`
//>
//> 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//
//> 输入：`cards = [3,3,1], cnt = 1`
//>
//> 输出：`0`
//>
//> 解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
// Related Topics 贪心 数组 排序 👍 82 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class UOAnQW_LCP_40 {
    public static void main(String[] args) {
        // FIXME: 未AC
        Solution solution = new UOAnQW_LCP_40().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxmiumScore(int[] cards, int cnt) {
            Arrays.sort(cards);
            for (int i = 0; i < cards.length / 2; i++) {
                int t = cards[i];
                cards[i] = cards[cards.length - i - 1];
                cards[cards.length - i - 1] = t;
            }

            int[] ans = {0};
            for (int i = 0; i < cards.length; i++) {
                dfs(cards, cnt, 0, i, ans);
            }
            return ans[0];
        }

        private void dfs(int[] cards, int cnt, int sum, int start, int[] ans) {
            if (cnt == 0 && sum % 2 == 0) {
                ans[0] = Math.max(ans[0], sum);
                return;
            }

            for (int i = start; i < cards.length; i++) {
                dfs(cards, cnt - 1, sum + cards[i], i + 1, ans);
                if (ans[0] != 0) {
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}