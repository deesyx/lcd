//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
//
// Related Topics 深度优先搜索 字典树 👍 501 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers_386().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            int number = 1;
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                ans.add(number);
                if (number * 10 <= n) {
                    number = number * 10;
                } else {
                    while (number % 10 == 9 || number + 1 > n) {
                        number = number / 10;
                    }
                    number++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}