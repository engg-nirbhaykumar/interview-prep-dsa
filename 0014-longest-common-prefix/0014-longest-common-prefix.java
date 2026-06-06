class Solution {

    public String longestCommonPrefix(String[] strs) {
        // Step 1: Edge case — if array is null or empty, no common prefix
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Step 2: Iterate through each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            // Compare this character with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {
                // Case 1: Current string is shorter than i (no more chars to compare)
                // Case 2: Mismatch found at current index
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    // Return the prefix found so far (0 to i-1)
                    return strs[0].substring(0, i);
                }
            }
        }

        // Step 3: If loop completes, entire first string is common prefix
        return strs[0];
    }
}
