class Solution {
  public List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum2(int[] nums, int target) {
    Arrays.sort(nums);
    backtrack(nums, nums.length - 1, target, new ArrayList());
    return res;
  }

  private void backtrack(int[] nums, int i, int rest, ArrayList<Integer> temp) {
    if (rest <= 0) {
      if (rest == 0) res.add(new ArrayList(temp));
      return;
    }
    for (int j = i; j >= 0; j--) {
      if (j < i && nums[j] == nums[j + 1]) continue; // key point
      temp.add(nums[j]);
      backtrack(nums, j - 1, rest - nums[j], temp);
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: 2 ms < 100%, 39 MB < 39%
 * time complexity: ??
 * space complexity: ??
 */
