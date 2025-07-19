//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
//
// Related Topics 位运算 数组 回溯 👍 95 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TVdhkn_LCR_079 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            int count = 1 << n;
            List<List<Integer>> ans = new ArrayList<>();
            for (int num = 0; num < count; num++) {
                List<Integer> path = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (((1 << i) & num) != 0) {
                        path.add(nums[i]);
                    }
                }
                ans.add(path);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}