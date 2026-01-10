class Solution {

    // Checks if we can split the array into at most k subarrays
    // such that the maximum subarray sum does not exceed 'mid'
    private boolean isPossible(int[] arr, int k, int mid) {

        int subArrays = 1; // At least one subarray is required
        int currentSum = 0; // Sum of the current subarray

        for (int a : arr) {

            // If adding current element exceeds allowed max sum,
            // start a new subarray
            if (currentSum + a > mid) {
                subArrays++;
                currentSum = a; // Start new subarray with current element
            }
            // Otherwise, keep adding to current subarray
            else {
                currentSum += a;
            }

            // If we need more than k subarrays, mid is not feasible
            if (subArrays > k)
                return false;
        }

        // Valid if we can split into k or fewer subarrays
        return subArrays <= k;
    }

    // Returns the sum of all elements
    // This represents the maximum possible answer
    private int getSum(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }

    // Returns the maximum element in the array
    // This represents the minimum possible answer
    private int getMax(int[] arr) {
        int max = 0;
        for (int a : arr) {
            max = Math.max(max, a);
        }
        return max;
    }

    public int splitArray(int[] nums, int k) {

        // Binary search range:
        // low  -> max element (minimum largest subarray sum)
        // high -> total sum (maximum largest subarray sum)
        int low = getMax(nums);
        int high = getSum(nums);

        int result = high; // Store the best valid answer

        // Binary search on the answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If it's possible to split with max sum = mid
            if (isPossible(nums, k, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try to minimize further
            }
            // If not possible, we need a larger max sum
            else {
                low = mid + 1;
            }
        }

        return result;
    }
}
