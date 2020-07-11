class Solution {
  public void wiggleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (((i & 1) == 0) == (nums[i] > nums[i + 1])) {
        int cache = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = cache;
      }
    }
  }
}

/**
 * performance: 1 ms < 95%
 * time complexity: O(n)
 * space complexity: O(1)
 */


class Solution {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    if ((n & 1) == 0) n--;
    for (int i = 1; i < (n >> 1) + 1; i += 2) {
      int cache = nums[i];
      nums[i] = nums[n - i];
      nums[n - i] = cache;
    }
  }
}

/**
 * performance: 4 ms < 8%
 * time complexity: O(n*log(n))
 * space complexity: O(1)
 */
