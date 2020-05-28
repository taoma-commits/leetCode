/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
Memory Usage: 38.6 MB, less than 98.52% of Java online submissions for Single Number.
@XOR 
*/


class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) a ^= nums[i];
        return a;
    }
}
