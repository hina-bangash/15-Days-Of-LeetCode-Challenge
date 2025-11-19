class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // overall max
        int currentSum = nums[0]; // max ending at current position

        for (int i = 1; i < nums.length; i++) {
            // either start new subarray at nums[i] or extend current one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
