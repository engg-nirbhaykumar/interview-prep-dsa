class Solution {

    // Checks whether the list is sorted in non-decreasing order
    private boolean isSorted(List<Integer> list) {

        // Compare every adjacent pair
        for (int i = 0; i < list.size() - 1; i++) {

            // If current element is greater than next, list is not sorted
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        // All elements are in sorted order
        return true;
    }

    // Finds the index of the adjacent pair with minimum sum
    private int minSum(List<Integer> list) {

        int index = -1;                 // Stores index of the minimum sum pair
        int minSum = Integer.MAX_VALUE; // Tracks the smallest sum found so far

        // Traverse all adjacent pairs
        for (int i = 0; i < list.size() - 1; i++) {

            int sum = list.get(i) + list.get(i + 1);

            // Update minimum sum and index if smaller sum is found
            if (sum < minSum) {
                index = i;
                minSum = sum;
            }
        }

        // Return index of the first element of the minimum-sum pair
        return index;
    }

    // Performs minimum pair removals until the array becomes sorted
    public int minimumPairRemoval(int[] nums) {

        // Convert array to list for easy removal and update operations
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int ops = 0; // Counts number of operations performed

        // Continue until the list becomes sorted
        while (!isSorted(list)) {

            // Find the adjacent pair with minimum sum
            int index = minSum(list);

            // Merge the pair into a single element
            int merged = list.get(index) + list.get(index + 1);

            // Replace the first element with merged value
            list.set(index, merged);

            // Remove the second element of the pair
            list.remove(index + 1);

            // Increment operation count
            ops++;
        }

        // Return total operations required
        return ops;
    }
}
