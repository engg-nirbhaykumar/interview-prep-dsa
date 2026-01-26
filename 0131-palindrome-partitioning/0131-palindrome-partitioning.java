class Solution {

    // Stores all valid palindrome partition lists
    private List<List<String>> result;

    // Helper function to check if substring s[start...end] is a palindrome
    private boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            // If characters mismatch → not a palindrome
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function to generate partitions
    private void backTrack(String s, int index, List<String> temp) {

        // Base case:
        // If we have used all characters, we found one valid partition
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try all possible substring cuts starting from current index
        for (int i = index; i < s.length(); i++) {

            // Check if substring s[index...i] is palindrome
            if (isPalindrome(index, i, s)) {

                // Choose: take this palindrome substring
                String substr = s.substring(index, i + 1);
                temp.add(substr);

                // Explore: solve for remaining substring
                backTrack(s, i + 1, temp);

                // Un-choose (Backtrack): remove last added substring
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        // Start partitioning from index 0
        backTrack(s, 0, new ArrayList<>());

        return result;
    }
}
