class Solution {
  int count = 0;
  public int combinationSum4(int[] nums, int target) {
    backtrack(nums, target, new ArrayList());
    return count;
  }

  private void backtrack(int[] nums, int sum, ArrayList<Integer> temp) {
    if (sum <= 0) {
      if (sum == 0) count++; 
      return;
    }
    for (int num : nums) {
      temp.add(num);
      backtrack(nums, sum - num, temp);
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: ETL with test example 32, [1,2,3]
 */
 
class Solution {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i < target + 1; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] <= i) dp[i] += dp[i - nums[j]];
      }
    }
    return dp[target];
  }
}

/**
 * performance: 1 ms < 100%, 37 MB < 11%
 * time complexity: O(target * nums.length)
 * space complexity: O(target)
 */
 
 
