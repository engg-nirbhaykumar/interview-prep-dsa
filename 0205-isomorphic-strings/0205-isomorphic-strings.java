class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // Check s → t mapping
            if (mapST.containsKey(chS)) {
                if (mapST.get(chS) != chT) return false;
            } else {
                mapST.put(chS, chT);
            }

            // Check t → s mapping (to prevent two characters in s mapping to same t)
            if (mapTS.containsKey(chT)) {
                if (mapTS.get(chT) != chS) return false;
            } else {
                mapTS.put(chT, chS);
            }
        }

        return true;
    }
}