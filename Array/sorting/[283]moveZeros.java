/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
Memory Usage: 47.1 MB, less than 5.59% of Java online submissions for Move Zeroes.
@twoPointers
*/

// optimize in extreme cases where nums are most zeros

class Solution {
    public void moveZeroes(int[] nums) {
        int last, cur;
        cur = last = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                if (cur != last) {
                    nums[last] = nums[cur];
                    nums[cur] = 0;
                }
                last++;
            }
            cur++;
        }
    }
}
