//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
// Related Topics 贪心 数学 👍 310 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MaximumSwap_Six70 {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap_Six70().new Solution();
        solution.maximumSwap(2736);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            List<Integer> arr = new ArrayList<>();
            while (num != 0) {
                arr.add(num % 10);
                num = num / 10;
            }

            List<Integer> sortedArray = new ArrayList<>(arr);
            sortedArray.sort(Comparator.naturalOrder());

            int targetValue = 0;
            int replaceIndex = 0;
            for (int i = arr.size() - 1; i >= 0; i--) {
                if (!Objects.equals(arr.get(i), sortedArray.get(i))) {
                    targetValue = sortedArray.get(i);
                    replaceIndex = i;
                    break;
                }
            }

            int targetIndex = replaceIndex;
            for (int i = replaceIndex; i >= 0; i--) {
                if (arr.get(i) == targetValue) {
                    targetIndex = Math.min(targetIndex, i);
                }
            }

            int t = arr.get(replaceIndex);
            arr.set(replaceIndex, targetValue);
            arr.set(targetIndex, t);

            int ans = 0;
            for (int i = arr.size() - 1; i >= 0; i--) {
                ans = ans * 10 + arr.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}