//给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。 
//
// 你可以在 s 上按任意顺序多次执行下面两个操作之一： 
//
// 
// 累加：将 a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，s = "3456" 且 a =
// 5，则执行此操作后 s 变成 "3951"。 
// 轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。 
// 
//
// 请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。 
//
// 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符出现在字母表中的时
//间早于 b 中的对应字符。例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "5525", a = 9, b = 2
//输出："2050"
//解释：执行操作如下：
//初态："5525"
//轮转："2555"
//累加："2454"
//累加："2353"
//轮转："5323"
//累加："5222"
//累加："5121"
//轮转："2151"
//累加："2050"​​​​​​​​​​​​
//无法获得字典序小于 "2050" 的字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "74", a = 5, b = 1
//输出："24"
//解释：执行操作如下：
//初态："74"
//轮转："47"
//累加："42"
//轮转："24"​​​​​​​​​​​​
//无法获得字典序小于 "24" 的字符串。
// 
//
// 示例 3： 
//
// 
//输入：s = "0011", a = 4, b = 2
//输出："0011"
//解释：无法获得字典序小于 "0011" 的字符串。
// 
//
// 示例 4： 
//
// 
//输入：s = "43987654", a = 7, b = 3
//输出："00553311"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 100 
// s.length 是偶数 
// s 仅由数字 0 到 9 组成 
// 1 <= a <= 9 
// 1 <= b <= s.length - 1 
// 
//
// Related Topics 广度优先搜索 字符串 👍 52 👎 0


package leetcode.editor.cn;

import java.util.*;

public class LexicographicallySmallestStringAfterApplyingOperations_One625 {
    public static void main(String[] args) {
        Solution solution = new LexicographicallySmallestStringAfterApplyingOperations_One625().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLexSmallestString(String s, int a, int b) {
            Queue<String> q = new LinkedList<>();
            Set<String> m = new HashSet<>();
            q.offer(s);
            m.add(s);
            String ans = s;
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (ans.compareTo(cur) > 0) {
                    ans = cur;
                }

                char[] chars = cur.toCharArray();
                for (int i = 1; i < chars.length; i += 2) {
                    chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
                }
                String t1 = new String(chars);

                String t2 = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);

                if (!m.contains(t1)) {
                    m.add(t1);
                    q.offer(t1);
                }

                if (!m.contains(t2)) {
                    m.add(t2);
                    q.offer(t2);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}