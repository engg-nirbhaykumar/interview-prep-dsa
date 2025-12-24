class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long) n * n;

        long gridSum = 0;
        long gridSqSum = 0;

        // Calculate actual sum and square sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridSum += grid[i][j];
                gridSqSum += (long) grid[i][j] * grid[i][j];
            }
        }

        // Expected sum and square sum
        long expectedSum = N * (N + 1) / 2;
        long expectedSqSum = N * (N + 1) * (2 * N + 1) / 6;

        long sumDiff = gridSum - expectedSum; // x - y
        long sqDiff = gridSqSum - expectedSqSum; // x^2 - y^2

        long sumXY = sqDiff / sumDiff; // x + y

        int repeated = (int) ((sumDiff + sumXY) / 2);
        int missing = (int) (repeated - sumDiff);

        return new int[] { repeated, missing };
    }
}
