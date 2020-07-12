class Solution {
  public int searchInsert(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length;
    while (lo < hi) {
      int mid = (lo + hi) >> 1;
      if (nums[mid] == target) return mid;
      // if nums[mid] < target, then return is at least mid + 1;
      if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return hi;
  }
}

/**
 * performance: 0 ms
 * time complexity: O(log(n))
 * space complexity: O(1)
 */


class Solution {
  public int searchInsert(int[] nums, int target) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] >= target) return i;
      i++;
    }
    return i;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */
