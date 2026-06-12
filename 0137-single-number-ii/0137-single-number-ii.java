class Solution {

    public int singleNumber(int[] nums) {
        int result = 0; // This will hold the unique number

        // We know integers have 32 bits
        for (int k = 0; k < 32; k++) {
            int temp = (1 << k); // Mask for the k-th bit
            int countOne = 0; // Count how many numbers have this bit set
            int countZero = 0; // (Optional) Count how many numbers have this bit unset

            // Count set/unset bits at position k across all numbers
            for (int num : nums) {
                if ((num & temp) == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }

            // If bit count is not divisible by 3, that means
            // the unique number has this bit set.
            // (since all others appear 3 times and cancel out)
            if (countOne % 3 == 1) {
                result |= temp; // Set this bit in result
            }
        }

        return result; // Final unique number
    }
}
