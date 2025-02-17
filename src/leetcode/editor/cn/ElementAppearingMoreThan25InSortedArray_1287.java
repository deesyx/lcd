//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
//
// 请你找到并返回这个整数 
//
// 
//
// 示例： 
//
// 
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 0 <= arr[i] <= 10^5 
// 
//
// Related Topics 数组 👍 92 👎 0


package leetcode.editor.cn;

public class ElementAppearingMoreThan25InSortedArray_1287 {
    public static void main(String[] args) {
        Solution solution = new ElementAppearingMoreThan25InSortedArray_1287().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSpecialInteger(int[] arr) {
            int pre = arr[0];
            int count = 1;
            for (int i = 1; i < arr.length; i++) {
                int cur = arr[i];
                if (cur == pre) {
                    count++;
                } else {
                    if (count * 4 > arr.length) {
                        return pre;
                    } else {
                        pre = cur;
                        count = 1;
                    }
                }
            }

            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}