//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 603 👎 0


package leetcode.editor.cn;

public class DesignLinkedList_Seven07 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        private Node head = null;
        private Node tail = null;

        private int size = 0;

        private class Node {
            int val;
            Node pre = null;
            Node next = null;

            public Node(int val) {
                this.val = val;
            }
        }

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node node = getNode(index);
            if (node == null) {
                return -1;
            } else {
                return node.val;
            }
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (size == 0) {
                size++;
                head = node;
                tail = node;
                return;
            }
            size++;
            node.next = head;
            if (head != null) {
                head.pre = node;
            }
            head = node;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (size == 0) {
                size++;
                head = node;
                tail = node;
                return;
            }
            size++;
            node.pre = tail;
            if (tail != null) {
                tail.next = node;
            }
            tail = node;
        }

        public void addAtIndex(int index, int val) {
            if (index == size) {
                addAtTail(val);
            } else if (index <= 0) {
                addAtHead(val);
            } else if (index < size) {
                size++;
                Node node = getNode(index);
                if (node != null) {
                    Node newNode = new Node(val);
                    Node pre = node.pre;
                    pre.next = newNode;
                    node.pre = newNode;
                    newNode.pre = pre;
                    newNode.next = node;
                }
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            Node node = getNode(index);
            if (node == null) {
                return;
            }
            size--;
            Node pre = node.pre;
            Node next = node.next;
            if (pre == null) {
                head = next;
                if (head != null) {
                    head.pre = null;
                }
            } else {
                pre.next = next;
            }
            if (next == null) {
                tail = pre;
                if (tail != null) {
                    tail.next = null;
                }
            } else {
                next.pre = pre;
            }
        }

        private Node getNode(int index) {
            Node node = head;
            while (node != null && index > 0) {
                node = node.next;
                index--;
            }
            return node;
        }

        @Override
        public String toString() {
            Node node = head;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.val).append(" ");
                node = node.next;
            }
            return sb.toString();
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}