class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0, i = 0;
        while (reach <= nums.length - 1 && i <= reach) {
            reach = Math.max(nums[i] + i, reach);
            i++;
        }
        return (reach >= nums.length - 1);
    }
}

/*
* performance: 2 ms < 73%, 41 MB < 23%.
* time complexity: O(n)
* space complexity: O(1)
* notes: greedy
*/

class Solution {
  public boolean canJump(int[] nums) {
    int n = nums.length;
    int dp = 0;
    for (int i = 0; i < n - 1; i++) {
      dp = Math.max(nums[i] + i, dp);
      if (dp < i + 1) return false;
    }
    return true;
  }
}

/*
* same
*/
