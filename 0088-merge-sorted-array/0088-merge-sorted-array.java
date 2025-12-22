class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // i → pointer for the last valid element in nums1
        int i = m - 1;

        // j → pointer for the last element in nums2
        int j = n - 1;

        // k → pointer for the last position in nums1 (total size m + n)
        int k = m + n - 1;

        // Merge nums1 and nums2 starting from the end
        // This avoids overwriting elements in nums1
        while (i >= 0 && j >= 0) {

            // Compare current elements from nums1 and nums2
            if (nums1[i] > nums2[j]) {
                // Place the larger element at position k
                nums1[k--] = nums1[i--];
            } else {
                // Place nums2[j] at position k
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has remaining elements,
        // copy them into nums1
        // (No need to copy nums1 leftovers — they’re already in place)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
