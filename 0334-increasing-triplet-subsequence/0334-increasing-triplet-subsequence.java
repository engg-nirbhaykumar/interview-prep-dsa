class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                // Found new smaller element for 'first'
                first = num;
            } else if (num <= second) {
                // Found better candidate for 'second'
                second = num;
            } else {
                // Found number greater than both → triplet exists
                return true;
            }
        }

        return false; // No triplet found
    }
}