package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10000
 * -1000 <= nums[i] <= 1000
 * -10000000 <= k <= -10000000
 */

public class Abc {

    public static void main(String[] args) {
        Abc abc = new Abc();
        int ans = abc.getAns(new int[]{-1, -2, 3, -6}, -3);
        System.out.println(ans);
    }

    public int getAns(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int cur = sums[i];
            if (m.containsKey(cur)) {
                ans += m.get(cur);
            }
            int target = cur + k;
            m.put(target, m.getOrDefault(target, 0) + 1);
        }

        return ans;
    }


}
