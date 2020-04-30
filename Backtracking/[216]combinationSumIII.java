class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum3(int k, int n) {
    backtrack(k, n, 1, new ArrayList());
    return res;
  }
  private void backtrack(int nums, int sum, int i, ArrayList<Integer> temp) {
    if (nums == 0 || sum < i) {
      if (sum == 0 && nums == 0) res.add(new ArrayList(temp));
      return;
    }

    for (int j = i; j < 10; j++) {
      temp.add(j);
      backtrack(nums - 1, sum - j, j + 1, temp);
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: 0 ms < 100%
 * time complextiy:
 * space complexity: 
 */
