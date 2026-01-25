class Solution {
    // Stores all valid combinations
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        // Start backtracking from index 0 with empty combination
        backTrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backTrack(int[] candidates, int target, int index, List<Integer> temp) {

        // Base case: target achieved
        // Current combination is valid, so add it to result
        if (target == 0) {
            result.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        // Base case: no candidates left OR target exceeded
        if (index == candidates.length || target < 0) {
            return;
        }

        // -------------------------
        // Case 1: PICK the element
        // -------------------------
        // Choose the current element
        temp.add(candidates[index]);

        // Stay on the same index because reuse is allowed
        backTrack(candidates, target - candidates[index], index, temp);

        // Backtrack: remove last chosen element
        temp.remove(temp.size() - 1);

        // -----------------------------
        // Case 2: NOT PICK the element
        // -----------------------------
        // Move to the next index
        backTrack(candidates, target, index + 1, temp);
    }
}
