class Solution {

    // Stores all possible subsets
    List<List<Integer>> result;

    // Backtracking function to generate subsets
    // index -> current position in nums array
    // temp  -> current subset being built
    private void backTrack(int[] nums, int index, List<Integer> temp) {

        // Base case: if all elements are processed
        if (index == nums.length) {
            // Add a copy of current subset to result
            result.add(new ArrayList<>(temp));
            return;
        }

        // Choice 1: include the current element
        temp.add(nums[index]);
        backTrack(nums, index + 1, temp);

        // Backtrack: remove last added element
        temp.remove(temp.size() - 1);

        // Choice 2: exclude the current element
        backTrack(nums, index + 1, temp);
    }

    // Returns all subsets (power set) of the given array
    public List<List<Integer>> subsets(int[] nums) {

        // Initialize result list
        result = new ArrayList<>();

        // Start backtracking from index 0 with an empty subset
        backTrack(nums, 0, new ArrayList<>());

        return result;
    }
}
