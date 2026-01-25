class Solution {
    // Stores all unique valid combinations
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        // Sort the array so that duplicates are adjacent
        // This helps in skipping duplicate combinations
        Arrays.sort(candidates);

        // Start backtracking from index 0 with empty combination
        backTrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backTrack(int[] candidates, int target, int index, List<Integer> temp) {

        // Base case: target achieved
        // Current combination is valid and added to result
        if (target == 0) {
            result.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        // Base case: no elements left or target exceeded
        if (index == candidates.length || target < 0)
            return;

        // -------------------------
        // Case 1: PICK the element
        // -------------------------
        // Choose the current element
        temp.add(candidates[index]);

        // Move to the next index because each number can be used only once
        backTrack(candidates, target - candidates[index], index + 1, temp);

        // Backtrack: remove last chosen element
        temp.remove(temp.size() - 1);

        // -----------------------------
        // Case 2: NOT PICK the element
        // -----------------------------
        // Skip all duplicate values to avoid duplicate combinations
        int nextIndex = index + 1;
        while (nextIndex < candidates.length &&
               candidates[nextIndex] == candidates[index]) {
            nextIndex++;
        }

        // Move to the first non-duplicate index
        backTrack(candidates, target, nextIndex, temp);
    }
}
