class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        // Map to store prefix sum (count of odd numbers) and its frequency
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: one way to have prefix sum = 0 before processing any element
        prefixSumMap.put(0, 1);

        // Stores total number of valid subarrays
        int count = 0;

        // Prefix sum representing number of odd elements seen so far
        int sum = 0;

        // Traverse through the array
        for (int num : nums) {

            // Convert the number to 0 (even) or 1 (odd)
            // This helps in counting subarrays with exactly k odd numbers
            sum += num;

            // We want sum - previousSum = k
            // So previousSum = sum - k
            int complement = sum - k;

            // If such a prefix sum exists, add its frequency to the answer
            if (prefixSumMap.containsKey(complement)) {
                count += prefixSumMap.get(complement);
            }

            // Store/update the frequency of the current prefix sum
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        // Return total number of subarrays with exactly k odd numbers
        return count;
    }
}