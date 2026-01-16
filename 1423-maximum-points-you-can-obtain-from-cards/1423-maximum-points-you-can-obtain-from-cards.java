class Solution {
    public int maxScore(int[] cardPoints, int k) {

        // Sum of the first k cards taken from the left
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        // Initialize maximum score with all k cards taken from the left
        int maxSum = leftSum;

        // Sum of cards taken from the right
        int rightSum = 0;

        // Pointer to the last index of the array
        int rightIndex = cardPoints.length - 1;

        // Gradually replace cards taken from the left with cards from the right
        for (int j = k - 1; j >= 0; j--) {

            // Remove one card from the left side
            leftSum -= cardPoints[j];

            // Add one card from the right side and move pointer left
            rightSum += cardPoints[rightIndex--];

            // Update the maximum score after this replacement
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        // Return the maximum score obtainable by taking exactly k cards
        return maxSum;
    }
}
