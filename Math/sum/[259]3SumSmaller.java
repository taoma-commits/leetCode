class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    int n = nums.length;
    if (n < 3) return 0;
    Arrays.sort(nums);
    if (nums[0] >= Math.max(target, 0) || nums[n - 1] <= Math.min(target, 0)) return 0;
    int count = 0;
    for (int i = 2; i < n; i++) {
      int T = target - nums[i];
      int l = 0, r = i - 1;
      while (l < r) {
        while (l < r && nums[l] + nums[r] >= T) {
          r--;
        }
        if (l < r) {
          count += r - l;
          l++;
        }
      }
    }
    return count;
  }
}

/**
 * performance: 3 ms < 100%, 39 MB < 17%
 * time complexity: O(n^2)
 * space complexity: O(1)
 */
