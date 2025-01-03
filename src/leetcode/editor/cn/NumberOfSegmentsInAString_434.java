//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
//
// Related Topics 字符串 👍 227 👎 0


package leetcode.editor.cn;

public class NumberOfSegmentsInAString_434 {
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString_434().new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int i = 0;
            int ans = 0;
            while (i < s.length()) {
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                }
                ans++;

                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}