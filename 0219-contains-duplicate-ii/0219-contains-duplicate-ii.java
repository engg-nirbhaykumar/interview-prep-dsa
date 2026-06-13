class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashSet to store the last 'k' elements (sliding window)
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If current number already exists in the set → duplicate within range
            if (seen.contains(nums[i])) {
                return true;
            }

            // Add current number to the sliding window
            seen.add(nums[i]);

            // Maintain window size of at most 'k'
            // Remove element that is out of the k-distance range
            if (seen.size() > k) {
                seen.remove(nums[i - k]);
            }
        }

        // No duplicates found within distance k
        return false;
    }
}
