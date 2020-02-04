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
* performance: 2 ms < 62%, 41 MB < 23%.
* notes: greedy, update furthest position can be reached.
* companies: Amazon, Google, Microsoft.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] memo = new int[len];
        for (int i = 0; i < len - 1; i++) {
            memo[i] = 0;
        }
        memo[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            int reach = Math.min(nums[i] + i, len - 1);
            for (int j = i + 1; j <= reach; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }
        return memo[0] == 1;
    }
}

/*
* performance: 223 ms < 20%, 41 MB < 9%.
* notes:
      1. DP solution. Bottom-up dp avoids recursion.
      2. use int[] to memorize previous results.
*/
