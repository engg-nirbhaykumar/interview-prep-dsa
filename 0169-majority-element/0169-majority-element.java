class Solution {
    public int majorityElement(int[] nums) {

        // count → tracks the balance of the current candidate
        // candidate → potential majority element
        int count = 0;
        int candidate = 0;

        // Traverse through the array
        for (int num : nums) {

            // If count is zero, pick the current number as a new candidate
            if (count == 0) {
                candidate = num;
            }

            // If current number matches the candidate, increment count
            // Otherwise, decrement count (cancel out one occurrence)
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // The remaining candidate is the majority element
        // (guaranteed to exist as per problem statement)
        return candidate;
    }
}
