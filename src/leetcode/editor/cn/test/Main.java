package leetcode.editor.cn.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sizeStr = in.nextLine();
        int size = Integer.parseInt(sizeStr);

        for (int i = 0; i < size; i++) {
            String subSizeStr = in.nextLine();
            int subSize = Integer.parseInt(subSizeStr);

            int[][] nums = new int[subSize][4];
            for (int j = 0; j < subSize; j++) {
                String line = in.nextLine();
                String[] words = line.split(" ");
                for (int k = 0; k < 4; k++) {
                    nums[j][k] = Integer.parseInt(words[k]);
                }
            }
            solve(nums);
        }
    }

    private static void solve(int[][] nums) {
        int n = nums.length;
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        dpLeft[0] = nums[0][0];
        dpRight[0] = nums[0][2];

        for (int i = 1; i < n; i++) {
            int aCur = nums[i][0];
            int bCur = nums[i][1];
            int cCur = nums[i][2];
            int dCur = nums[i][3];

            int aPre = nums[i - 1][0];
            int bPre = nums[i - 1][1];
            int cPre = nums[i - 1][2];
            int dPre = nums[i - 1][3];

            dpLeft[i] = Math.max(dpLeft[i - 1], dpRight[i - 1] - dPre) + aCur;
            dpRight[i] = Math.max(dpLeft[i - 1] - bPre, dpRight[i - 1]) + cCur;
        }

        int ans = Math.max(dpLeft[n - 1], dpRight[n - 1]);
        System.out.println(ans);
    }
}
