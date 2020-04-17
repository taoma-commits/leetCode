class Solution {
  public int removeDuplicates(int[] nums) {
    int s = 0;
    int f = 0;
    while (f < nums.length) {
      if (nums[f] != nums[s]) {
        nums[++s] = nums[f];
      } else {
        f++;
      }
    }
    return s + 1;
  }
}

/**
 * performance: 1 ms < 99%, 41 MB < 5%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: it works b/c array is sorted.
 */
