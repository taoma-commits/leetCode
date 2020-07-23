class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    backtrack(1, k, n, new ArrayList());
    return res;
  }
  private void backtrack(int i, int l, int n, ArrayList<Integer> temp) {
    if (l == 0) {
      res.add(new ArrayList(temp));
      return;
    }
    if (i + l - 1 > n) return; // prune optimization 
    for (int j = i; j < n + 1; j++) {
      temp.add(j);
      backtrack(j + 1, l - 1, n, temp);
      temp.remove(temp.size() - 1);
    }
  }
}

/**
 * performance: 2 ms < 100%, 41 MB < 52%
 * time complexity: O(k * n! / ((n - k)! * k!))
 * space complexity: O(k * n! / ((n - k)! * k!))
 * notes: prune to optimize!
 */
