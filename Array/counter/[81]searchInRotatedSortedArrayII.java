class Solution {
  int T;
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return false;
    T = target;
    int lo = 0;
    int hi = nums.length - 1;
    if (nums[lo] == target || nums[hi] == target) return true;
    return search(nums, lo, hi);
  }

  private boolean search(int[] nums, int lo, int hi) {
    if (lo == hi) return nums[lo] == T;
    boolean res = false;
    int mid = (lo + hi) >> 1;
    if (nums[mid] == T) return true;
    if ((T <= nums[lo] && (nums[lo] <= nums[mid] || nums[mid] < T)) || (T > nums[mid] && nums[lo] <= nums[mid])) {
      res = search(nums, mid + 1, hi);
    }
    if ((T >= nums[lo] && (T < nums[mid] || nums[lo] >= nums[mid])) || (T < nums[mid] && nums[lo] >= nums[mid])) {
      res = res || search(nums, lo, mid);
    }
    return res;
  }
}

/**
 * performance: 1 ms < 67%
 * time complexity: worst case O(n): (0, 0, 0, 1, 0, 0)
 * space complexity: O(log n)
 */
