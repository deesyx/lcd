//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 412 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof_剑指Offer57II {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof_剑指Offer57II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target <= 2) {
                return new int[][]{};
            }

            int small = 1;
            int big = 2;
            int middle = (1 + target) / 2;
            int curSum = small + big;
            List<List<Integer>> ans = new ArrayList<>();
            while (small < middle) {
                if (curSum == target) {
                    addAns(small, big, ans);
                }

                while (curSum > target && small < middle) {
                    curSum -= small;
                    small++;
                    if (curSum == target) {
                        addAns(small, big, ans);
                    }
                }
                big++;
                curSum += big;
            }
            int[][] ansArray = new int[ans.size()][];
            for (int i = 0; i < ans.size(); i++) {
                ansArray[i] = ans.get(i).stream().mapToInt(Integer::intValue).toArray();
            }
            return ansArray;
        }

        private void addAns(int small, int big, List<List<Integer>> ans) {
            List<Integer> path = new ArrayList<>(big - small + 1);
            for (int i = small; i <= big; i++) {
                path.add(i);
            }
            ans.add(path);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
