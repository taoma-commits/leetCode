class Solution {
  public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    while (i < nums.length) {
      if (nums[i] != 0) {
        if (i != j) {
          nums[j] = nums[i];
          nums[i] = 0;
        }
        j++;
      }
      i++;
    }
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: optimize in extreme cases where nums are most zeros.
 */

 class Solution {
   public void moveZeroes(int[] nums) {
     int i = 0;
     int j = 0;
     while (i < nums.length) {
       if (nums[i] == 0) {
         i++;
       } else {
         nums[j++] = nums[i++];
       }
     }
     while (j < nums.length) {
       nums[j++] = 0;
     }
   }
 }

 /**
  * same
  * not optimized.
  */
