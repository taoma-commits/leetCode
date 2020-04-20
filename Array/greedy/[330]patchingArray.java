class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long missing = 1;
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
 * performance: 0 ms < 100%, 39 MB < 50%.
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: greedy; overflow!
 */
