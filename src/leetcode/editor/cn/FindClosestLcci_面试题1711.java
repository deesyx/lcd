//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 👍 64 👎 0


package leetcode.editor.cn;

public class FindClosestLcci_面试题1711 {
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci_面试题1711().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            int p1 = -1;
            int p2 = -1;
            int ans = words.length;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.equals(word1)) {
                    p1 = i;
                }
                if (word.equals(word2)) {
                    p2 = i;
                }
                if (p1 != -1 && p2 != -1) {
                    ans = Math.min(Math.abs(p1 - p2), ans);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
