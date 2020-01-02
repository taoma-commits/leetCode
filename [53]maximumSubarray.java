/*
Runtime: 1 ms, faster than 75.38% of Java online submissions for Maximum Subarray.
Memory Usage: 37.5 MB, less than 99.53% of Java online submissions for Maximum Subarray.
@dataStructure: array
@dynamicProgramming
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int dp, max;
        dp = max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}
