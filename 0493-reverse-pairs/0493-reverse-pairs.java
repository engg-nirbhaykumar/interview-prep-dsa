class Solution {

    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int l, int r) {
        int count = 0;

        if (l < r) {
            int mid = l + (r - l) / 2;

            count += mergeSortAndCount(nums, l, mid);
            count += mergeSortAndCount(nums, mid + 1, r);

            // Count reverse pairs before merging
            count += countPairs(nums, l, mid, r);

            // Merge the two sorted halves
            merge(nums, l, mid, r);
        }

        return count;
    }

    // Count pairs satisfying nums[i] > 2 * nums[j]
    private int countPairs(int[] nums, int l, int mid, int r) {
        int count = 0;
        int j = mid + 1;

        for (int i = l; i <= mid; i++) {
            while (j <= r && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    // Same merge logic as inversion count
    private void merge(int[] nums, int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = nums[l + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while (i < n1) {
            nums[k++] = left[i++];
        }

        while (j < n2) {
            nums[k++] = right[j++];
        }
    }
}