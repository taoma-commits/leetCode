class Solution {
  int n;
  boolean[][] dp;
  List<List<String>> res = new ArrayList<>();

  public List<List<String>> partition(String s) {
    int n = s.length();
    dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if ( (j - i < 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
          dp[i][j] = true;
        }
      }
    }
    backtrack(s, 0, n, new ArrayDeque<String>());
    return res;
  }

  private void backtrack(String s, int start, int end, Deque<String> stack) {
    if (start == end) {
      res.add(new ArrayList<>(stack)); // found a partition
    }

    for (int j = start; j < end; j++) {
      if (!dp[start][j]) {
        continue; // prune tree
      }
      stack.addLast(s.substring(start, j + 1));
      backtrack(s, j + 1, end, stack);
      stack.removeLast(); // backtrack up to the precedent state
    }
  }
}

/**
 * performance: 2 ms < 100%, 40 MB < 16%
 * notes: 1. backtracking step use stack.
 */
