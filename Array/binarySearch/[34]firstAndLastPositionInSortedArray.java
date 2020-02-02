/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 42.9 MB, less than 99.29% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/

/* Notes:
* two-time binary search
* corner cases
** set low = mid + 1 to escape deadlock in binary search
** set high = nums.length instead of nums.length - 1
              so that binary(nums, target, false) always return the index of
              the last duplicate plus one even the index = length of array
* one array for range
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return range;
        int i = binary(nums, target, true);
        int j = binary(nums, target, false);
        if (i < nums.length && nums[i] == target) {
            range[0] = i;
            range[1] = j - 1;
        }
        return range;
    }

    private int binary(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target < nums[mid] || (target == nums[mid] && left)) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}




/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 42.8 MB, less than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return range;
        double left = target - 0.5, right = target + 0.5;
        int i = binary(nums, left);
        int j = binary(nums, right);
        if (i < nums.length && nums[i] == target) {
            range[0] = i;
            range[1] = j - 1;
        }
        return range;
    }

    private int binary(int[] nums, double target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target < nums[mid]) high = mid;
            if (target > nums[mid]) low = mid + 1;
        }
        return high;
    }
}
