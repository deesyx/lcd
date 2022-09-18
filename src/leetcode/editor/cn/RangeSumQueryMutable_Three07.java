//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 524 👎 0
// my线段树


package leetcode.editor.cn;

public class RangeSumQueryMutable_Three07 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private final SegmentNode root = new SegmentNode();
        private int SIZE;

        public NumArray(int[] nums) {
            SIZE = nums.length;
            for (int i = 0; i < SIZE; i++) {
                update(root, 0, SIZE - 1, i, i, nums[i]);
            }
        }

        public void update(int index, int val) {
            update(root, 0, SIZE - 1, index, index, val);
        }

        public int sumRange(int left, int right) {
            return query(root, 0, SIZE - 1, left, right);
        }

        private class SegmentNode {
            int val = 0;
            SegmentNode left = null;
            SegmentNode right = null;
        }

        private void update(SegmentNode node, int start, int end, int left, int right, int val) {
            pushDown(node);
            if (left <= start && end <= right) {
                node.val = val;
                return;
            }

            int mid = (start + end) / 2;
            if (left <= mid) {
                update(node.left, start, mid, left, right, val);
            }
            if (right > mid) {
                update(node.right, mid + 1, end, left, right, val);
            }
            pushUp(node);
        }

        private int query(SegmentNode node, int start, int end, int left, int right) {
            if (left <= start && end <= right) {
                return node.val;
            }
            int mid = (start + end) / 2;
            int ans = 0;
            pushDown(node);
            if (left <= mid) {
                ans += query(node.left, start, mid, left, right);
            }
            if (right > mid) {
                ans += query(node.right, mid + 1, end, left, right);
            }
            return ans;
        }

        private void pushUp(SegmentNode node) {
            node.val = node.left.val + node.right.val;
        }

        private void pushDown(SegmentNode node) {
            if (node.left == null) {
                node.left = new SegmentNode();
            }
            if (node.right == null) {
                node.right = new SegmentNode();
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}