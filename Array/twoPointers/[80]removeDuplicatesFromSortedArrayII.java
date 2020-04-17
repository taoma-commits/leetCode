class Solution {
  public int removeDuplicates(int[] nums) {
    int l = 1; // l points to the position to be done
    int count = 1; // count = current # of duplicates
    // r points to the position to be examed
    for (int r = 1; r < nums.length; r++) {
      if (nums[r] == nums[r - 1]) {
        count++;
      } else {
        count = 1;
      }
      if (count <= 2) {
        nums[l++] = nums[r];
      }
    }
    return l;
  }
}

/**
 * performance: 1 ms < 99%, 40 MB < 8%
 * time complexity: O(n)
 * space complexity: O(1)
 */
