class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // create mapping for order of characters
        Map<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < order.length(); k++) {
            map.put(order.charAt(k), k);
        }

        // compare every consecutive pair
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int n = Math.min(word1.length(), word2.length());
            boolean samePrefix = true;

            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                // if characters differ, check their order
                if (map.get(c1) < map.get(c2)) {
                    samePrefix = false; // order is correct
                    break;
                } else if (map.get(c1) > map.get(c2)) {
                    return false; // wrong order
                }
            }

            // if all characters same but word1 is longer → not sorted
            if (samePrefix && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}
