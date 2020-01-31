/*
Runtime: 1 ms, faster than 49.34% of Java online submissions for Rotate Array.
Memory Usage: 46.7 MB, less than 5.77% of Java online submissions for Rotate Array.
*/

// this solution: rotate array by three reverses

/* alternate solution 1: in-place, for each array element compute its position after rotation
* and before replacing the old element by the current one, keep the old element in a single int
* variable. Iterate over orbits.
*/

// alternate solution 2: not in-place. Simply create an empty new array to return.


class Solution {
    private void reverse(int[] nums, int front, int end) {
        int temp = 0;
        while (front < end) {
            temp = nums[front];
            nums[front++] = nums[end];
            nums[end--] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len; // avoid k - 1 out of bounds as index
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
}
