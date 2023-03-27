//给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。
// 换言之，请你找到 s 和 t 串中
//恰好 只有一个字符不同的子字符串对的数目。 
//
// 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。 
//
// 请你返回满足上述条件的不同子字符串对数目。 
//
// 一个 子字符串 是一个字符串中连续的字符。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba", t = "baba"
//输出：6
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//
//示例 2：
//
// 
//输入：s = "ab", t = "bb"
//输出：3
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("ab", "bb")
//("ab", "bb")
//("ab", "bb")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//
//示例 3：
//
// 
//输入：s = "a", t = "a"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "abe", t = "bbc"
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 100 
// s 和 t 都只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 动态规划 👍 103 👎 0


package leetcode.editor.cn;

public class CountSubstringsThatDifferByOneCharacter_One638 {
    public static void main(String[] args) {
        Solution solution = new CountSubstringsThatDifferByOneCharacter_One638().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s, String t) {
            int m = s.length();
            int n = t.length();

            int[][] dpB = new int[m + 1][n + 1]; // 以i，j结尾的最长相同后缀的长度
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dpB[i + 1][j + 1] = dpB[i][j] + 1;
                    }
                }
            }

            int[][] dpF = new int[m + 1][n + 1]; // 以i，j开头的最长相同前缀的长度
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dpF[i][j] = dpF[i + 1][j + 1] + 1;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < t.length(); j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        continue;
                    }

                    ans += (dpB[i][j] + 1) * (dpF[i + 1][j + 1] + 1);
                }
            }
            return ans;

//            int ans = 0;
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < t.length(); j++) {
//                    if (s.charAt(i) == t.charAt(j)) {
//                        continue;
//                    }
//
//                    int l = 1;
//                    while (i - l >= 0 && j - l >= 0 && s.charAt(i - l) == t.charAt(j - l)) {
//                        l++;
//                    }
//                    int r = 1;
//                    while (i + r < m && j + r < n && s.charAt(i + r) == t.charAt(j + r)) {
//                        r++;
//                    }
//
//                    ans += (i - (i - l)) * ((i + r) - i);
//                }
//            }
//            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}