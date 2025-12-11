class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Result array will store numbers in alternating order: +, -, +, -, ...
        int[] result = new int[n];

        // pi = index for placing positive numbers → starts at 0 (even positions)
        int pi = 0;

        // ni = index for placing negative numbers → starts at 1 (odd positions)
        int ni = 1;

        // Traverse the original array
        for (int num : nums) {

            // If number is positive → place at next available even index
            if (num > 0) {
                result[pi] = num;
                pi += 2; // move to next even index
            } else {

                // If number is negative → place at next available odd index
                result[ni] = num;
                ni += 2; // move to next odd index
            }
        }

        // Return the rearranged array with alternating signs
        return result;
    }
}
