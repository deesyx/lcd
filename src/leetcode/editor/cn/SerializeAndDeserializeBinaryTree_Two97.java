//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1068 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_Two97 {
    public static void main(String[] args) {
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder ans = new StringBuilder();
            serializeDfs(root, ans);
            return ans.toString();

//            StringBuilder ans = new StringBuilder();
//            Queue<TreeNode> q = new LinkedList<>();
//            if (root != null) {
//                q.add(root);
//            }
//
//            while (!q.isEmpty()) {
//                TreeNode node = q.poll();
//                if (node != null) {
//                    ans.append(node.val);
//                    q.offer(node.left);
//                    q.offer(node.right);
//                } else {
//                    ans.append("null");
//                }
//                ans.append(",");
//            }
//
//            return ans.toString();
        }

        private void serializeDfs(TreeNode node, StringBuilder ans) {
            if (node == null) {
                ans.append("null").append(',');
                return;
            }

            ans.append(node.val).append(',');
            serializeDfs(node.left, ans);
            serializeDfs(node.right, ans);
        }

        // Decodes your encoded data to tree.
        private int idx = 0;

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] s = data.split(",");
            return deserializeDfs(s);


//            if (data.isEmpty()) {
//                return null;
//            }
//            String[] s = data.split(",");
//            TreeNode root = new TreeNode(Integer.parseInt(s[0]));
//            Queue<TreeNode> q = new LinkedList<>();
//            q.offer(root);
//            int idx = 1;
//            while (!q.isEmpty()) {
//                TreeNode node = q.poll();
//                String left = s[idx++];
//                if (!left.equals("null")) {
//                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
//                    q.offer(leftNode);
//                    node.left = leftNode;
//                }
//                String right = s[idx++];
//                if (!right.equals("null")) {
//                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
//                    q.offer(rightNode);
//                    node.right = rightNode;
//                }
//            }
//            return root;
        }

        private TreeNode deserializeDfs(String[] s) {
            String cur = s[idx++];
            if (cur.equals("null")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(cur));
            TreeNode left = deserializeDfs(s);
            TreeNode right = deserializeDfs(s);
            node.left = left;
            node.right = right;
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}