class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backtrack(candidates, 0, target, new ArrayList());
    return res;
  }
  private void backtrack(int[] candidates, int i, int rest, ArrayList<Integer> temp) {
    if (rest <= 0) {
      if (rest == 0) res.add(new ArrayList(temp));
      return;
    }
    for (int j = i; j < candidates.length; j++) {
      temp.add(candidates[j]);
      backtrack(candidates, j, rest - candidates[j], temp);
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: 3 ms < 93%
 * time complexity: ??
 * space complexity: ??
 */
