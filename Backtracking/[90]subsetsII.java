class Solution {
  List<List<Integer>> res = new ArrayList<>();

  private void backtrack(int i, int[] nums, ArrayList<Integer> temp) {
    if (i == nums.length) {
      res.add(new ArrayList(temp));
      return;
    }
    if (temp.isEmpty() || temp.get(temp.size() - 1) != nums[i]) {
      backtrack(i + 1, nums, temp);
    }
    temp.add(nums[i]);
    backtrack(i + 1, nums, temp);
    temp.remove(temp.size() - 1);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backtrack(0, nums, new ArrayList());
    return res;
  }
}

/**
 * performance: 1 ms < 100%, 39.8 MB < 6%
 * time complexity: O(n * 2^n)
 * space complexity: O(n * 2^n)
 * notes: backtracking prune 
 */
