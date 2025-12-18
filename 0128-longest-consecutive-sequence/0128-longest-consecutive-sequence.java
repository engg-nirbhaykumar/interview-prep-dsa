class Solution {
    public int longestConsecutive(int[] nums) {

        // HashSet to store all unique numbers for O(1) lookup
        HashSet<Integer> seen = new HashSet<>();

        // Add all numbers to the set
        for (int num : nums) {
            seen.add(num);
        }

        int longestStreak = 0;

        // Iterate through each unique number
        for (int num : seen) {

            // Check if this number is the start of a sequence
            // A number is a start only if (num - 1) does NOT exist
            if (!seen.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers starting from currentNum
                while (seen.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the maximum streak length found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        // Return the length of the longest consecutive sequence
        return longestStreak;
    }
}
