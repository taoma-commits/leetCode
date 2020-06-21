class Solution {
  public void sortColors(int[] nums) {
    int lt = 0;
    int gt = nums.length - 1;
    int i = 0;
    while (i <= gt) {
      if (nums[i] < 1) {
        // bug be careful
        nums[i++] = nums[lt];
        nums[lt++] = 0;
      } else if (nums[i] > 1) {
        nums[i] = nums[gt];
        nums[gt--] = 2;
      } else {
        i++;
      }
    }
  }
}

/**
 * performance: worst O(n^2), averrage O(n*log n)
 * space complexity: O(1)
 * notes: before i left lt, nums[lt] = nums[i] < partition element.
 */
