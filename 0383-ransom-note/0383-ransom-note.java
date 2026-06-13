class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Store character frequencies of magazine
        int[] count = new int[26];

        // Count each character in magazine
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        // Check if ransomNote can be formed
        for (char ch : ransomNote.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                return false; // character not available
            }
            count[ch - 'a']--;
        }

        return true;
    }
}