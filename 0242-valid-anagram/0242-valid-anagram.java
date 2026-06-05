class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase letters (a–z)
        int[] count = new int[26];

        // Traverse both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
        
            // Increment count for character in s
            count[s.charAt(i) - 'a']++;

            // Decrement count for character in t
            count[t.charAt(i) - 'a']--;
        }

        // After processing, all counts should be zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                // If any count is non-zero, characters mismatch → not an anagram
                return false;
            }
        }

        // All counts balanced → strings are anagrams
        return true;
    }
}
