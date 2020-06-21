class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int lo = 0, hi = nums.length - 1;
    while(lo < hi) {
      int mid = (lo + hi) >> 1;
      if (target == nums[mid]) return mid;
      if (nums[lo] < nums[hi]) {
        if (nums[mid] < target) {
          lo = mid + 1;
        } else {
          hi = mid;
        }
      } else {
        if ((target > nums[mid] && (nums[lo] > target || nums[lo] <= nums[mid])) || (target < nums[lo] && nums[lo] <= nums[mid])) {
          lo = mid + 1;
        } else {
          hi = mid;
        }
      }
    }
    if (nums[lo] == target) return lo;
    return -1;
  }
}


/**
 * performance: 0 ms < 100%
 * time complexity: O(log(n))
 * space complexity: O(1)
 */
