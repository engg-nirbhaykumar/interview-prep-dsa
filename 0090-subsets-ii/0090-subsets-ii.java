class Solution {
    // Stores all unique subsets
    List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();

        // Sort the array so that duplicates are adjacent
        Arrays.sort(nums);

        // Start backtracking from index 0 with empty subset
        backTrack(nums, 0, new ArrayList<>());

        return result;
    }

    private void backTrack(int[] nums, int index, List<Integer> temp) {

        // Base case: if we've processed all elements,
        // store the current subset
        if (index == nums.length) {
            result.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        // -------------------------
        // Case 1: PICK the element
        // -------------------------
        temp.add(nums[index]);               // include current element
        backTrack(nums, index + 1, temp);    // move to next index
        temp.remove(temp.size() - 1);        // backtrack (undo choice)

        // ----------------------------------
        // Case 2: NOT PICK the element
        // ----------------------------------
        // Skip all duplicate values to avoid duplicate subsets
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }

        // Call recursion on first non-duplicate index
        backTrack(nums, nextIndex, temp);
    }
}
