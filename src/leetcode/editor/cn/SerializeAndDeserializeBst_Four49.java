//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 308 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SerializeAndDeserializeBst_Four49 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Codec ser = new Codec();
        Codec deser = new Codec();
        String serialize = ser.serialize(root);
        TreeNode node = deser.deserialize(serialize);
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
    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder ans = new StringBuilder();
            preorder(root, ans);
            return ans.toString();
        }

        private void preorder(TreeNode node, StringBuilder ans) {
            if (node == null) {
                return;
            }
            ans.append(node.val).append(',');
            preorder(node.left, ans);
            preorder(node.right, ans);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            int[] preorder = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
            int[] inorder = Arrays.copyOf(preorder, preorder.length);
            Arrays.sort(inorder);

            int[] preorderIndex = new int[1];
            return dfs(preorder, inorder, preorderIndex, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int[] inorder, int[] preorderIndex, int inorderStart, int inorderEnd) {
            if (preorderIndex[0] >= preorder.length) {
                return null;
            }
            if (inorderStart > inorderEnd) {
                return null;
            }
            int curVal = preorder[preorderIndex[0]];
            TreeNode node = new TreeNode(curVal);
            preorderIndex[0]++;
            int curValIndexInInorder = find(inorder, inorderStart, inorderEnd, curVal);
            TreeNode left = dfs(preorder, inorder, preorderIndex, inorderStart, curValIndexInInorder - 1);
            TreeNode right = dfs(preorder, inorder, preorderIndex, curValIndexInInorder + 1, inorderEnd);
            node.left = left;
            node.right = right;
            return node;
        }

        private int find(int[] inorder, int inorderStart, int inorderEnd, int target) {
            int left = inorderStart;
            int right = inorderEnd;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (inorder[mid] == target) {
                    return mid;
                } else if (inorder[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}
