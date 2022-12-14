//给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条
//长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。 
//
// 给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，你的任务是对于每个查询 queries[j] ，判断
//是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。 
//
// 请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 
//true 时， answer 第 j 个值为 true ，否则为 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0
//,2,5]]
//输出：[false,true]
//解释：上图为给定的输入数据。注意到 0 和 1 之间有两条重边，分别为 2 和 16 。
//对于第一个查询，0 和 1 之间没有小于 2 的边，所以我们返回 false 。
//对于第二个查询，有一条路径（0 -> 1 -> 2）两条边都小于 5 ，所以这个查询我们返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],
//[1,4,13]]
//输出：[true,false]
//解释：上图为给定数据。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= edgeList.length, queries.length <= 10⁵ 
// edgeList[i].length == 3 
// queries[j].length == 3 
// 0 <= ui, vi, pj, qj <= n - 1 
// ui != vi 
// pj != qj 
// 1 <= disi, limitj <= 10⁹ 
// 两个点之间可能有 多条 边。 
// 
// Related Topics 并查集-递归 图 数组 排序 👍 105 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceOfEdgeLengthLimitedPaths_One697 {
    public static void main(String[] args) {
        Solution solution = new CheckingExistenceOfEdgeLengthLimitedPaths_One697().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] parents;

        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            Integer[] qid = new Integer[queries.length];
            for (int i = 0; i < queries.length; i++) {
                qid[i] = i;
            }
            Arrays.sort(qid, Comparator.comparingInt(o -> queries[o][2]));
            boolean[] ans = new boolean[queries.length];
            int idx = 0;
            for (int i : qid) {
                int limit = queries[i][2];
                while (idx < edgeList.length && edgeList[idx][2] < limit) {
                    union(edgeList[idx][0], edgeList[idx][1]);
                    idx++;
                }
                ans[i] = isConnected(queries[i][0], queries[i][1]);
            }

            return ans;
        }

        private int find(int x) {
            if (x != parents[x]) { // 当x不是根节点
                parents[x] = find(parents[x]); // 找x的parent的根节点
            }
            return parents[x];
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            parents[rootP] = rootQ;
        }

        private boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}