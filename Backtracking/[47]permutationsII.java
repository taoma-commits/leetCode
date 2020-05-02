class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    boolean[] seen = new boolean[nums.length];
    backtrack(nums, seen, new ArrayList());
    return res;
  }
  private void backtrack(int[] nums, boolean[] seen, ArrayList<Integer> temp) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList(temp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (seen[i]) continue;
      if (i > 0 && !seen[i - 1] && nums[i] == nums[i - 1]) continue;
      seen[i] = true;
      temp.add(nums[i]);
      backtrack(nums, seen, temp);
      seen[i] = false;
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: 2 ms < 84%, 40 MB < 12.5%
 * time complexity: O(n * n!)
 * space complexity: O(n * n!)
 */
