class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    if (target <= 0 && nums[0] >= 0) {
        return nums[0] + nums[1] + nums[2];
    }
    if (target >= 0 && nums[len - 1] <= 0) {
        return nums[len - 1] + nums[len - 2] + nums[len -3];
    }
    int res = 0;
    int d = Integer.MAX_VALUE;
    for (int i = 2; i < len; i++) {
      if (i < len - 1 && nums[i] == nums[i + 1]) {
        continue;
      }
      int T = target - nums[i];
      int l = 0, r = i - 1;
      int L = 0, R = 0;
      while (l < r) {
        L = nums[l];
        R = nums[r];
        if (L + R == T) return target;
        if (L + R > T) r--;
        if (L + R < T) l++;
        if (Math.abs(T - L - R) < d) {
          d = Math.abs(T - L - R);
          res = L + R + nums[i];
        }
      }
    }
    return res;
  }
}

/**
 * performance: 5 ms < 96%, 39 MB < 7%
 * time complexity: O(n^2)
 * space complexity: O(1)
 */
