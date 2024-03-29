//在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。 
//
// 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下： 
//
// 
// 总共有 n 种语言，编号从 1 到 n 。 
// languages[i] 是第 i 位用户掌握的语言集合。 
// friendships[i] = [ui, vi] 表示 ui 和 vi 为好友关系。 
// 
//
// 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。 
//请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
//输出：1
//解释：你可以选择教用户 1 第二门语言，也可以选择教用户 2 第一门语言。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],
//[2,3]]
//输出：2
//解释：教用户 1 和用户 3 第三门语言，需要教 2 名用户。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 500 
// languages.length == m 
// 1 <= m <= 500 
// 1 <= languages[i].length <= n 
// 1 <= languages[i][j] <= n 
// 1 <= ui < vi <= languages.length 
// 1 <= friendships.length <= 500 
// 所有的好友关系 (ui, vi) 都是唯一的。 
// languages[i] 中包含的值互不相同。 
// 
// Related Topics 贪心 数组 👍 22 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach_One733 {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfPeopleToTeach_One733().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int n;

        public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
            this.n = n;
            Set<Integer> unconnected = new HashSet<>();
            for (int[] f : friendships) {
                if (!hasCommon(languages[f[0] - 1], languages[f[1] - 1])) {
                    unconnected.add(f[0]);
                    unconnected.add(f[1]);
                }
            }

            int[] m = new int[n + 1];
            int maxLangCount = 0;
            for (int u : unconnected) {
                for (int l : languages[u - 1]) {
                    m[l]++;
                    maxLangCount = Math.max(maxLangCount, m[l]);
                }
            }
            return unconnected.size() - maxLangCount;
        }

        private boolean hasCommon(int[] aLang, int[] bLang) {
            int[] m = new int[this.n + 1];
            for (int i : aLang) {
                m[i]++;
            }
            for (int j : bLang) {
                if (m[j] > 0) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}