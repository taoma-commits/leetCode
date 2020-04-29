class Solution {
  class UF {
    public int[] id;
    public int[] sz;
    public int cpts;
    public UF(int n) {
      id = new int[n];
      sz = new int[n];
      cpts = n;
      for (int i = 0; i < n; i++) {
        id[i] = i;
        sz[i] = 1;
      }
    }
    public int find(int a) {
      while (a != id[a]) {
        id[a] = id[id[a]];
        a = id[a];
      }
      return a;
    }
    public void union(int a, int b) {
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
  }
  public int countComponents(int n, int[][] edges) {
    UF uf = new UF(n);
    for (int[] e : edges) {
      uf.union(e[0], e[1]);
    }
    return uf.cpts;
  }
}

/**
 * performance: 1 ms < 100%, 40 MB < 100%
 * time complexity: O(m * lg(n))
 * space complexity: O(n)
 */
