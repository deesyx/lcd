//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
// Related Topics 双指针 字符串 👍 123 👎 0


package leetcode.editor.cn;

public class MagicalString_Four81 {
    public static void main(String[] args) {
        Solution solution = new MagicalString_Four81().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            if (n < 3) {
                return 1;
            }
            int[] magic = new int[n + 1]; // 用于存储神奇数字集合
            magic[0] = 1; // 初始化第1个元素为0
            magic[1] = 2;
            magic[2] = 2;
            int tail = 3;
            int p = 2;
            int ans = 1;
            int value = 2;
            int count = magic[p];
            while (tail < n) {
                value = value ^ 3; // 确定第"p"组内元素的值"value"是多少。(通过与3异或，可以将1和2互换)
                while (count > 0 && tail < n) { // 循环创建第"p"组内的"count"个元素，每个元素的值都是"value"
                    count--;
                    magic[tail++] = value;
                    if (value == 1) ans++; // 如果发现元素的值"value"是1，则将"ans"加1
                }
                count = magic[++p]; // 创建完第"p"组所有元素之后，获得下一组(即："p+1")需要创建的数字个数"count"
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}