class Solution {

    // Checks whether it is possible to ensure that
    // every number in nums is <= mid using at most maxOperations splits
    private boolean isPossible(int[] nums, int maxOperations, int mid) {
        long totalOps = 0; // total number of split operations needed

        for (int num : nums) {
            // Number of splits needed so that each resulting part is <= mid
            // Example: num = 9, mid = 3 → splits = 2 (9 → 3,3,3)
            int ops = num / mid;

            // If num is exactly divisible by mid,
            // one split is counted extra, so subtract 1
            if (num % mid == 0) {
                ops -= 1;
            }

            totalOps += ops;
        }

        // Check if total operations stay within allowed limit
        return totalOps <= maxOperations;
    }

    // Utility function to find the maximum element in the array
    // This becomes the upper bound of the binary search
    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1; // Minimum possible size
        int high = getMax(nums); // Maximum possible size
        int result = high; // Store the best (minimum) valid answer

        // Binary search on the answer (maximum allowed bag size)
        while (low <= high) {
            int mid = low + (high - low) / 2; // Candidate maximum size

            // If it's possible with size = mid, try to minimize it further
            if (isPossible(nums, maxOperations, mid)) {
                result = mid; // Update answer
                high = mid - 1; // Search left half for smaller valid size
            }
            // Otherwise, mid is too small → increase allowed size
            else {
                low = mid + 1;
            }
        }

        // result holds the minimum possible maximum size
        return result;
    }
}
