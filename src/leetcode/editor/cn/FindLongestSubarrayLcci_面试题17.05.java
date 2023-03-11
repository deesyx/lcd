//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 92 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarrayLcci_面试题1705 {
    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci_面试题1705().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findLongestSubarray(String[] array) {
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);

            int sum = 0;
            int ansEnd = -1;
            int ansStart = 0;
            for (int i = 0; i < array.length; i++) {
                char cur = array[i].charAt(0);
                sum += cur >= 'A' ? 1 : -1;
                if (m.containsKey(sum)) {
                    int idx = m.get(sum);
                    int curLength = i - (idx + 1) + 1;
                    if ((ansEnd - ansStart + 1) < curLength) {
                        ansEnd = i;
                        ansStart = idx + 1;
                    }
                } else {
                    m.put(sum, i);
                }
            }

            int ansLength = ansEnd - ansStart + 1;
            String[] ans = new String[ansLength];
            System.arraycopy(array, ansStart, ans, 0, ansLength);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}