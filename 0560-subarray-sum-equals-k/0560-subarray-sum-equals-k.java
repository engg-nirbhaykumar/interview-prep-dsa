class Solution {
    public int subarraySum(int[] nums, int k) {

        // Map to store frequency of prefix sums encountered so far
        // Key   -> prefix sum
        // Value -> number of times this prefix sum has occurred
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Initialize with prefix sum 0 occurring once
        // This handles cases where a subarray starting from index 0 sums to k
        prefixSumMap.put(0, 1);

        int count = 0; // Stores total number of subarrays with sum = k
        int sum = 0; // Running prefix sum

        // Traverse through the array
        for (int num : nums) {

            // Update running sum
            sum += num;

            // We want: currentSum - previousSum = k
            // => previousSum = currentSum - k
            int complement = sum - k;

            // If this complement exists, it means there are subarrays
            // ending at current index whose sum is k
            count += prefixSumMap.getOrDefault(complement, 0);

            // Store/update the current prefix sum in the map
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        // Return the total count of subarrays with sum = k
        return count;
    }
}
