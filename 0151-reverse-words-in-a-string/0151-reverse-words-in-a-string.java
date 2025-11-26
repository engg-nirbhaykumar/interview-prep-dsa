class Solution {

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();   // Stack to store words in order
        StringBuilder word = new StringBuilder(); // Temporary builder to form each word

        // Step 1: Traverse the string to extract words
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // When we hit a space, push the current word (if any) into the stack
            if (ch == ' ') {
                if (word.length() > 0) {       // To ignore multiple spaces
                    stack.push(word.toString());
                    word = new StringBuilder(); // Reset for next word
                }
            } else {
                word.append(ch); // Keep building the current word
            }
        }

        // After loop, push the last word (if any)
        if (word.length() > 0) {
            stack.push(word.toString());
            word = new StringBuilder();
        }

        // Step 2: Pop words from stack to reverse their order
        String result = "";
        while (!stack.isEmpty()) {
            String w = stack.pop();    // Get top word (last inserted)
            result += w;               // Append to result
            if (!stack.isEmpty()) {    // Add space between words
                result += " ";
            }
        }

        // Step 3: Return reversed sentence
        return result;
    }
}
