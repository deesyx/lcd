//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。 
//
// 
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。 
// 
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。 
//
// 示例 2： 
//
// 
//输入：s = "aabcbaa"
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 计数 👍 44 👎 0


package leetcode.editor.cn;

public class SumOfBeautyOfAllSubstrings_One781 {
    public static void main(String[] args) {
        Solution solution = new SumOfBeautyOfAllSubstrings_One781().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int ans = 0;
//            for (int i = 3; i <= s.length(); i++) {
//                for (int j = 0; j + i <= s.length(); j++) {
//                    int[] m = new int[26];
//                    for (int k = j; k < j + i; k++) {
//                        char c = s.charAt(k);
//                        m[c - 'a']++;
//                    }
//                    int max = 0;
//                    int min = Integer.MAX_VALUE;
//                    for (int cnt : m) {
//                        if (cnt > 0) {
//                            max = Math.max(max, cnt);
//                            min = Math.min(min, cnt);
//                        }
//                    }
//                    ans += max - min;
//                }
//            }

            for (int i = 0; i < s.length(); i++) {
                int[] m = new int[26];
                for (int j = i; j < s.length(); j++) {
                    m[s.charAt(j) - 'a']++;
                    int max = 0;
                    int min = Integer.MAX_VALUE;
                    for (int cnt : m) {
                        if (cnt > 0) {
                            max = Math.max(max, cnt);
                            min = Math.min(min, cnt);
                        }
                    }
                    ans += max - min;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}