class Solution {
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    int i = 0;
    int j = 0;
    int iA = -1;
    int jA = -1;
    while (i < m) {
      if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
        i++;
        j++;
      } else if (j < n && p.charAt(j) == '*') {
        iA = i;
        jA = j++;
      } else if (iA > -1) {
        i = ++iA;
        j = jA + 1;
      } else return false;
    }
    while (j < n && p.charAt(j) == '*') j++;
    return j == n; 
  }
}

/**
 * performance: 3 ms < 100%
 * time complexity: O(m * log(n)). [Proof](https://arxiv.org/pdf/1407.0950.pdf)
 * space complexity: O(1)
 * notes: backtracking
 */
 
class Solution {
  public boolean isMatch(String s, String p) {
    int m = p.length();
    int n = s.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 1; i < m + 1; i++) {
      if (p.charAt(i - 1) == '*') {
        int k = 0;
        while (k < n + 1 && !dp[i - 1][k]) k++;
        for (int j = k; j < n + 1; j++) {
          dp[i][j] = true;
        }
      } else if (p.charAt(i - 1) == '?') {
        for (int j = 1; j < n + 1; j++) {
          dp[i][j] = dp[i - 1][j - 1];
        }
      } else {
        for (int j = 1; j < n + 1; j++) {
          dp[i][j] = dp[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1));
        }
      }
    }
    return dp[m][n];
  }
}

/**
 * performance: 18 ms < 75%
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 */
