//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
// Related Topics 几何 数学 👍 135 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ValidSquare_Five93 {
    public static void main(String[] args) {
        Solution solution = new ValidSquare_Five93().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            List<Integer> distances = new ArrayList<>();
            distances.add(dis(p1, p2));
            distances.add(dis(p1, p3));
            distances.add(dis(p1, p4));
            distances.add(dis(p2, p3));
            distances.add(dis(p2, p4));
            distances.add(dis(p3, p4));

            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int d : distances) {
                if (d == 0) {
                    return false;
                }
                max = Math.max(max, d);
                min = Math.min(min, d);
            }

            int countMax = 0;
            int countMin = 0;
            for (int d : distances) {
                if (d == max) {
                    countMax++;
                }
                if (d == min) {
                    countMin++;
                }
            }

            return countMax == 2 && countMin == 4;
        }

        private int dis(int[] p1, int[] p2) {
            return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}