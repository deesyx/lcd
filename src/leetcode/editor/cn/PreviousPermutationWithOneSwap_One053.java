//给你一个正整数数组 arr（可能存在重复的元素），
// 请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于
//arr 的最大排列。 
//
// 如果无法这么操作，就请返回原数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,2,1]
//输出：[3,1,2]
//解释：交换 2 和 1
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,5]
//输出：[1,1,5]
//解释：已经是最小排列
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,9,4,6,7]
//输出：[1,7,4,6,9]
//解释：交换 9 和 7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 88 👎 0


package leetcode.editor.cn;

public class PreviousPermutationWithOneSwap_One053 {
    public static void main(String[] args) {
        Solution solution = new PreviousPermutationWithOneSwap_One053().new Solution();
        solution.prevPermOpt1(new int[]{3, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int n = arr.length;
            int i = n - 1;
            int targetIndex = -1;
            while (i >= 1) {
                if (arr[i - 1] > arr[i]) {
                    targetIndex = i - 1;
                    break;
                }
                i--;
            }

            if (targetIndex == -1) {
                return arr;
            }

            int j = n - 1;
            int replaceIndex = n - 1;
            while (j > targetIndex) {
                if (arr[j] < arr[targetIndex] && arr[j] != arr[j - 1]) {
                    replaceIndex = j;
                    break;
                }
                j--;
            }

            int t = arr[targetIndex];
            arr[targetIndex] = arr[replaceIndex];
            arr[replaceIndex] = t;
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}