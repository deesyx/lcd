//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 180 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuLcof_剑指Offer32I {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof_剑指Offer32I().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node == null) {
                        break;
                    }
                    ans.add(node.val);
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }
            return ans.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
