class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalSubarrays = 0;
        long currentStreak = 0;

        for (int num : nums) {
            if (num == 0) {
                currentStreak++;
                totalSubarrays += currentStreak;
            } else {
                currentStreak = 0;
            }
        }

        return totalSubarrays;
    }
}
