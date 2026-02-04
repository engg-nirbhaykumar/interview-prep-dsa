class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        // Each child must get at least 1 candy
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Pass 1: Left → Right
        // If current child has higher rating than left neighbor,
        // give more candies than left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Pass 2: Right → Left
        // If current child has higher rating than right neighbor,
        // ensure it has more candies than right neighbor
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Take max to preserve previous left-pass condition
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum all candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }
}
