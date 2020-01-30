/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 38 MB, less than 47.17% of Java online submissions for Search in Rotated Sorted Array.
*/

//tag: array, binary search
//note: avoid recursion! Recursion is way too slow! Use loop and/or stack instead!

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        // require low + 1 < high to avoid tricky special case when low + 1 = high
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] > nums[low]) {
                if (target >= nums[low] && target < nums[mid]) high = mid;
                else low = mid;
            }
            else {
                if (target <= nums[high] && target > nums[mid]) low = mid;
                else high = mid;
            }
        }
        if (nums[low] == target) return low;
        if (nums[high] == target) return high;
        return -1;
    }
}
