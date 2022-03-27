////////////////////输入一个字符串，打印出该字符串中字符的所有排列。 
////////////////////
//////////////////// 
////////////////////
//////////////////// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
////////////////////
//////////////////// 
////////////////////
//////////////////// 示例: 
////////////////////
//////////////////// 输入：s = "abc"
////////////////////输出：["abc","acb","bac","bca","cab","cba"]
//////////////////// 
////////////////////
//////////////////// 
////////////////////
//////////////////// 限制： 
////////////////////
//////////////////// 1 <= s 的长度 <= 8 
//////////////////// Related Topics 字符串 回溯 👍 523 👎 0
//////////////////
////////////////
//////////////
////////////
//////////
////////
//////
////
//


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof_剑指Offer38 {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof_剑指Offer38().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            Set<String> ans = new HashSet<>();
            boolean[] visited = new boolean[s.length()];
            StringBuilder path = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                dfs(s, visited, ans, path, i);
            }
            return ans.toArray(new String[]{});
        }

        private void dfs(String s, boolean[] visited, Set<String> ans, StringBuilder path, int cur) {
            if (visited[cur]) {
                return;
            }
            visited[cur] = true;
            path.append(s.charAt(cur));
            if (path.length() == s.length()) {
                ans.add(path.toString());
            } else {
                for (int i = 0; i < s.length(); i++) {
                    dfs(s, visited, ans, path, i);
                }
            }
            visited[cur] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
