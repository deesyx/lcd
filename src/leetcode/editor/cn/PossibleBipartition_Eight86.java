//给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。
// 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
//
// 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和 bi的人归入同一组。当可以用
//这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// dislikes 中每一组都 不同 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 308 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleBipartition_Eight86 {
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition_Eight86().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class UnionFind {
            int[] parent;

            public UnionFind(int n) {
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) { // 找x的根节点
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]]; // 状态压缩，x的parent值变为x的parent的parent
                    x = parent[x];
                }
                return x;
            }

            void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }

                parent[rootQ] = rootP;
            }

            boolean isConnect(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                return rootP == rootQ;
            }
        }

        public boolean possibleBipartition(int n, int[][] dislikes) {
            UnionFind unionFind = new UnionFind(n);
            List<List<Integer>> group = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                group.add(new ArrayList<>());
            }
            for (int[] d : dislikes) {
                int a = d[0] - 1;
                int b = d[1] - 1;
                group.get(a).add(b);// a讨厌b
                group.get(b).add(a);// b讨厌a
            }

            for (int i = 0; i < n; i++) {
                for (int j : group.get(i)) {// 遍历i讨厌的人
                    if (unionFind.isConnect(i, j)) {// 如果i和j连接
                        return false;
                    }
                    unionFind.union(group.get(i).get(0), j);// 把i讨厌的人连接起来，因为i讨厌的人一定不能和i同组，所以i讨厌的人一定同组
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}