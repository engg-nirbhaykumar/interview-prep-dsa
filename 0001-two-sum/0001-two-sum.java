class Solution {

    public int[] twoSum(int[] nums, int target) {

        // HashMap to store (value -> index)
        // This allows O(1) lookup for complement
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // The number we need to find
            int complement = target - nums[i];

            // If complement already exists in the map,
            // we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current value with its index
            // so future elements can find it as complement
            map.put(nums[i], i);
        }

        // In case no valid pair is found (as per guarantee this won't happen)
        return new int[] {};
    }
}
