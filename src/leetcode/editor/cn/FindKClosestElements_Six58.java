//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 342 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements_Six58 {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements_Six58().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ans = Arrays.stream(arr).boxed().collect(Collectors.toList());
            int n = ans.size();
            if (x <= ans.get(0)) {
                return ans.subList(0, k);
            }
            if (x >= ans.get(n - 1)) {
                return ans.subList(n - k, n);
            }

            int index = binarySearch(ans, x);
            int left = Math.max(0, index - k - 1);
            int right = Math.min(ans.size() - 1, index + k - 1);

            while (right - left + 1 > k) {
                if ((x - ans.get(left)) <= (ans.get(right) - x)) {
                    right--;
                } else if ((x - ans.get(left)) > (ans.get(right) - x)) {
                    left++;
                }
            }
            return ans.subList(left, right + 1);
        }

        private int binarySearch(List<Integer> ans, int x) {
            int left = 0;
            int right = ans.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ans.get(mid) == x) {
                    return mid;
                } else if (ans.get(mid) > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}