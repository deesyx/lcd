//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 👍 741 👎 0


package leetcode.editor.cn;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof_剑指Offer62 {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof_剑指Offer62().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 最后一个剩下的数，它的index必定为0
         * 对于长度为n-1的数组，我们先把被杀掉的那个补充回来，然后右移m个人，发现溢出了，再把溢出的补充在最前面，就恢复了，可以得到幸存数的index
         * f(n)表示最后一个剩下的数在长度为n的数组中的index
         * f(n)=(f(n-1)+m)%n
         */
        public int lastRemaining(int n, int m) {
            int index = 0;
            for (int i = 2; i <= n; i++) {
                index = (index + m) % i;
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}