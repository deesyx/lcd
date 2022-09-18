//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
//矩形 i 左下角的坐标， (xi1, yi1) 是该矩形 左下角 的坐标， (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
// Related Topics 线段树 数组 有序集合 扫描线 👍 171 👎 0
// my线段树
// 矩形面积


package leetcode.editor.cn;

import java.util.*;

public class RectangleAreaIi_Eight50 {
    public static void main(String[] args) {
        Solution solution = new RectangleAreaIi_Eight50().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = (int) 1e9 + 7;
        private static final int IN = 1;
        private static final int OUT = -1;

        public int rectangleArea(int[][] rectangles) {
            //用TreeSet将纵坐标去重并用于后续离散化
            TreeSet<Integer> ySet = new TreeSet<>();
            List<int[]> xList = new ArrayList<>();
            for (int[] rect : rectangles) {
                //记录入边 结构是 x -> y1 y2 1/-1
                xList.add(new int[]{rect[0], rect[1], rect[3], IN});
                //记录出边 结构是 x -> y1 y2 1/-1
                xList.add(new int[]{rect[2], rect[1], rect[3], OUT});
                ySet.add(rect[1]);
                ySet.add(rect[3]);
            }

            //用正反两个HashMap存储离散化后坐标和实际纵坐标的关系
            Map<Integer, Integer> y2Index = new HashMap<>();
            Map<Integer, Integer> index2y = new HashMap<>();
            //将纵坐标离散化，从1开始
            int count = 1;
            for (int y : ySet) {
                //记录实际坐标和离散化坐标的关系
                y2Index.put(y, count);
                //记录离散化坐标和实际坐标的关系
                index2y.put(count, y);
                count++;
            }

            //按照x轴从小到大排序
            xList.sort(Comparator.comparingInt(x -> x[0]));

            //开线段树的根节点
            SegmentTree segmentTree = new SegmentTree();
            long ans = 0;
            int n = xList.size();
            for (int i = 0; i < n - 1; i++) {
                int[] cur = xList.get(i);
                //分别取出当前边的上下两个坐标
                int left = y2Index.get(cur[1]);
                int right = y2Index.get(cur[2]);
                //将当前的边的区间更新到线段树上
                segmentTree.update(left, right - 1, cur[3], index2y);
                ans += (long) segmentTree.query() * (xList.get(i + 1)[0] - cur[0]);
            }
            return (int) (ans % MOD);
        }

        class SegmentTree {

            private static final int maxNode = 201;

            private SegmentNode root;

            public SegmentTree() {
                root = new SegmentNode();
            }

            // 用于扫描线问题的线段树类
            private class SegmentNode {
                public SegmentNode left;
                public SegmentNode right;
                public int coverLen;
                public int isCover; // >0 cover, 0 not cover
            }

            public void update(int left, int right, int value, Map<Integer, Integer> index2y) {
                update(root, 1, maxNode, left, right, value, index2y);
            }

            public int query() {
                return root.coverLen;
            }

            private void update(SegmentNode root, int start, int end, int left, int right, int value, Map<Integer, Integer> index2y) {
                //先为当前节点动态开左右节点
                pushDown(root);
                if (left <= start && end <= right) {
                    root.isCover += value;
                    //pushUp更新当前节点的区间长度
                    pushUp(root, start, end, index2y);
                    return;
                }
                int mid = start + (end - start) / 2;
                // 分别更新左右区间
                if (left <= mid) {
                    update(root.left, start, mid, left, right, value, index2y);
                }
                if (mid < right) {
                    update(root.right, mid + 1, end, left, right, value, index2y);
                }
                // pushUp更新当前节点的区间长度
                pushUp(root, start, end, index2y);
            }

            // 更新线段树节点对应的区间长度
            private void pushUp(SegmentNode root, int start, int end, Map<Integer, Integer> index2y) {
                // root.isCover是更新到整个区间上所有边的in或者out标记之和，
                // 如果isCover > 0，则当前区间被完全覆盖，通过index2y找到实际的覆盖长度
                if (root.isCover > 0) {
                    root.coverLen = index2y.get(end + 1) - index2y.get(start);
                } else if (start != end) {
                    // cover == 0，则表示该区间没有被完全覆盖，直接相加左右子树的覆盖长度
                    root.coverLen = root.left.coverLen + root.right.coverLen;
                } else {
                    // 如果 start == end，不代表任何区间，长度是0
                    root.coverLen = 0;
                }
            }

            // 动态开左右节点
            private void pushDown(SegmentNode root) {
                if (root.left == null) {
                    root.left = new SegmentNode();
                }
                if (root.right == null) {
                    root.right = new SegmentNode();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
