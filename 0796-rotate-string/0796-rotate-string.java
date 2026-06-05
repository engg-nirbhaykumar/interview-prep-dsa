class Solution {

    public boolean rotateString(String s, String goal) {
        // Step 1: If lengths are not equal, rotation is not possible
        if (s.length() != goal.length()) return false;

        // Step 2: Concatenate string with itself
        // Example: "abcde" + "abcde" → "abcdeabcde"
        // Any valid rotation of "s" must be a substring of this doubled string
        String ds = s + s;

        // Step 3: Check if goal exists as a substring in ds
        return ds.contains(goal);
    }
}
