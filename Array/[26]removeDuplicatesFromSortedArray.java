/*
Runtime: 1 ms, faster than 97.92% of Java online submissions for Remove Duplicates from Sorted Array.
Memory Usage: 39 MB, less than 99.47% of Java online submissions for Remove Duplicates from Sorted Array.
@dataStructure: array
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int p = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[p]) nums[++p] = nums[i];
        }
        return p + 1;
    }
}
