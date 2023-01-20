//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 3030 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses_Two2 {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses_Two2().new Solution();
        for (int i = 1; i <= 8; i++) {
            System.out.println(i);
            solution.generateParenthesis(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
//            int[] dp = new int[n + 1];
//            dp[0] = 1;
//            dp[1] = 1;
//            for (int i = 2; i <= n; i++) {
//                for (int j = 0; j < i; j++) {
//                    dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
//                }
//            }
//            System.out.println("actual:" + dp[n]);

//            List<List<String>> dp = new ArrayList<>();
//            dp.add(new ArrayList<>() {{
//                add("");
//            }});
//            dp.add(new ArrayList<>() {{
//                add("()");
//            }});
//
//            for (int i = 2; i <= n; i++) {
//                List<String> path = new ArrayList<>();
//                for (int j = 0; j < i; j++) {
//                    List<String> ins = dp.get(j);
//                    List<String> rights = dp.get(i - 1 - j);
//                    for (String in : ins) {
//                        for (String right : rights) {
//                            path.add("(" + in + ")" + right);
//                        }
//                    }
//                }
//                dp.add(new ArrayList<>(path));
//            }
//            return dp.get(n);


            List<String> ans = new ArrayList<>();
            StringBuilder path = new StringBuilder();
            dfs(ans, path, 0, 0, n);
            System.out.println("expected:" + ans.size());
            return ans;
        }

        private void dfs(List<String> ans, StringBuilder path, int left, int right, int n) {
            if (path.length() == n * 2) {
                ans.add(path.toString());
                return;
            }

            if (left < n) {
                path.append("(");
                dfs(ans, path, left + 1, right, n);
                path.deleteCharAt(path.length() - 1);
            }
            if (right < left) {
                path.append(")");
                dfs(ans, path, left, right + 1, n);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}