class Solution {
    public int maxDepth(String s) {

        // Tracks the current number of open parentheses
        int openingBracket = 0;

        // Stores the maximum depth encountered
        int result = 0;

        // Iterate through every character in the string
        for (char ch : s.toCharArray()) {

            // If we see an opening bracket, increase depth
            if (ch == '(') {
                openingBracket++;
            }
            // If we see a closing bracket, decrease depth
            else if (ch == ')') {
                openingBracket--;
            }

            // Update the maximum depth reached so far
            result = Math.max(result, openingBracket);
        }

        // Final maximum nesting depth
        return result;
    }
}
// approach 1

// class Solution {
//     public int maxDepth(String s) {

//         // Stack to track the current nesting of parentheses
//         Stack<Character> st = new Stack<>();

//         // Variable to store the maximum depth encountered
//         int result = 0;

//         // Traverse each character in the string
//         for (char ch : s.toCharArray()) {

//             // If it's an opening bracket, push to stack (depth increases)
//             if (ch == '(') {
//                 st.push(ch);
//             }
//             // If it's a closing bracket, pop from stack (depth decreases)
//             else if (ch == ')') {
//                 st.pop();
//             }

//             // After each operation, update the maximum depth so far
//             result = Math.max(result, st.size());
//         }

//         // Return the maximum nesting depth
//         return result;
//     }
// }