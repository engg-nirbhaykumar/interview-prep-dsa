class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort array for two-pointer technique

        List<List<Integer>> result = new ArrayList<>();

        // Fix first element one by one
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate values for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;

            // Two-pointer search for remaining two numbers
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers
                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++; // Need a bigger sum
                }
                else {
                    right--; // Need a smaller sum
                }
            }
        }

        return result;
    }
}
