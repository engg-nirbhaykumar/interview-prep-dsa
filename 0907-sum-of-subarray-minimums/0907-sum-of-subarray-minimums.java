class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;  // Given constraint to prevent overflow

        long result = 0;  // Use long to safely store large sums before modulo

        // Pick each element as the starting index of subarray
        for (int i = 0; i < n; i++) {

            int min = arr[i];  // Minimum for subarray starting at i (initially arr[i])

            // Extend subarray from i to j
            for (int j = i; j < n; j++) {

                // Update the minimum element for current subarray arr[i...j]
                min = Math.min(min, arr[j]);

                // Add the minimum of this subarray to result
                result = (result + min) % mod;
            }
        }

        // Return result as int (since mod ensures it fits)
        return (int) result;
    }
}
