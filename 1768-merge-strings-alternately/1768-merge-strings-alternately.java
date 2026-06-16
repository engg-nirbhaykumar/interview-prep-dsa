class Solution {
    public String mergeAlternately(String word1, String word2) {

        // StringBuilder is used for efficient string concatenation
        StringBuilder sb = new StringBuilder();

        // Pointers for traversing word1 and word2
        int i = 0;
        int j = 0;

        int n = word1.length();
        int m = word2.length();

        // Add characters alternately while both strings have characters left
        while (i < n && j < m) {

            // Append current character from word1
            sb.append(word1.charAt(i));

            // Append current character from word2
            sb.append(word2.charAt(j));

            // Move both pointers forward
            i++;
            j++;
        }

        // If word1 is longer, append its remaining characters
        while (i < n) {
            sb.append(word1.charAt(i));
            i++;
        }

        // If word2 is longer, append its remaining characters
        while (j < m) {
            sb.append(word2.charAt(j));
            j++;
        }

        // Convert StringBuilder to String and return
        return sb.toString();
    }
}