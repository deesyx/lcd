//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 161 👎 0


package leetcode.editor.cn;

public class GetKthMagicNumberLcci_面试题17_09 {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci_面试题17_09().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] arr = new int[k];
            arr[0] = 1;
            int i3 = 0;
            int i5 = 0;
            int i7 = 0;
            for (int i = 1; i < k; i++) {
                int a = arr[i3] * 3;
                int b = arr[i5] * 5;
                int c = arr[i7] * 7;
                int min = Math.min(Math.min(a, b), c);
                if (min == a) i3++;
                if (min == b) i5++;
                if (min == c) i7++;
                arr[i] = min;
            }
            return arr[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}