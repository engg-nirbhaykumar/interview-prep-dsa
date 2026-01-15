class Solution {
    public int totalFruit(int[] fruits) {

        // Map to store fruit type -> count in current window
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Left pointer of sliding window
        int i = 0;

        // Stores maximum window size
        int maxLength = 0;

        // Right pointer expands the window
        for (int j = 0; j < fruits.length; j++) {

            // Add current fruit (right pointer) to the map
            countMap.put(fruits[j], countMap.getOrDefault(fruits[j], 0) + 1);

            // If more than 2 fruit types, shrink window from left
            while (countMap.size() > 2) {

                // Decrease count of leftmost fruit
                countMap.put(fruits[i], countMap.get(fruits[i]) - 1);

                // If count becomes zero, remove fruit type
                if (countMap.get(fruits[i]) == 0) {
                    countMap.remove(fruits[i]);
                }

                // Move left pointer forward
                i++;
            }

            // Update maximum window length
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
