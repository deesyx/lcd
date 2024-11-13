//给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
//
// 
// answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。 
// answer[i] == "Fizz" 如果 i 是 3 的倍数。 
// answer[i] == "Buzz" 如果 i 是 5 的倍数。 
// answer[i] == i （以字符串形式）如果上述条件全不满足。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["1","2","Fizz"]
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：["1","2","Fizz","4","Buzz"]
// 
//
// 示例 3： 
//
// 
//输入：n = 15
//输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","1
//4","FizzBuzz"] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// 👍 340 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    public static void main(String[] args) {
        Solution solution = new FizzBuzz_412().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            String[] ans = new String[n + 1];
            int k = 1;
            while (3 * k <= n) {
                ans[3 * k] = "Fizz";
                k++;
            }

            k = 1;
            while (5 * k <= n) {
                int idx = 5 * k;
                if (ans[idx] == null) {
                    ans[idx] = "Buzz";
                } else {
                    ans[idx] = "FizzBuzz";
                }
                k++;
            }

            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                String s = ans[i];
                if (s != null) {
                    list.add(s);
                } else {
                    list.add(String.valueOf(i));
                }
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}