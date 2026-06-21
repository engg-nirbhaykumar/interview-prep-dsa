class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxStreak = 0; // stores longest streak of 1s found so far
        int currentStreak = 0; // counts the current streak of 1s

        for (int num : nums) {
            if (num == 1) {
                currentStreak++; // extend current streak
                maxStreak = Math.max(maxStreak, currentStreak);
            } else {
                currentStreak = 0; // reset streak on a 0
            }
        }

        return maxStreak;
    }
}
