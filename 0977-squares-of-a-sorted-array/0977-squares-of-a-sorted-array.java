class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        // Two pointers:
        // i -> start of the array
        // j -> end of the array
        int i = 0;
        int j = n - 1;

        // Fill the result array from the end because
        // the largest square will always come from either end
        int k = n - 1;

        int[] result = new int[n];

        // Process until all positions in result are filled
        while (k >= 0) {

            // Calculate squares of the current left and right elements
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];

            // Place the larger square at the current position
            if (a > b) {
                result[k] = a;

                // Move the left pointer inward
                i++;
            } else {
                result[k] = b;

                // Move the right pointer inward
                j--;
            }

            // Move to the next position from the end
            k--;
        }

        return result;
    }
}