class Solution {

    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder(); // To store the final result
        int count = 0; // Keeps track of the balance of parentheses
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            
            // If we encounter a closing parenthesis, decrease count first
            // (because we might be closing the outermost one)
            if (ch == ')') {
                count--;
            }

            // Only append the character if we are *not* at the outermost level
            // i.e., count != 0 means we are inside an inner primitive
            if (count != 0) {
                ans.append(ch);
            }

            // If we encounter an opening parenthesis, increase count after appending
            // (because the current '(' might be the start of a new primitive)
            if (ch == '(') {
                count++;
            }
        }

        // Return the processed string with outer parentheses removed
        return ans.toString();
    }
}