class Solution {
    public int maxSubArray(int[] nums) {

        // maxSum stores the best (maximum) subarray sum found so far
        int maxSum = Integer.MIN_VALUE;

        // currSum stores the sum of the current subarray we are building
        int currSum = 0;

        // Traverse through each element in the array
        for (int num : nums) {

            // Extend the current subarray by adding current element
            currSum += num;

            // Update global maximum if current sum becomes the best so far
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            // If current sum becomes negative, reset it
            // Because a negative sum will reduce future subarray sums
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // maxSum contains the maximum subarray sum
        return maxSum;
    }
}
