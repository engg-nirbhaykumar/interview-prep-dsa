class Solution {

    public String countAndSay(int n) {

        // Base case: the first term of the sequence is always "1"
        if (n == 1)
            return "1";

        // Recursively get the (n-1)th term of the sequence
        String previous = countAndSay(n - 1);

        // StringBuilder to build the nth term efficiently
        StringBuilder result = new StringBuilder();

        // Traverse the previous string and count consecutive repeating digits
        for (int i = 0; i < previous.length(); i++) {

            char ch = previous.charAt(i); // current character
            int count = 1;                // minimum count is 1

            // Count how many times this character repeats consecutively
            while (i < previous.length() - 1 && previous.charAt(i) == previous.charAt(i + 1)) {
                count++;
                i++;
            }

            // Append the count and digit to the result (e.g., "21" means "two 1s")
            result.append(count).append(ch);
        }

        // Return the generated nth term
        return result.toString();
    }
}
