//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 174 👎 0


package leetcode.editor.cn;

public class OneAwayLcci_面试题0105 {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci_面试题0105().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int m = first.length();
            int n = second.length();
            if (Math.abs(m - n) > 1) {
                return false;
            }
            if (m == n) {
                int count = 0;
                for (int i = 0; i < m; i++) {
                    if (first.charAt(i) == second.charAt(i)) {
                        continue;
                    }

                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
                return true;
            }

            String longer;
            String shorter;
            if (m > n) {
                longer = first;
                shorter = second;
            } else {
                longer = second;
                shorter = first;
            }

            int i = 0;
            int j = 0;
            int count = 0;
            while (i < longer.length() && j < shorter.length()) {
                if (longer.charAt(i) == shorter.charAt(j)) {
                    i++;
                    j++;
                    continue;
                }
                count++;
                if (count > 1) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
