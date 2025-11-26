class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Count subarrays with exactly k distinct numbers
        // using the formula:
        // exactly(k) = atMost(k) - atMost(k - 1)
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }

    // Helper method: counts subarrays with at most k distinct numbers
    private int slidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0;           // left pointer of sliding window
        int result = 0;         // total count of valid subarrays
        Map<Integer, Integer> freqMap = new HashMap<>(); // stores frequency of numbers in window

        for (int right = 0; right < n; right++) {
            // Add current element to frequency map
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink window if distinct count exceeds k
            while (freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);

                // Remove element from map when its frequency becomes zero
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }

                left++; // move left pointer
            }

            // All subarrays ending at 'right' and starting from any index in [left, right]
            // are valid because they contain at most k distinct elements
            result += right - left + 1;
        }

        return result;
    }
}
