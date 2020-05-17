package sort;

public class MergeSort {
    public void sort(int[] nums) {
        int[] temp = new int[nums.length];
        msort(nums, 0, nums.length - 1, temp);
    }

    private void msort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        msort(nums, start, mid, temp);
        msort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }
}
