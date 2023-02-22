//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 1145 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_Nine3 {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses_Nine3().new Solution();
        solution.restoreIpAddresses("25525511135");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();

            dfs(s, ans, path, 0, 0);
            return ans;
        }

        private void dfs(String s, List<String> ans, List<String> path, int start, int countPoint) {
            if (path.size() == 4) {
                if (start == s.length()) {
                    ans.add(String.join(".", path));
                }
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (isValid(s, start, i)) {
                    path.add(s.substring(start, i + 1));
                    dfs(s, ans, path, i + 1, countPoint);
                    path.remove(path.size() - 1);
                } else {
                    break;
                }
            }
        }

        private boolean isValid(String s, int start, int end) {
            String ip = s.substring(start, end + 1);
            if (ip.isEmpty() || ip.length() > 3) {
                return false;
            }
            if (ip.length() > 1 && ip.charAt(0) == '0') {
                return false;
            }
            if (Integer.parseInt(ip) > 255) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}