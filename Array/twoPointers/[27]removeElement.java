class Solution {
    public int removeElement(int[] nums, int val) {
      int l = 0;
      int r = nums.length - 1;
      while (l <= r) {
        if (nums[l] == val) {
          nums[l] = nums[r--];
        } else {
          l++;
        }
      }
      return l;
    }
}

/**
 * performance: 0 ms < 100%, 38 MB < 5%
 * notes: alternate solution by faster-slower runner
 */
