/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
Memory Usage: 34 MB, less than 100.00% of Java online submissions for House Robber.
@dynamicProgramming
*/

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int sum, former;
        former = sum = 0;
        int latter = nums[0];
        for (int i = 1; i < len; i++) {
            sum = former + nums[i];
            former = latter;
            latter = Math.max(sum, latter);
        }
        return latter;
    }
}
