class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate width and minimum height between two pointers
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = minHeight * width;

            // Update maxArea if current area is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                // Equal heights — move both pointers inward
                left++;
                right--;
            }
        }

        return maxArea;
    }
}