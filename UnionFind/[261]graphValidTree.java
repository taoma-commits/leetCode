class Solution {
  class UF {
    int[] id;
    int[] sz;
    int cpts;
    public UF(int n) {
      cpts = n;
      id = new int[n];
      sz = new int[n];
      for (int i = 0; i < n; i++) {
        id[i] = i;
        sz[i] = 1;
      }
    }
    public void union(int a, int b) {
      int A = find(a), B = find(b);
      if (A == B) return;
      if (sz[A] < sz[B]) {
        id[A] = B;
        sz[B] += sz[A];
      } else {
        id[B] = A;
        sz[A] += sz[B];
      }
      cpts--;
    }
    public boolean connected(int a, int b) {
      return find(a) == find(b);
    }
    private int find(int a) {
      if (a != id[a]) {
        id[a] = id[id[a]];
        a = id[a];
      }
      return a;
    }
  }

  public boolean validTree(int n, int[][] edges) {
    UF uf = new UF(n);
    for (int[] e : edges) {
      if (uf.connected(e[0], e[1])) {
        return false;
      }
      uf.union(e[0], e[1]);
    }
    return uf.cpts == 1;
  }
}

/**
 * performance: 1 ms < 91%, 40 MB < 100%
 * time complexity: O(m*lg(n)) where m is number of edges.
 * space complexity: O(n)
 */
