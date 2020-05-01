class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
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
      temp.add(nums[i]);
      seen[i] = true;
      backtrack(nums, seen, temp);
      seen[i] = false;
      temp.remove(temp.size() - 1);
    }
  }
}

/** 
 * performance: 2 ms < 80%, 40 MB < 7%
 * time complexity: O(n * n!)
 * space complexity: O(n * n!)
 * notes: use an array seen to mark visited nums. 
 * The use of extra space keeps the outcome in lexicographical order
 * if the given array nums is sorted!
 */
 
