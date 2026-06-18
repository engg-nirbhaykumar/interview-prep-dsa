class Solution {
    public int compress(char[] chars) {

        // Total number of characters in the input array
        int n = chars.length;

        // Pointer to traverse the original array
        int i = 0;

        // Pointer to write compressed characters back into the same array
        int index = 0;

        // Process each group of consecutive identical characters
        while (i < n) {

            // Current character being compressed
            char currCh = chars[i];

            // Count occurrences of the current character
            int count = 0;

            // Move 'i' forward while the same character repeats
            while (i < n && chars[i] == currCh) {
                i++;
                count++;
            }

            // Write the character once to the compressed array
            chars[index++] = currCh;

            // If the character appears more than once,
            // write its count as separate digits
            // Example: count = 12 -> write '1', '2'
            if (count > 1) {

                // Convert count to a string, then iterate over each digit
                for (char ch : Integer.toString(count).toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        // 'index' represents the length of the compressed array
        return index;
    }
}