class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // currMax → maximum product ending at current index
        // currMin → minimum product ending at current index
        // (needed because negative numbers can flip sign)
        int currMin = nums[0];
        int currMax = nums[0];

        // Stores the global maximum product found so far
        int maxProduct = nums[0];

        // Traverse the array starting from index 1
        for (int i = 1; i < n; i++) {

            // Store previous currMax before updating
            // because currMax is needed to calculate currMin
            int prevMax = currMax;

            // Update currMax:
            // 1) start new subarray with nums[i]
            // 2) extend previous max product
            // 3) extend previous min product (in case nums[i] is negative)
            currMax = Math.max(
                    nums[i],
                    Math.max(nums[i] * currMax, nums[i] * currMin)
            );

            // Update currMin:
            // Similar logic but taking minimum
            currMin = Math.min(
                    nums[i],
                    Math.min(nums[i] * prevMax, nums[i] * currMin)
            );

            // Update global maximum product
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
