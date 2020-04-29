class Solution {
  private int[] id;
  private int[] sz;
  private boolean[][] grid;
  private int cpts = 0;

  private int find(int a) {
    while (a != id[a]) {
      id[a] = id[id[a]];
      a = id[a];
    }
    return a;
  }
  private void union(int a, int b) {
    int A = find(a), B = find(b);
    if (A == B) return;
    if (sz[A] < sz[B]) {
      id[A] = B;
      sz[B] += sz[A];
    } else {
      id[B] = A;
      sz[A] = sz[B];
    }
    cpts--;
  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> res = new ArrayList<>();

    id = new int[m * n];
    sz = new int[m * n];
    grid = new boolean[m][n];
    int i, j, idx;
    
    for (int[] p : positions) {
      i = p[0];
      j = p[1];
      if (!grid[i][j]) {
        idx = i * n + j;
        id[idx] = idx;
        sz[idx] = 1;
        cpts++;
        if (i > 0 && grid[i - 1][j]) union(idx, idx - n);
        if (i < m - 1 && grid[i + 1][j]) union(idx, idx + n);
        if (j > 0 && grid[i][j - 1]) union(idx, idx - 1);
        if (j < n - 1 && grid[i][j + 1]) union(idx, idx + 1);
        grid[i][j] = true;
      }
      res.add(cpts);
    }
    return res;
  }
}

/**
 * performance: 9 ms < 93%, 43 MB < 100%
 * time complexity: O(L * lg(L)) where L the number of positions.
 * space complexity: O(m * n)
 */
