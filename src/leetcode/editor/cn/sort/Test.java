package leetcode.editor.cn.sort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 5, 2, 7, 3, 8, 9, 6, 5, 4, 5, 3, 7, 1, 8, 0, 3};
        int[] ans = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ans);

//        mapPao(nums);
//        mapPaoE(nums);
//        xuanZe(nums);
//        chaRu(nums);
//        new QuickSort().sort(nums);
        new MergeSort().sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != ans[i]) {
                System.out.println(false);
            } else {
                System.out.println(nums[i]);
            }
        }
    }

    private static void mapPao(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void mapPaoE(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            int bound = i;
            i = 0;
            for (int j = 0; j < bound; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    i = j;
                }
            }
        }
    }

    private static void xuanZe(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void chaRu(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;
            while (j >= 0 && target < nums[j]) {
                swap(nums, j, j + 1);
                j--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static class QuickSort {
        void sort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(nums, left, right);
                quickSort(nums, left, pivotIndex - 1);
                quickSort(nums, pivotIndex + 1, right);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            swap(nums, left, right);
            int p1 = left;
            int p2 = left;
            while (p1 < right) {
                if (nums[p1] < pivot) {
                    swap(nums, p1, p2);
                    p2++;
                }
                p1++;
            }
            swap(nums, p2, right);
            return p2;
        }
    }

    private static class MergeSort {
        void sort(int[] nums) {
            int[] buffer = new int[nums.length];
            mergeSort(nums, buffer, 0, nums.length - 1);
        }

        private void mergeSort(int[] nums, int[] buffer, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(nums, buffer, left, mid);
                mergeSort(nums, buffer, mid + 1, right);
                merge(nums, buffer, left, mid, right);
            }
        }

        private void merge(int[] nums, int[] buffer, int left, int mid, int right) {
            int i1 = left;
            int i2 = mid + 1;
            for (int i = left; i <= right; i++) {
                if (i1 > mid) {
                    buffer[i] = nums[i2];
                    i2++;
                } else if (i2 > right) {
                    buffer[i] = nums[i1];
                    i1++;
                } else if (nums[i1] < nums[i2]) {
                    buffer[i] = nums[i1];
                    i1++;
                } else {
                    buffer[i] = nums[i2];
                    i2++;
                }
            }
            for (int i = left; i <= right; i++) {
                nums[i] = buffer[i];
            }
        }
    }
}
