//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的 回文串 的长度。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
//解释：可以构造的最长回文串是"a"，它的长度是 1。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 604 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome_409().new Solution();
        solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            if (s.length() <= 1) {
                return 1;
            }
            Map<Character, Integer> m = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                } else {
                    m.put(c, 1);
                }
            }
            int ans = 0;
            boolean hasOdd = false;
            for (Map.Entry<Character, Integer> entry : m.entrySet()) {
                if (entry.getValue() % 2 == 0) {
                    ans += entry.getValue();
                } else {
                    hasOdd = true;
                    ans += entry.getValue() - 1;
                }
            }

            if (hasOdd) {
                return ans + 1;
            } else {
                return ans;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}