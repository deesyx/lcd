//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。 
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5 
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
// 
//
// 示例 2： 
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 1 <= low <= high <= 2 * 10⁴ 
// 
// Related Topics 位运算 字典树 数组 👍 87 👎 0


package leetcode.editor.cn;

public class CountPairsWithXorInARange_One803 {
    public static void main(String[] args) {
        Solution solution = new CountPairsWithXorInARange_One803().new Solution();
        solution.countPairs(new int[]{1, 4, 2, 7}, 2, 6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private class TrieNode {
            TrieNode[] children = new TrieNode[2];
            int count = 0;
        }

        private void add(TrieNode root, int x) {
            TrieNode node = root;
            for (int k = 14; k >= 0; k--) {
                int v = (x >> k) & 1;
                if (node.children[v] == null) {
                    node.children[v] = new TrieNode();
                }
                node = node.children[v];
                node.count++;
            }
        }

        /**
         * 当limitV==1时，如果nums[i]与nums[j]在k位相同，那么nums[i]^nums[j]必小于limit（nums[i]^nums[j]在k位为0）
         * 如果nums[i]与nums[j]在k位不同，那么看下一位（nums[i]^nums[j]在k位为1）
         * 当limitV==0时，如果nums[i]与nums[j]在k位相同，那么看下一位（nums[i]^nums[j]在k位为0）
         * 如果nums[i]与nums[j]在k位不同，那么nums[i]^nums[j]必大于limit，不用再看了（nums[i]^nums[j]在k位为1）
         */
        private int get(TrieNode root, int x, int limit) {
            TrieNode node = root;
            int ans = 0;
            for (int k = 14; k >= 0 && node != null; k--) {
                int v = (x >> k) & 1;
                int limitV = (limit >> k) & 1;
                if (limitV == 1) {
                    if (node.children[v] != null) {
                        ans += node.children[v].count;
                    }
                    node = node.children[v ^ 1];
                } else {
                    node = node.children[v];
                }
            }
            return ans;
        }

        public int countPairs(int[] nums, int low, int high) {
            TrieNode root = new TrieNode();
            int ans = 0;
            for (int x : nums) {
                ans += get(root, x, high + 1) - get(root, x, low);
                add(root, x);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}