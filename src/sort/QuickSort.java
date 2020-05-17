package sort;

import java.util.Random;

public class QuickSort {

    Random random;

    public void sort(int[] nums) {
        random = new Random();
        qsort(nums, 0, nums.length - 1);
    }

    private void qsort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = random.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        int left = start;
        int right = end;

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left++;
                right--;
            }
        }

        qsort(nums, start, right);
        qsort(nums, left, end);
    }
}
