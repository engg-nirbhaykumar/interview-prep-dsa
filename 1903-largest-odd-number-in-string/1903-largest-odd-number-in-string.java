class Solution {

    public String largestOddNumber(String num) {
        int n = num.length(); // Get length of the input string
        
        // Step 1: Quick check — if the last digit is already odd,
        // the entire number is the largest odd number
        if ((num.charAt(n - 1) - '0') % 2 == 1) {
            return num;
        }

        // Step 2: Traverse backward to find the rightmost odd digit
        for (int i = n - 2; i >= 0; i--) {
            char ch = num.charAt(i);

            // Check if current digit is odd
            if ((ch - '0') % 2 == 1) {
                // The substring from 0 to i (inclusive) forms the largest odd number
                return num.substring(0, i + 1);
            }
        }

        // Step 3: If no odd digit found, return an empty string
        return "";
    }
}
