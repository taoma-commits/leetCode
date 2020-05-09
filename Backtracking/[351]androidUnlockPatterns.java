class Solution {
  int count = 0;
  boolean[] visited = new boolean[10]; 
  public int numberOfPatterns(int m, int n) {
    backtrack(0, 0, m, n);
    return count;
  }
  private void backtrack(int i, int len, int m, int n) {
    if (len > n) return;
    if (len > m - 1) count++;
    for (int j = 1; j < 10; j++) {
      if (visited[j]) continue;
      if (isValid(i, j)) {
        visited[j] = true;
        backtrack(j, len + 1, m, n);
        visited[j] = false;
      }
    }
  }
  private boolean isValid(int i, int j) {
    if (i == 5 || j == 5) return true;
    if (i + j == 10) return visited[5];
    if ((i & 1) == 1 && (j & 1) == 1) return visited[(i + j) / 2];
    return true;
  }
}

/**
 * performance: 45 ms < 56%, 36.5 MB < 50% 
 * time complexity:
 * space complexity:
 */
