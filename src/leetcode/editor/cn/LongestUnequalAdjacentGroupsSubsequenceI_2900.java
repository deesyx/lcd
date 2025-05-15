//给你一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的 二进制 数组 groups ，两个数组长度都是 n 。
//
// 你需要从 words 中选出 最长子序列。如果对于序列中的任何两个连续串，二进制数组 groups 中它们的对应元素不同，则 words 的子序列是不同的
//。 
//
// 正式来说，你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik 
//- 1] ，对于所有满足 0 <= j < k - 1 的 j 都有 groups[ij] != groups[ij + 1] 。 
//
// 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回 任意 一个。 
//
// 注意：words 中的元素是不同的 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["e","a","b"], groups = [0,0,1]
//输出：["e","b"]
//解释：一个可行的子序列是 [0,2] ，因为 groups[0] != groups[2] 。
//所以一个可行的答案是 [words[0],words[2]] = ["e","b"] 。
//另一个可行的子序列是 [1,2] ，因为 groups[1] != groups[2] 。
//得到答案为 [words[1],words[2]] = ["a","b"] 。
//这也是一个可行的答案。
//符合题意的最长子序列的长度为 2 。 
//
// 示例 2： 
//
// 
//输入：words = ["a","b","c","d"], groups = [1,0,1,1]
//输出：["a","b","c"]
//解释：一个可行的子序列为 [0,1,2] 因为 groups[0] != groups[1] 且 groups[1] != groups[2] 。
//所以一个可行的答案是 [words[0],words[1],words[2]] = ["a","b","c"] 。
//另一个可行的子序列为 [0,1,3] 因为 groups[0] != groups[1] 且 groups[1] != groups[3] 。
//得到答案为 [words[0],words[1],words[3]] = ["a","b","d"] 。
//这也是一个可行的答案。
//符合题意的最长子序列的长度为 3 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n == words.length == groups.length <= 100 
// 1 <= words[i].length <= 10 
// groups[i] 是 0 或 1。 
// words 中的字符串 互不相同 。 
// words[i] 只包含小写英文字母。 
// 
//
// Related Topics 贪心 数组 字符串 动态规划 👍 12 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI_2900 {
    public static void main(String[] args) {
        Solution solution = new LongestUnequalAdjacentGroupsSubsequenceI_2900().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            List<Integer> tmp0 = find(0, groups);
            List<Integer> tmp1 = find(1, groups);
            List<Integer> tmp;
            if (tmp0.size() > tmp1.size()) {
                tmp = tmp0;
            } else {
                tmp = tmp1;
            }

            List<String> ans = new ArrayList<>();
            for (Integer i : tmp) {
                ans.add(words[i]);
            }
            return ans;
        }

        private List<Integer> find(int first, int[] groups) {
            List<Integer> ans = new ArrayList<>();
            boolean same = true;
            for (int i = 0; i < groups.length; i++) {
                if ((same && groups[i] == first) || (!same && groups[i] != first)) {
                    ans.add(i);
                    same = !same;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}