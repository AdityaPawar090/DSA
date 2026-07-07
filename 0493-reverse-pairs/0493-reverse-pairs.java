class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = mergeSort(nums, low, mid)
                  + mergeSort(nums, mid + 1, high);

        int right = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right <= high && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (i = low, k = 0; i <= high; i++, k++) {
            nums[i] = temp[k];
        }

        return count;
    }
}