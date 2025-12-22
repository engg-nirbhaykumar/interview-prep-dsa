class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // If there are fewer than 4 elements, no quadruplet is possible
        if (n < 4)
            return result;

        // Step 1: Sort the array to apply two-pointer technique
        Arrays.sort(nums);

        // Step 2: Fix the first element of the quadruplet
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Step 3: Fix the second element of the quadruplet
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate values for the second element
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // Two pointers for the remaining two elements
                int k = j + 1;
                int l = n - 1;

                // Step 4: Two-pointer search for remaining sum
                while (k < l) {

                    // Calculate sum of current quadruplet
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    // Case 1: Found a valid quadruplet
                    if (sum == target) {
                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        ));

                        // Skip duplicate values for third element
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }

                        // Skip duplicate values for fourth element
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }

                        // Move both pointers after processing current valid set
                        k++;
                        l--;
                    }

                    // Case 2: Sum is smaller than target → increase sum
                    else if (sum < target) {
                        k++;
                    }

                    // Case 3: Sum is greater than target → decrease sum
                    else {
                        l--;
                    }
                }
            }
        }

        // Return all unique quadruplets
        return result;
    }
}
