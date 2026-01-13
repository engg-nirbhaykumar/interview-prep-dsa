class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Map to store the last seen index of each character
        Map<Character, Integer> cMap = new HashMap<>();

        // Left pointer of the sliding window
        int left = 0;

        // Stores the maximum length of substring without repeating characters
        int maxLength = 0;

        // Right pointer expands the sliding window
        for (int right = 0; right < s.length(); right++) {

            // Current character at the right pointer
            char ch = s.charAt(right);

            // If the character is already seen and lies inside the current window
            // move the left pointer to one position right of the last occurrence
            if (cMap.containsKey(ch)) {
                left = Math.max(left, cMap.get(ch) + 1);
            }

            // Update the last seen index of the current character
            cMap.put(ch, right);

            // Update the maximum window size found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the length of the longest substring without repeating characters
        return maxLength;
    }
}
