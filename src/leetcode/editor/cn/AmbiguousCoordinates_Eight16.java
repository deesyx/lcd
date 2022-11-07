//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。
// 返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
// Related Topics 字符串 回溯 👍 95 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmbiguousCoordinates_Eight16 {
    public static void main(String[] args) {
        Solution solution = new AmbiguousCoordinates_Eight16().new Solution();
        solution.ambiguousCoordinates("(100)");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i < s.length() - 2; i++) {
                String part1 = s.substring(1, i + 1);
                String part2 = s.substring(i + 1, s.length() - 1);
                List<String> path1 = valid(part1);
                List<String> path2 = valid(part2);
                if (!path1.isEmpty() && !path2.isEmpty()) {
                    for (String p1 : path1) {
                        for (String p2 : path2) {
                            ans.add("(" + p1 + ", " + p2 + ")");
                        }
                    }
                }
            }
            return ans;
        }

        private List<String> valid(String s) {
            if (s.length() == 0) {
                return Collections.emptyList();
            }
            if (s.length() == 1) {
                return List.of(s);
            }
            if (s.startsWith("0")) {
                if (s.endsWith("0")) {
                    return Collections.emptyList();
                } else {
                    return List.of(s.charAt(0) + "." + s.substring(1));
                }
            } else {
                if (s.endsWith("0")) {
                    return List.of(s);
                } else {
                    List<String> ans = new ArrayList<>();
                    for (int i = 1; i < s.length(); i++) {
                        ans.add(s.substring(0, i) + "." + s.substring(i));
                    }
                    ans.add(s);
                    return ans;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}