//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 673 👎 0


package leetcode.editor.cn;

public class PopulatingNextRightPointersInEachNodeIi_One17 {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi_One17().new Solution();
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            Node node = root;
            Node dummy = new Node();
            Node p = dummy;
            while (node != null) {
                if (node.left != null) {
                    p.next = node.left;
                    p = p.next;
                }
                if (node.right != null) {
                    p.next = node.right;
                    p = p.next;
                }
                node = node.next;
                if (node == null) {
                    p = dummy;
                    node = dummy.next;
                    dummy.next = null;
                }
            }
            return root;

//            dfs(root);
//            return root;
        }

        private void dfs(Node node) {
            if (node == null) {
                return;
            }

            if (node.left == null && node.right == null) {
                return;
            }

            Node rightLeft = getNode(node.next);
            if (node.left != null && node.right != null) {
                node.left.next = node.right;
                node.right.next = rightLeft;
            }
            if (node.left != null && node.right == null) {
                node.left.next = rightLeft;
            }
            if (node.right != null && node.left == null) {
                node.right.next = rightLeft;
            }

            dfs(node.right);
            dfs(node.left);
        }

        private Node getNode(Node node) {
            if (node == null) {
                return null;
            }
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            return getNode(node.next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}