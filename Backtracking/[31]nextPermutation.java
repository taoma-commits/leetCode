class Solution {
  int n;
  public void nextPermutation(int[] nums) {
    n = nums.length;
    int i = n - 2;
    while (i > -1 && nums[i] >= nums[i + 1]) i--;
    if (i > -1) {
      int j = i;
      while (j < n - 1 && nums[i] < nums[j + 1]) j++;
      this.swap(nums, i, j);
    }
    this.reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int i) {
    int l = i, r = n - 1;
    while (r > l) {
      this.swap(nums, l++, r--);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

/**
 * performance: 1 ms < 100%, 40 MB < 44%
 * time complexity: O(n)! 
 * space complexity: O(1)
 */
