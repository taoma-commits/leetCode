class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> getFactors(int n) {
    backtrack(n, 2, new ArrayList());
    return res;
  }

  private void backtrack(int left, int i, ArrayList<Integer> temp) {
    for (int j = i; j <= Math.sqrt(left); j++) {
      if (left % j == 0) {
        temp.add(j);
        backtrack(left / j, j, temp);
        temp.remove(temp.size() - 1);
      }
    }
    temp.add(left);
    if (temp.size() > 1) res.add(new ArrayList(temp));
    temp.remove(temp.size() - 1);
  }
}

/**
 * performance: 1 ms < 100%, 37 MB < 100%
 * time complexity: ??
 * space complexity: ??
 */
