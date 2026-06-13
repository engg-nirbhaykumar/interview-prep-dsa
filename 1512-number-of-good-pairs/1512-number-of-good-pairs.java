class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // constraints: 1 <= nums[i] <= 100

        for (int num : nums) {
            freq[num]++;
        }

        int goodPairs = 0;
        for (int count : freq) {
            if (count > 1) {
                goodPairs += (count * (count - 1)) / 2;
            }
        }

        return goodPairs;
    }
}
