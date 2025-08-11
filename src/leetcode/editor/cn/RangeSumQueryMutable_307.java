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
//
// Related Topics 设计 树状数组 线段树 数组 分治 👍 778 👎 0


package leetcode.editor.cn;

public class RangeSumQueryMutable_307 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private SegmentTree segmentTree;

        private class SegmentTree {
            int[] nums;
            int[] tree;
            int n;

            public SegmentTree(int[] nums) {
                this.nums = nums;
                this.n = nums.length;
                this.tree = new int[n * 4];
                build(0, n - 1, 1);
            }

            private void build(int start, int end, int idx) {
                if (start == end) {
                    tree[idx] = nums[start];
                    return;
                }

                int mid = start + (end - start) / 2;
                build(start, mid, idx * 2);
                build(mid + 1, end, idx * 2 + 1);
                pushUp(idx);
            }

            private void pushUp(int idx) {
                tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            }

            public int getSum(int left, int right, int start, int end, int idx) {
                if (left <= start && end <= right) {
                    return tree[idx];
                }
                int mid = start + (end - start) / 2;
                int sum = 0;
                if (left <= mid) {
                    sum += getSum(left, right, start, mid, idx * 2);
                }
                if (right > mid) {
                    sum += getSum(left, right, mid + 1, end, idx * 2 + 1);
                }
                return sum;
            }

            public void update(int index, int val, int start, int end, int idx) {
                if (start == end) {
                    tree[idx] = val;
                    return;
                }
                int mid = start + (end - start) / 2;
                if (index <= mid) {
                    update(index, val, start, mid, idx * 2);
                } else {
                    update(index, val, mid + 1, end, idx * 2 + 1);
                }
                pushUp(idx);
            }
        }

        public NumArray(int[] nums) {
            segmentTree = new SegmentTree(nums);
        }

        public void update(int index, int val) {
            segmentTree.update(index, val, 0, segmentTree.n - 1, 1);
        }

        public int sumRange(int left, int right) {
            return segmentTree.getSum(left, right, 0, segmentTree.n - 1, 1);
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