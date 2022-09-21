//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 748 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class PartitionToKEqualSumSubsets_Six98 {
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets_Six98().new Solution();
        solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if (sum % k != 0) {
                return false;
            }

            Arrays.sort(nums);
            int i = 0;
            int j = nums.length - 1;
            while (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }// 倒序，先让值大的元素选择桶，这样可以增加剪枝的命中率，从而降低回溯的概率

            int[] bucket = new int[k];
            int target = sum / k;
            return dfs(nums, 0, bucket, target);
        }

        private boolean dfs(int[] nums, int index, int[] bucket, int target) {
            if (index == nums.length) {
                return true;
            }

            for (int i = 0; i < bucket.length; i++) {
                // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }
                if (bucket[i] + nums[index] > target) {
                    continue;
                }
                bucket[i] += nums[index];
                boolean ans = dfs(nums, index + 1, bucket, target);
                if (ans) {
                    return true;
                }
                bucket[i] -= nums[index];
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}