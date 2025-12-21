class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Result list to store elements appearing more than n/3 times
        List<Integer> result = new ArrayList<>();

        // Step 1: Find potential majority candidates using Boyer–Moore Voting
        int candidate1 = 0, candidate2 = 0;  // Possible majority elements
        int count1 = 0, count2 = 0;          // Counters for candidates

        for (int num : nums) {

            // If current number matches first candidate, increase its count
            if (candidate1 == num) {
                count1++;
            }

            // If current number matches second candidate, increase its count
            else if (candidate2 == num) {
                count2++;
            }

            // If first candidate slot is empty, assign current number
            else if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            }

            // If second candidate slot is empty, assign current number
            else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            }

            // Current number matches neither candidate → cancel both counts
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify actual frequency of candidates
        // (Because Boyer–Moore only gives potential candidates)
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        // Threshold for majority (> n/3)
        int threshold = nums.length / 3;

        // Add candidates to result only if they exceed threshold
        if (count1 > threshold)
            result.add(candidate1);
        if (count2 > threshold)
            result.add(candidate2);

        return result;
    }
}
