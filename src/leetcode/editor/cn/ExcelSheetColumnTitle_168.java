//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics 数学 字符串 👍 725 👎 0


package leetcode.editor.cn;

public class ExcelSheetColumnTitle_168 {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle_168().new Solution();
        solution.convertToTitle(700);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;
                int n = columnNumber % 26;
                sb.append(map(n));
                columnNumber = columnNumber / 26;
            }
            return sb.reverse().toString();
        }

        public String map(int n) {
            char c = (char) ('A' + n);
            return "" + c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}