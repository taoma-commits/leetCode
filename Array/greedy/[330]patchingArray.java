class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long missing = 1; // note 2
        int i = 0;
        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i];
                i++;
            } else {
                count++;
                missing += missing;
            }
        }
        return count;
    }
}

/**
* performance: 1ms < 40%, 48 MB <6%.
* tag: greedy
* notes: 1. 
        2. use long type for missing to avoid overflow
*/
