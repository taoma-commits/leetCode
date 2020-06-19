class Solution {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = (lo + hi) >> 1;
      if (target == nums[mid]) return true;
      // key modification 
      if (nums[lo] == nums[mid]) {
        lo++;
        continue;
      }
      if (nums[lo] < nums[mid]) {
        if (target < nums[mid] && target >= nums[lo]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else {
        if (target > nums[mid] && target < nums[lo]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }
    if (nums[lo] == target) return true;
    return false;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: worst case O(n)
 * space complexity: O(1)
 * notes: well-organized; key modification.
 */


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
