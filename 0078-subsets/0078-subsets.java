class Solution {

    // To store all possible subsets
    private List<List<Integer>> result;

    // Main function to generate all subsets
    public List<List<Integer>> subsets(int[] nums) {

        // Initialize result list
        result = new ArrayList<>();

        // Start backtracking from index 0 with empty subset
        backTrack(nums, 0, new ArrayList<>());

        return result;
    }

    // Backtracking helper function
    private void backTrack(int[] nums, int index, List<Integer> temp) {

        // Base case:
        // If we have considered all elements,
        // add the current subset to result
        if (index == nums.length) {
            result.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        // -------- Choice 1: Include current element --------
        temp.add(nums[index]);
        backTrack(nums, index + 1, temp);

        // -------- Backtrack (undo last choice) --------
        temp.remove(temp.size() - 1);

        // -------- Choice 2: Exclude current element --------
        backTrack(nums, index + 1, temp);
    }
}
