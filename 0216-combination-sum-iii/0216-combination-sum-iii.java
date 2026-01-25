class Solution {
    // Stores all valid combinations
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        // Start recursion from number 1
        backTrack(k, n, 1, new ArrayList<>());
        return result;
    }

    private void backTrack(int k, int target, int num, List<Integer> temp) {

        // Base case:
        // If we have picked exactly k numbers and their sum equals target,
        // we found a valid combination
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Invalid cases:
        // - picked more than k numbers
        // - sum exceeded target
        // - numbers can only be from 1 to 9
        if (k < 0 || target < 0 || num > 9)
            return;

        // ---------------- PICK current number ----------------
        // Choose the current number
        temp.add(num);

        // Move to next number (num + 1),
        // reduce k (one number used) and target (sum reduced)
        backTrack(k - 1, target - num, num + 1, temp);

        // Backtrack: remove last chosen number
        temp.remove(temp.size() - 1);

        // ---------------- NOT PICK current number ----------------
        // Skip the current number and move to next
        backTrack(k, target, num + 1, temp);
    }
}
