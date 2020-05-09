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
 * time complexity: O(n!), n < 10
 * space complexity: O(n), the depth of recursion. 
 */

class Solution {
  int count = 0;
  int[][] grid = new int[10][10];
  boolean[] visited = new boolean[10];

  public int numberOfPatterns(int m, int n) {
    grid[1][3] = 2;
    grid[3][1] = 2;
    grid[3][9] = 6;
    grid[9][3] = 6;
    grid[7][1] = 4;
    grid[1][7] = 4;
    grid[7][9] = 8;
    grid[9][7] = 8;

    for (int i = 1; i < 5; i++) {
      grid[i][10 - i] = 5;
      grid[10 - i][i] = 5;
    }

    int res = 0;

    visited[1] = true;
    backtrack(1, 1, m, n);
    visited[1] = false;
    res += count * 4;
    count = 0;

    visited[2] = true;
    backtrack(2, 1, m, n);
    visited[2] = false;
    res += count * 4;
    count = 0;
    
    visited[5] = true;
    backtrack(5, 1, m, n);
    visited[5] = false;
    res += count;
    return res;
  }

  private void backtrack(int i, int len, int m, int n) {
    if (len == n) {
      count++;
      return;
    }
    if (len > m - 1) {
      count++;
    }
    for (int j = 1; j < 10; j++) {
      if (visited[j]) continue;
      int g = grid[i][j];
      if (g == 0 || visited[g]) {
        visited[j] = true;
        backtrack(j, len + 1, m, n);
        visited[j] = false;
      }
    }
  }
}

/**
 * performance: 8 ms < 97%, 36.5 MB < 50%
 * time complexity: O(n!), n < 10
 * space complexity: O(n), the depth of recursion. 
 */
