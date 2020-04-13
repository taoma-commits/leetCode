class Solution {
  List<String> res = new ArrayList<>();
  private void backtrack(int numLP, int sum, String str) {
    if (numLP == 0 && sum == 0) {
      res.add(str);
    } else {
      if (sum > 0) {
        backtrack(numLP, sum - 1, str + ")");
      }
      if (numLP > 0) {
        backtrack(numLP - 1, sum + 1, str + "(");
      }
    }
  }

  public List<String> generateParenthesis(int n) {
    int numLP = n;
    int sum = 0;
    backtrack(numLP, sum, "");
    return res;
  }
}

/**
 * performance: 1 ms < 98%, 40 MB < 5%
 * notes: backtracking 
 */
