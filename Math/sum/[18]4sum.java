class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    if (n < 4) return res;
    int min = Math.min(target, 0);
    int max = Math.max(target, 0);
    Arrays.sort(nums);
    if (nums[0] > max || nums[n - 1] < min) return res;
    for (int i = 3; i < n; i++) {
      if (i < n - 1 && nums[i] == nums[i + 1]) continue;
      for (int j = i - 1; j > 1; j--) {
        if (j < i - 1 && nums[j] == nums[j + 1]) continue;
        int twoSum = target - nums[i] - nums[j];
        int l = 0, r = j - 1;
        int L = 0, R = 0;
        while (l < r) {
          L = nums[l];
          R = nums[r];
          if (L + R == twoSum) {
            List<Integer> four = new ArrayList();
            four.add(L);
            four.add(R);
            four.add(nums[j]);
            four.add(nums[i]);
            res.add(four);
          }
          if (L + R <= twoSum) {
            while (l < r && nums[l++] == nums[l]);
          }
          if (L + R >= twoSum) {
            while (l < r && nums[r--] == nums[r]);
          }
        }
      }
    }
    return res;
  }
}

/**
 * performance:
 * time complexity:
 * space complexity: 
 */
