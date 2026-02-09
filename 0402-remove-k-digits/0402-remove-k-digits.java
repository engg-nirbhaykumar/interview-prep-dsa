class Solution {
    public String removeKdigits(String num, int k) {

        // Stack to build the smallest possible number
        // It will be MONOTONIC INCREASING (digits from small → large)
        Stack<Character> st = new Stack<>();

        // Traverse each digit in the number
        for (char digit : num.toCharArray()) {

            // If the last digit in stack is greater than current digit,
            // removing it makes the number smaller (leftmost impact)
            // Keep removing while we still can remove digits (k > 0)
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop(); // Remove the bigger digit
                k--; // One removal used
            }

            // Add current digit to the stack
            st.push(digit);
        }

        // If we still have removals left, remove from the end
        // (these will be the largest remaining digits)
        while (!st.isEmpty() && k-- > 0) {
            st.pop();
        }

        // Build result string from stack
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }

        // Remove leading zeros (e.g., "0200" → "200")
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If all digits removed or only zeros remain, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
