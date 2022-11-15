//请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, 
//numberOfUnitsPerBoxi] ： 
//
// 
// numberOfBoxesi 是类型 i 的箱子的数量。 
// numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。 
// 
//
// 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。 
//
// 返回卡车可以装载 单元 的 最大 总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//输出：8
//解释：箱子的情况如下：
//- 1 个第一类的箱子，里面含 3 个单元。
//- 2 个第二类的箱子，每个里面含 2 个单元。
//- 3 个第三类的箱子，每个里面含 1 个单元。
//可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
//单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8 
//
// 示例 2： 
//
// 
//输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//输出：91
// 
//
// 
//
// 提示： 
//
// 
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 10⁶ 
// 
// Related Topics 贪心 数组 排序 👍 80 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumUnitsOnATruck_One710 {
    public static void main(String[] args) {
        Solution solution = new MaximumUnitsOnATruck_One710().new Solution();
        solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));

            int ans = 0;
            int count = 0;
            int i = 0;
            while (count < truckSize && i < boxTypes.length) {
                int[] b = boxTypes[i];
                int nextCount = count + b[0];
                if (nextCount > truckSize) {
                    break;
                }
                count = nextCount;
                ans += b[0] * b[1];
                i++;
            }

            if (count == truckSize || i == boxTypes.length) {
                return ans;
            }

            for (int j = 0; j < truckSize - count; j++) {
                ans += boxTypes[i][1];
            }
            return ans;
        }

        private int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}