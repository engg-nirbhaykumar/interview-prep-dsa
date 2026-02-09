class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int left = 0;              // left pointer
        int right = n - 1;         // right pointer

        int leftMax = 0;           // max height seen from left
        int rightMax = 0;          // max height seen from right

        int totalWater = 0;

        while (left < right) {

            // If left boundary is smaller, process left side
            if (height[left] < height[right]) {

                // If current bar is taller than leftMax, update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water trapped = leftMax - current height
                    totalWater += (leftMax - height[left]);
                }

                left++;  // move left pointer inward
            }
            // Else process right side
            else {

                // If current bar is taller than rightMax, update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water trapped = rightMax - current height
                    totalWater += (rightMax - height[right]);
                }

                right--; // move right pointer inward
            }
        }

        return totalWater;
    }
}
