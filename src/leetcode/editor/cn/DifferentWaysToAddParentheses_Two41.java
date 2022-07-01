//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。
// 你可以 按任意顺序 返回答案。
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 640 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses_Two41 {
    public static void main(String[] args) {
        Solution solution = new DifferentWaysToAddParentheses_Two41().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] cs;

        public List<Integer> diffWaysToCompute(String s) {
            cs = s.toCharArray();
            return dfs(0, cs.length - 1);
        }

        List<Integer> dfs(int left, int right) {
            List<Integer> anss = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                if (cs[i] >= '0' && cs[i] <= '9') {
                    continue;
                }

                List<Integer> leftValues = dfs(left, i - 1);
                List<Integer> rightValues = dfs(i + 1, right);
                for (int leftValue : leftValues) {
                    for (int rightValue : rightValues) {
                        int ans;
                        if (cs[i] == '+') {
                            ans = leftValue + rightValue;
                        } else if (cs[i] == '-') {
                            ans = leftValue - rightValue;
                        } else {
                            ans = leftValue * rightValue;
                        }
                        anss.add(ans);
                    }
                }
            }

            if (anss.isEmpty()) {
                int res = 0;
                for (int i = left; i <= right; i++) {
                    res = res * 10 + (cs[i] - '0');
                }
                anss.add(res);
            }
            return anss;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
