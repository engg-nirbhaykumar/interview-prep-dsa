class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;   // Length of first array
        int m = nums2.length;   // Length of second array

        int size = n + m;       // Total size after merging

        // Array to store merged sorted elements
        int[] merged = new int[size];

        int i = 0;  // Pointer for nums1
        int j = 0;  // Pointer for nums2
        int k = 0;  // Pointer for merged array

        // Merge both arrays while both have elements
        while (i < n && j < m) {

            // Pick the smaller element and move its pointer
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1 (if any)
        while (i < n) {
            merged[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2 (if any)
        while (j < m) {
            merged[k++] = nums2[j++];
        }

        // If total number of elements is even,
        // median is the average of the two middle elements
        if (size % 2 == 0) {
            return (merged[size / 2] + merged[(size / 2) - 1]) / 2.0;
        } 
        // If odd, median is the middle element
        else {
            return merged[size / 2];
        }
    }
}
