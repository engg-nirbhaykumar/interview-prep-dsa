class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-based indices as per the problem
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++; // Need bigger sum
            } else {
                right--; // Need smaller sum
            }
        }

        return new int[] { -1, -1 }; // In case no answer found (guaranteed to have one)
    }
}
